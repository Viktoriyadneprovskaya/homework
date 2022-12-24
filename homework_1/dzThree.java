import java.util.Scanner;

public class DzThree {
  
    public static void main(String[] args) {
          
        Scanner in = new Scanner(System.in);
		System.out.print("Input C degrees: ");
        int numOne = in.nextInt();
		System.out.print("Degrees in fahrenheit: " + (numOne*32));
		in.close();
    }
}