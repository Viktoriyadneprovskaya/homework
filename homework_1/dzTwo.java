import java.util.Scanner;

public class DzTwo {
  
    public static void main(String[] args) {
          
        Scanner in = new Scanner(System.in);
		System.out.print("Input first number: ");
        int numOne = in.nextInt();
        System.out.print("Input second number: ");
        int numTwo = in.nextInt();
		float percent = numOne/numTwo*100; //не работает
		if (numTwo==0){
			System.out.println("Error"); //почему не работает
		}
		else { 
		    float devision = numOne/numTwo; //не работает
			System.out.println("numOne by numTwo: " + devision);
		}   
		System.out.println("Difference between numOne and numTwo: " + (numOne-numTwo));
                System.out.println("Summ between numOne and numTwo: " + (numOne+numTwo));
                System.out.println("numOne * numTwo: " + (numOne*numTwo));
                System.out.println("numOne ost ot del numTwo: " + (numOne%numTwo));
                System.out.println("numOne % numTwo: " + percent + "%");
		in.close();
    }
}
