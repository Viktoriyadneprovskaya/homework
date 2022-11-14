public class One {
  
    public static void main(String[] args) {
          
        int[] Arr = new int[10]; 
          System.out.print("Your random numbers: \n");
        for (int i=0; i<Arr.length; i++) {
          Arr[i] = (int) (Math.random()*200 - 100);
          System.out.print(Arr[i] + " ");
         }
		  System.out.println();
		  int sum=0;
          System.out.print("Sum of Absolute arr value: \n");
        for (int i=0; i<Arr.length; i++){
		  sum+= Math.abs (Arr[i]);
         }
		  System.out.print(sum);
	}
}