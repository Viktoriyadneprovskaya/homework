//из сканера принимает целочисленное число, выводим на экран положительное или отрицательное. Если 0,то сообщение об этои и завершение
//Обработать получение не численных значений

import java.util.Scanner;

public class DzSix {
  
    public static void main(String[] args) {
          
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer number: ");
        String num_str = input.nextLine();
        //if (num != number) { //все работает, кроме этого if
        if (!isNumeric(num_str)) {
          System.out.println("Entered value isn't a number");
        }
        else {
         int num =Integer.parseInt(num_str);
         if (num > 0) {
         System.out.println("Entered number is pozitive");
        }
        else if (num == 0) {
        System.out.println("Entered number is 0");
        }
        else {
        System.out.println("Entered number is negative");
        }
        input.close();
}
}
public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}