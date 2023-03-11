//класс, который из сканера принимает число с плав точкой и выводит на экран:1)число, округленное к меньшему целочисленному значению
//2) само число 3) к большему целочисленному значению. Использовать Math
import java.util.Scanner;

public class DzFive {
  
    public static void main(String[] args) {
          
          Scanner input = new Scanner(System.in);
          System.out.println("Enter number: ");
          float num = input.nextFloat();
          System.out.println("Number = " + num);
          System.out.println("Number rounded down = " + Math.floor(num));
          System.out.println("Number rounded up = " + Math.ceil(num)); //или Math.rint
          input.close();
          } 
}