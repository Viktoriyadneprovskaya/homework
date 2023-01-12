import java.util.Scanner;

public class ValidateData {
    ValidateData() {}

    public static void readData() throws Exception{
        String myString = "";
        System.out.println("Enter integer\n");
        while (true){
            try {
                Scanner in = new Scanner(System.in);
                String curStr = in.next();
                int number = Integer.parseInt(curStr);
                myString = myString+curStr+";";
            }catch (NumberFormatException ex){
                System.out.println(myString);
                break;
            }
        }
    }
    public static int method2 (String a){
        int b = Integer.parseInt(a);
        return b;
    }
    public static void method1() {
        method2();
    }
    public static void method2() {
        method3();
    }
    public static void method3() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements.length);
        for (StackTraceElement element:stackTraceElements) {
            System.out.println(element.getMethodName());
        }
    }
}
