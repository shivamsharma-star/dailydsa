class Solution {
    public int lengthOfLastWord(String s) {
        String[] subString = s.split(" ");
        return subString[subString.length-1].length();
     
    }
   
}