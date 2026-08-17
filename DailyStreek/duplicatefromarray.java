import java.util.HashMap;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap <Integer,Integer>mymap = new HashMap<>();
        for(int num :nums){
            if(mymap.containsKey(num)){
                return true;
            }else{
                mymap.put(num,num);
            }
        }
        return false;
    }

}