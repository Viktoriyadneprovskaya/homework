//класс, который выводит в консоль массив чисел от n (заданное из потока сканер) до 1. Если n==0 || n<0 вывести на экран сообщение

import java.util.Scanner;

public class DzTwo {
  
    public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          System.out.println("Enter the massive max num value to show(num must be bigger than 1: ");
          int size = input.nextInt();
          if (size <= 1) {
		  do {
          System.out.println("You entered error number. Number must be bigger than 1. Enter again:");
          size = input.nextInt();
          } while(size <= 1);
          }
		  int[] ArrayName = new int[size];
          System.out.println("The numbers between your number and 1:");
          for (int i = size-1; i > 1; i--) {
          System.out.print(i + " ");
         }
         }
         }
		 