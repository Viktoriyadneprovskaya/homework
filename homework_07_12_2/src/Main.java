import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int change;
        do {
            System.out.println("Do you want to enter enteger  or double number? 1-enteger, 2-double, 3-exit");
            change = input.nextInt();
            if (change == 1) {
                System.out.println("1. Get sum \n2. Get difference\n3. Get multiply\n4. Get divide\n5.Max value\n6.Min value\n7.Get exponentiation\n8.Get%\n9.Square");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Input first number");
                        int a = input.nextInt();
                        System.out.println("Input second number");
                        int b = input.nextInt();
                        System.out.println("First number+second number = " + Calculate.getSum(a, b));
                        break;
                    case 2:
                        System.out.println("Input first number");
                        a = input.nextInt();
                        System.out.println("Input second number");
                        b = input.nextInt();
                        System.out.println("First number-second number = " + Calculate.getDifference(a, b));
                        break;
                    case 3:
                        System.out.println("Input first number");
                        a = input.nextInt();
                        System.out.println("Input second number");
                        b = input.nextInt();
                        System.out.println("First number*second number = " + Calculate.getMultiply(a, b));
                        break;
                    case 4:
                        System.out.println("Input first number");
                        a = input.nextInt();
                        System.out.println("Input second number");
                        b = input.nextInt();
                        System.out.println("First number:second number = " + Calculate.getDivided(a, b));
                        break;
                    case 5:
                        System.out.println("Input first number");
                        a = input.nextInt();
                        System.out.println("Input second number");
                        b = input.nextInt();
                        System.out.println("The biggest value = " + Calculate.getMaximum(a, b));
                        break;
                    case 6:
                        System.out.println("Input first number");
                        a = input.nextInt();
                        System.out.println("Input second number");
                        b = input.nextInt();
                        System.out.println("The lowest value = " + Calculate.getMinimum(a, b));
                        break;
                    case 7:
                        System.out.println("Input a number");
                        a = input.nextInt();
                        System.out.println("Input power");
                        b = input.nextInt();
                        System.out.println("The result of exponentiation = " + Calculate.getExponentiation(a, b));
                        break;
                    case 8:
                        System.out.println("Input a number");
                        a = input.nextInt();
                        System.out.println("Input %");
                        b = input.nextInt();
                        System.out.println("The result of exponentiation =" + Calculate.getPercent(a, b));
                        break;
                    case 9:
                        System.out.println("Input a number");
                        a = input.nextInt();
                        System.out.println(a);
                        //1
                        System.out.println("The result of take the square = " + Calculate.getSquare(a));
                        break;
                    default:
                        System.out.println("Wrong choice!");
                        break;
                }
            } else if (change == 2) {
                System.out.println("1. Get sum \n2. Get difference\n3. Get multiply\n4. Get divide\n5.Max value\n6.Min value\n7.Get exponentiation\n8.Get%\n9.Max int value\n10.Min int value");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Input first number");
                        double a = input.nextDouble();
                        System.out.println("Input second number");
                        double b = input.nextDouble();
                        System.out.println("First number+second number = " + Calculate.getSum(a, b));
                        break;
                    case 2:
                        System.out.println("Input first number");
                        a = input.nextDouble();
                        System.out.println("Input second number");
                        b = input.nextDouble();
                        System.out.println("First number-second number = " + Calculate.getDifference(a, b));
                        break;
                    case 3:
                        System.out.println("Input first number");
                        a = input.nextDouble();
                        System.out.println("Input second number");
                        b = input.nextDouble();
                        System.out.println("First number*second number = " + Calculate.getMultiply(a, b));
                        break;
                    case 4:
                        System.out.println("Input first number");
                        a = input.nextDouble();
                        System.out.println("Input second number");
                        b = input.nextDouble();
                        System.out.println("First number:second number = " + Calculate.getDivided(a, b));
                        break;
                    case 5:
                        System.out.println("Input first number");
                        a = input.nextDouble();
                        System.out.println("Input second number");
                        b = input.nextDouble();
                        System.out.println("The biggest value = " + Calculate.getMaximum(a, b));
                        break;
                    case 6:
                        System.out.println("Input first number");
                        a = input.nextDouble();
                        System.out.println("Input second number");
                        b = input.nextDouble();
                        System.out.println("The lowest value = " + Calculate.getMinimum(a, b));
                        break;
                    case 7:
                        System.out.println("Input a number");
                        a = input.nextDouble();
                        System.out.println("Input power");
                        int c = input.nextInt();
                        System.out.println("The result of exponentiation = " + Calculate.getExponentiation(a,c));
                        break;
                    case 8:
                        System.out.println("Input a number");
                        a = input.nextDouble();
                        System.out.println("Input %");
                        b = input.nextDouble();
                        System.out.println("The result of exponentiation =" + Calculate.getPercent(a, b));
                        break;
                    case 9:
                        System.out.println("Input a number");
                        a = input.nextDouble();
                        System.out.println("Maximum int value = " + Calculate.getMaxInt(a));
                        break;
                    case 10:
                        System.out.println("Input a number");
                        a = input.nextDouble();
                        System.out.println("Minimum int value = " + Calculate.getMinInt(a));
                        break;
                    default:
                        System.out.println("Wrong choice!");
                        break;
                }
            } else if (change==3){
                return;
            }
            else {
                System.out.println("Do you want to enter enteger  or double number? 1-enteger, 2-double, 3-exit");
                change = input.nextInt();
            }
        }while (change != 1 || change != 2) ;
    }
}