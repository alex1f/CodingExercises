package leetcode;

public class Leet392_Subsequence {
    public boolean isSubsequence(String candidate, String target) {

        int matchesFound = 0;
        int targetCurrentIndex = 0;
        for (int i = 0; i < candidate.length(); i++){
            for (int j = targetCurrentIndex; j < target.length(); j++){
                if (candidate.charAt(i) == target.charAt(j)){
                    matchesFound++;
                    targetCurrentIndex = j+1;
                    break;
                }
            }
        }

        return matchesFound == candidate.length();
    }
}
