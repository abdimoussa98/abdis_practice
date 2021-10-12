
public class LongestCommonSubsequence_BRUTE {
    public static void main(String[] args) {
        String s1 = "HARRY";
        int i = s1.length() - 1;
        String s2 = "SALLY";
        int j = s2.length() - 1;
        System.out.println(LCS(s1,s2,i,j));
    }

    static int LCS(String s1, String s2, int i, int j){

        if (i == -1 || j == -1) {
            return 0;
        }
        if (s1.charAt(i) == s2.charAt(j)){
            return 1 + LCS(s1, s2, i - 1, j - 1);
        }
        return Math.max(LCS(s1, s2, i - 1, j), LCS(s1, s2, i, j - 1));
    }
}
