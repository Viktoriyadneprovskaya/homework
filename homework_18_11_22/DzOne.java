//Класс, который выводит в консоль среднее значение элементов целочисленного массива. Ввод через сканер

import java.util.Scanner;

public class DzOne {
  
    public static void main(String[] args) {
          
          Scanner input = new Scanner(System.in);
          System.out.println("Enter array length: ");
          int size = input.nextInt();
          int[] arrayName = new int[size];
		  int sum =0;
          System.out.println("Insert array elements: ");
          for (int i = 0; i < arrayName.length; i++) {
          arrayName[i] = input.nextInt();
		  sum+=arrayName[i];
          }
          System.out.println();
          System.out.print ("Massive elements evarage value = " + sum/arrayName.length); 
          input.close();
          } 
}