public class One {
  
    public static void main(String[] args) {
          
        int[] Arr = new int[10]; 
          System.out.print("Your random numbers: \n");
        for (int i=0; i<Arr.length; i++) {
          Arr[i] = (int) (Math.random()*200 - 100);
          System.out.print(Arr[i] + " ");
         }
		  System.out.println();
          System.out.print("Absolute arr value: \n");
        for (int i=0; i<Arr.length; i++){
          System.out.print(Math.abs (Arr[i]) + " ");
         }
	}
}