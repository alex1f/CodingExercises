import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HW4_E_Forum {
    private static int postId = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:/input.txt"));
        String line;

        Map<Integer, String> mapOfPostsToTopics = new HashMap<>();
        Map<String, Integer> mapOfTopicsToEarliestPost = new HashMap<>();
        List<ForumPost> posts = new ArrayList<>();

        reader.readLine();

        while ( (line = reader.readLine()) != null){
            String topic;
            int code = Integer.parseInt(line);
            if (code == 0){
                topic = reader.readLine();
                mapOfTopicsToEarliestPost.put(topic, postId);
            } else {
                topic = mapOfPostsToTopics.get(code);
            }

            mapOfPostsToTopics.put(postId, topic);
            posts.add(new ForumPost(topic, postId));
            postId++;
            reader.readLine();
        }

        mapOfPostsToTopics = null;
        System.out.println(getMostPopularThread(posts, mapOfTopicsToEarliestPost));


    }

    public static String getMostPopularThread(List<ForumPost> posts, Map<String, Integer> mapOfTopicsToEarliestPost){
     List<Map.Entry<String, Long>> popularPosts =
             posts.stream()
             .collect(Collectors.groupingBy(ForumPost::getTopic, Collectors.counting()))
             .entrySet()
             .stream()
             .sorted((entry1, entry2) ->  entry2.getValue().compareTo(entry1.getValue()))
             .collect(Collectors.toList());

     Long maxPosts = popularPosts.get(0).getValue();

     long max = 0;
     int earliestPost = 1000;
     String topic = popularPosts.get(0).getKey();

     for (int i = 0; i < popularPosts.size(); i++){
         Map.Entry<String, Long> entry = popularPosts.get(i);
         long numberOfPosts = entry.getValue();
         int earliestPostID = mapOfTopicsToEarliestPost.get(entry.getKey());

         if (numberOfPosts >= max && earliestPostID < earliestPost){
             max = numberOfPosts;
             earliestPost = earliestPostID;
             topic = entry.getKey();
         }
     }


     return topic;
    }

}

class ForumPost{
    private final String topic;
    private final int postId;

    public ForumPost(String topic, int postId) {
        this.topic = topic;
        this.postId = postId;
    }

    public String getTopic() {
        return topic;
    }

}