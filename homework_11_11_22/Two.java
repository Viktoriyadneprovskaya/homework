import java.util.Scanner;

public class Two {
  
    public static void main(String[] args) {
          
        Scanner input = new Scanner(System.in);
          System.out.println("Enter array length: ");
          int size = input.nextInt();
          int[] ArrayName = new int[size];
          System.out.println("Insert array elements: ");
          for (int i = 0; i < ArrayName.length; i++) {
          ArrayName[i] = input.nextInt();
          }
          System.out.println("Inserted array elements: ");
		  int sum = 0;
          for (int i = 0; i < ArrayName.length; i++) {
          System.out.print(ArrayName[i] + " ");
		  if (ArrayName[i]>0) {
          sum+=ArrayName[i];
          }
          }
          System.out.println();
		  System.out.print ("The sum of positive massive elements = " + sum); 
		  input.close();
          } 
}