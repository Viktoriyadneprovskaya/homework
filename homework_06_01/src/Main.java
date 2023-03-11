import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[10];
        ExceptionMethods exceptionMethods = new ExceptionMethods();
        ArrayList<String> list=new ArrayList<String>();
        System.out.println(exceptionMethods.checkString(null));
        System.out.println("----------------------------------------");
        System.out.println(exceptionMethods.checkArray(nums));
        System.out.println("----------------------------------------");
        System.out.println(exceptionMethods.checkList(list));
        System.out.println("----------------------------------------");
        exceptionMethods.checkFormat("XYZ");
        System.out.println("----------------------------------------");
        exceptionMethods.divideByZero(5);
        System.out.println("----------------------------------------");
        ValidateData.readData();
        try{//1 вариант решения
            Scanner in =new Scanner(System.in);
            System.out.println("Enter word");
            String str = in.next();
            ExceptionMethods.method1(str);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("----------------------------------------");
        ValidateData.method1();
        System.out.println("----------------------------------------");
        ExceptionMethods.methodOne();//2 вариант решения
    }

}
