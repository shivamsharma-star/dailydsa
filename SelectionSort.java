class Selectionsort{

public static void main(String args[]){
    int [] nums ={52,85,54,66,96,98,63,36,65,44,58,59,52,100};
    System.out.print(nums);
    int sizeOfArray = nums.length;
    // upper array from start to end 
    for(int i=0;i<sizeOfArray-1;i++){
        // inner array from i to end 
        int minIndex=i;
        for(int j=i+1;j<sizeOfArray-1;j++){
            if(nums[j]<nums[minIndex]){
                minIndex = j;
            
            }
            else{
                continue;
            }

        }
        int temp = nums[i];
        nums[i]=nums[minIndex];
        nums[minIndex] = temp;

    }
   for(int k=0;k< sizeOfArray-1;k++){
            System.out.println(nums[k]);
        }
}



}