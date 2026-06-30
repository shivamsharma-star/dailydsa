// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Bubblesort{
    public static void main(String[] args) {
        int[] myArray = {52,36,32,12,35,63,16,32,56,85,69,74,45};
        int lengthOfArray =  myArray.length;
        System.out.print(lengthOfArray);
        // int i=0;
        // int j=0;
    
        for(int i=0; i<lengthOfArray-1;i++){
            
            for(int j=0;j< lengthOfArray-i-1;j++){
                
                if(myArray[j]>myArray[j+1]){
                    
                    int temp = myArray[j];
                    myArray[j] = myArray[j+1];
                    myArray[j+1]=temp;
                }
                else{
                    continue;
                }
                
            }
        }
        
        for(int k=0;k<lengthOfArray-1;k++){
            System.out.println(myArray[k]);
        }
    }
}