class Solution {
    public char findTheDifference(String s, String t) {
        int sumS = 0;
        int sumT = 0;
        for(char C : s.toCharArray()){
            sumS=sumS+C;
        }
            for(char C : t.toCharArray()){
            sumT=sumT+C;
        }
       char result = (char)(sumT - sumS);

        return result;


     
    }
}