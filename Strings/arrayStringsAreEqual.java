class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 ="";
        String s2= "";
        for(String c:word1){
            s1 = s1+c;
        }
          for(String c:word2){
            s2 = s2+c;
        }
        return s1.equals(s2);
    }
}