class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){return false;} 
        else{
            char[] arrS = s.toCharArray();
             char[] arrt = t.toCharArray();
             Arrays.sort(arrS);
             Arrays.sort(arrt);
             if(Arrays.equals(arrS,arrt)){
                return true;
             }
        }
return false;
    }
}