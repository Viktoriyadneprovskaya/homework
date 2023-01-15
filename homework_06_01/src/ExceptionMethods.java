import java.util.ArrayList;
import java.util.Arrays;


public class ExceptionMethods {
    public ExceptionMethods() {
    }
    public String checkString(String str) {
        try {
            String m = str.toLowerCase();
            return m;
        } catch (NullPointerException e) {
            String errorString = "String is empty\n";
            errorString = errorString + e.getMessage();
            return errorString;
        }
    }
    
    public String checkArray(int[] myArray){
        try{
            return  Arrays.toString(new int[]{myArray[20]});
        }catch (ArrayIndexOutOfBoundsException e){
            return  "Array out of length\n"+e+"\n"+"Out of array length";
        }
    }
    public String checkList(ArrayList list){
        try{
            return list.get(18).toString();
        }catch (IndexOutOfBoundsException e){
            return "Out of list length\n"+e;
        }
    }

    public void checkFormat(String myStr){
        try{
            int num = Integer.parseInt(myStr);
            System.out.println("result is "+num);
        }catch (NumberFormatException e){
            System.out.println("Illegal format\n"+e+"\nno valid");
        }
    }

    public void divideByZero(int a){
        try {
            System.out.println(a/0);
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("division by 0");
        }
    }

    public static void method1(String str) throws Exception1, Exception2, Exception3 {
        if (str.equals("First")) {
            method2();
        }else if(str.equals("Second")) {
            method3();
        }else if(str.equals("Third")) {
            method4();
        }
    }
    public static void method2() throws Exception1 {
        throw new Exception1("From Exception1");
    }
    public static void method3() throws Exception2 {
        throw new Exception2("From Exception2");
    }
    public static void method4() throws Exception3 {
        throw new Exception3("From Exception3");
    }

    public static void methodOne() {
        try {
            rethrow("Second");
        }catch(Exception3 e){
            System.out.println(e.getMessage());
            System.out.println("from exception 3");
        }catch (Exception2 e){
            System.out.println(e.getMessage());
            System.out.println("from exception 2");
        }catch (Exception1 e){
            System.out.println(e.getMessage());
            System.out.println("from exception 1");
        }
    }

    static void rethrow(String s) throws Exception1,Exception2,Exception3{
            if (s.equals("First"))
                throw new Exception1("First");
            else if (s.equals("Second"))
                throw new Exception2("Second");
            else if (s.equals("Third"))
                throw new Exception3("Third");
    }
}

