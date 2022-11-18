//написать программу. которая принимает из потока два значения: высота и ширина двумерного массива
//создает 2 двумерных массива на основании этих значений
//заполняет оба массива рандомными числами от 0 до 100
//вывести 3 массив,сложив 2ва предыдущих и вывести на экран
//высота и ширина не может быть меньше 3 и больше 5


import java.util.Scanner;

public class DzEight {
  
    public static void main(String[] args) {
          
          Scanner input = new Scanner(System.in);
          System.out.println("Enter array width from 3 to 5: ");
          int width = input.nextInt();
          System.out.println("Enter array height from 3 to 5: ");
          int height = input.nextInt();
          if (width < 3 || width > 5 || height < 3 || height >5) {
          System.out.println("You entered wrong width or height");
          }
		  else {
          int[][] ArrayNameOne = new int[width][height];
          for (int i = 0; i < ArrayNameOne.length; i++) {
             for (int j = 0; j< ArrayNameOne[i].length; j++){
             ArrayNameOne[i][j]= (int) (Math.random()*100);
          }
		  }
		  int[][] ArrayNameTwo = new int[width][height];
          for (int i = 0; i < ArrayNameTwo.length; i++) {
             for (int j = 0; j< ArrayNameTwo[i].length; j++)
             ArrayNameTwo[i][j]= (int) (Math.random()*100);
          }
		  int[][] ArrayNameThree = new int[width][height];
          for (int i = 0; i < ArrayNameThree.length; i++) {
             for (int j = 0; j< ArrayNameThree[i].length; j++)
             ArrayNameThree[i][j]= ArrayNameOne[i][j] + ArrayNameTwo[i][j] ;
          }
		  System.out.println("Array One: ");
          for (int i = 0; i < ArrayNameOne.length; i++) {
             for (int j = 0; j< ArrayNameOne[i].length; j++){
             System.out.print(ArrayNameOne[i][j] + " ");
		  }
		   System.out.println();
		  }
		   System.out.println();
		   System.out.println("Array Two: ");
          for (int i = 0; i < ArrayNameTwo.length; i++) {
             for (int j = 0; j< ArrayNameTwo[i].length; j++){
             System.out.print(ArrayNameTwo[i][j] + " ");
          }
		  System.out.println();
		  }
		  System.out.println();
		  System.out.println("Array Three: ");
		  for (int i = 0; i < ArrayNameThree.length; i++) {
             for (int j = 0; j< ArrayNameThree[i].length; j++) {
             System.out.print(ArrayNameThree[i][j] + " ");
          }
		  System.out.println();
		  }
          input.close();
		  }
          } 
}