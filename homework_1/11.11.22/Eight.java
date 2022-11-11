import java.util.Scanner;

public class Eight {
  
    public static void main(String[] args) {
          
          Scanner in = new Scanner(System.in);
          System.out.println("Enter array length: ");
          int size = in.nextInt(); 
          int ArrayName[] = new int[size]; 
          System.out.println("Insert array elements:");
          for (int i = 0; i < size; i++) {
          ArrayName[i] = in.nextInt();
          }
          System.out.print("Inserted array elements:");
          for (int i = 0; i < size; i++) {
          System.out.print(ArrayName[i] + " ");
          }
          System.out.println();
		  System.out.println("Array elements * 2:");
          for (int i = 0; i < size; i++) {
          ArrayName[i]*= 2;
          System.out.print(ArrayName[i] + " "); 
          }
		  in.close();
	}
}