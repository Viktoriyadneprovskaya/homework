import java.util.Scanner;

public class Nine {
  
    public static void main(String[] args) {
          
          Scanner input = new Scanner(System.in);
          System.out.println("Enter array length: ");
          int size = input.nextInt(); 
          int ArrayName[] = new int[size]; 
          System.out.println("Insert array elements:");
          for (int i = 0; i < size; i++) {
          ArrayName[i] = input.nextInt();
          }
          System.out.print("Inserted array elements:");
          for (int i = 0; i < size; i++) {
          System.out.print(ArrayName[i] + " ");
          }
          System.out.println();
          int AmountPozitive=0;
          int Sum = 0;
          for (int i = 0; i < size; i++) {
          if (ArrayName[i] > 0){
          AmountPozitive++;
          }
          if (ArrayName[i] < 0) {
          Sum += ArrayName[i];
          }
          }
          System.out.println("Positive elements amount: " + AmountPozitive);
          System.out.print("Negative elements sum: " + Sum);
		  input.close();
	}
}