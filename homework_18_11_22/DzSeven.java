//написать программу нахождения факториала числа, число получаем из сканера, результат выводим на экран

import java.util.Scanner;

public class DzSeven {
  
    public static void main(String[] args) {
          
          Scanner input = new Scanner(System.in);
          System.out.println("Enter a number: ");
          int num = input.nextInt();
          int factorial = 1;
		  for (int i=1; i<=num; i++) {
          factorial *= i;
		  }
		  System.out.println("Entered factorial number = " + factorial);
          input.close();
          } 
}
