import java.util.Scanner;

public class dzSix {
  
    public static void main(String[] args) {
          
        Scanner in = new Scanner(System.in);
		System.out.print("Input first number: ");
        int numOne = in.nextInt();
                System.out.print("Input second number: ");
        int numTwo = in.nextInt();
                System.out.print("Input third number: ");
        int numThree = in.nextInt();
                if (numOne>numTwo && numOne>numThree){
		System.out.print("numOne is max");
      }
                else if (numTwo>numOne && numTwo>numThree) {
                System.out.print("numTwo is max");
      }
                else if (numOne==numTwo && numOne==numThree && numTwo==numThree) {
                System.out.print("All numbers are the same");
                }
                else {
                System.out.print("numThree is max");
                }
		in.close();
    }
}