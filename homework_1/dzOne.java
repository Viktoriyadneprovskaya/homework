import java.util.Scanner;

public class DzOne {
  
    public static void main(String[] args) {
          
        Scanner in = new Scanner(System.in);
		System.out.print("Input a number: ");
        int num = in.nextInt();
         
		System.out.print("Your number: " + num);
		in.close();
    }
}