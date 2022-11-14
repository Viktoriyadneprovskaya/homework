import java.util.Scanner;

public class Three {
  
    public static void main(String[] args) {
          int[] Arr = new int[20]; 
		  int sortMax;
          System.out.print("Your random numbers: \n");
          for (int i = 0; i<Arr.length; i++) {
          Arr[i] = (int)(Math.random()*200 - 100);
          System.out.print(Arr[i] + " ");
          }
          do {
          Scanner input = new Scanner(System.in);
		  System.out.println();
          System.out.println("Enter value  of random massive max num to show(num must be bigger than 1: ");
          sortMax = input.nextInt();
          } while(sortMax < 1);
          int sum = 0;
          for (int i = 0; i < Arr.length; i++) {
          if (Arr[i] > 0 && Arr[i] < sortMax){
          sum+= Arr[i];
          }
          }
          System.out.print("The sum between 1 and " + sortMax + " = " + sum);
         }
         }
		 
		 