import java.util.Scanner;

public class DzEight {
  
    public static void main(String[] args) {
          
        Scanner in = new Scanner(System.in);
		System.out.print("Input year: ");
        int century = in.nextInt();
        System.out.print("Input year is " + (century/100+1) + " century");
        in.close();
    }
}
