import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        TestString newStr =new TestString();
        newStr.setString(in.nextLine());

        System.out.println("Voweles elements quantity is "+newStr.getVowels());
        System.out.println("The central string's element is " + newStr.getCentralElement());
        System.out.println("The shortest string's word is " + newStr.getShortElement());
        System.out.println("Enter new string and smile ");
        System.out.println(newStr.getViceVersa(in.nextLine()));
    }
}