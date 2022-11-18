//Класс, который выводит в консоль среднее значение элементов целочисленного массива. Ввод через сканер

import java.util.Scanner;

public class DzOne {
  
    public static void main(String[] args) {
          
          Scanner input = new Scanner(System.in);
          System.out.println("Enter array length: ");
          int size = input.nextInt();
          int[] ArrayName = new int[size];
          System.out.println("Insert array elements: ");
          for (int i = 0; i < ArrayName.length; i++) {
          ArrayName[i] = input.nextInt();
          }
          int sum =0;
          for (int i = 0; i < ArrayName.length; i++) {
          sum+=ArrayName[i];
          }
          System.out.println();
          System.out.print ("Massive elements evarage value = " + sum/ArrayName.length); 
          input.close();
          } 
}