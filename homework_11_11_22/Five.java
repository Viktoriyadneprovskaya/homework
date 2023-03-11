public class Five {
  
    public static void main(String[] args) {
          
        int[] Arr = new int[10]; 
          System.out.println("Your random numbers:");
        for (int i = 0; i < Arr.length; i++) {
          Arr[i] = (int) (Math.random()*200 - 100);
          System.out.print(Arr[i] + " ");
         }
		  System.out.println();
		  int minimum_value = Arr[0];
        for (int i = 1; i < Arr.length; i++){
		  minimum_value = Math.min(minimum_value, Arr[i]);
         }
		 System.out.print("Min array value = " + minimum_value + " ");
	}
}