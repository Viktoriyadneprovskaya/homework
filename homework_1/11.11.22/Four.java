import java.util.Scanner;

public class Four {
  
    public static void main(String[] args) {
          
          int Sum = 0;
          Scanner input = new Scanner(System.in);
          System.out.println("Enter array length: ");
          int size = input.nextInt(); 
          int ArrayName[] = new int[size]; 
          System.out.println("Insert array elements:");
          for (int i = 0; i < size; i++) {
          ArrayName[i] = input.nextInt();
          }
          System.out.println("Inserted array elements pow2:");
          for (int i = 0; i < size; i++) {
          System.out.print (Math.pow(ArrayName[i],2) + " ");
          Sum+=Math.pow(ArrayName[i],2);
          }
		  System.out.println();
          System.out.print("The sum of massive elements power2  = " + Sum); 
		  input.close();
          }	  
          }
