import java.util.Scanner;

public class dzFive {
  
    public static void main(String[] args) {
          
        Scanner in = new Scanner(System.in);
		System.out.print("Input first number: ");
        int numOne = in.nextInt();
                System.out.print("Input second number: ");
        int numTwo = in.nextInt();
                if (numOne==numTwo) {
				System.out.print("numOne = numTwo");
				}
				else if (numOne>numTwo) {	
		        System.out.print("numOne is bigger than numTwo");
      }
                else {
                System.out.print("numTwo is bigger than numOne");
      }
		in.close();
    }
}