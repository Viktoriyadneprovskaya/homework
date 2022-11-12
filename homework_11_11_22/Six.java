import java.util.Scanner;

public class Six {
  
    public static void main(String[] args) {
          
          Scanner input = new Scanner(System.in);
          System.out.println("Enter array length: ");
          int size = input.nextInt();
          int ArrayName[] = new int[size];
          System.out.println("Insert array elements: ");
          for (int i = 0; i < size; i++) {
          ArrayName[i] = input.nextInt();
          }
          System.out.println("Inserted array elements: ");
          for (int i = 0; i < size; i++) {
          System.out.print(ArrayName[i] + " ");
          }
          System.out.println();
          System.out.println("Reverse array elements: ");
          for (int i = size-1; i >= 0; i--) {
          System.out.print (ArrayName[i] + " ");
          }
		  input.close();
}
}