//1) Написать метод который возвращает Supplier<String>, который всегда возвращает слово "Java"
//2) Написать метод который возвращает Predicate<String>, который проверяет строка пустая или нет
//3) Написать метод который возвращает BiFunction<String, Integer, String> который преобразует в себя строку, возвращая строку повторяемую N раз
//4) Написать метод который возвращает Function<BigDecimal, String>, который преобразует строку и возвращает строку которая начинается со знака доллара и этого BigDecimal
//5) Написать метод который возвращает Predicate<String>(int min, int max), который принимает на вход параметр минимальной длины строки и максимальной, проверить соответствует ли строка данному пределу
//6) Написать метод который возвращает IntSupplier, который возвращает рандомное целое число
//7) Написать метод который возвращает IntUnaryOperator, который принимает инт и возвращает рандомный инт, ограниченный пределом который мы задаем(тут ознакомьтесь как IntUnaryOperator работает)
//8) Написать метод который возвращает IntUnaryOperator, который принимает число и возвращает число возведенное в степень самого числа
//9) Написать метод который возвращает ToIntFunction<String>, который принимает строку и возвращает ее длину
//10)Написать метод который возвращает Consumer<String>, метод которого выводит строку на екран, проверить работу через цикл строк


import java.math.BigDecimal;
import java.util.function.*;
import java.util.function.Predicate;

public class LambdaExamples {
    public static void main(String[] args) {
        //#1
        System.out.println("#1");
        String supplier= writeJava().get();
        System.out.println(supplier);
        System.out.println();

        //#2
        System.out.println("#2");
        String s = "Hello Java\n";
        boolean predicate= checkEmpty().test(s);
        System.out.println("Is a string empty?");
        System.out.println(predicate? "Yes": "No");
        //#3
        System.out.println("#3");
        System.out.println(biFunctionRepeat().apply(s,5));
        //#4
        System.out.println("#4");
        BigDecimal bd = new BigDecimal(3.14159265359793238462643383279502884197169399375105820974944592307816406286208998628034825);
        Function <BigDecimal, String> exmpl4 = bigDecimal-> "$"+bigDecimal;
        System.out.println(retSrt(exmpl4,bd));
        //#5
        System.out.println("#5");

        Predicate3 <String> predicateLength = (str, minLength, maxLength) -> {return s.length()<maxLength || s.length()>minLength;};
        //checkLength(s,predicateLength);
        checkStrLength((Predicate3<String>) predicateLength,s,4,9);
        //#6
        System.out.println("#6");
        System.out.println("Random number:");
        System.out.println(getRandom().getAsInt());
        //#7
        System.out.println("#7");
        IntUnaryOperator getRandom = intValue -> {
            return (int) (Math.random()*intValue);
        };
        randomInt(getRandom,10);
        //#8
        System.out.println("#8");
        IntUnaryOperator toSquare = intValue -> {
            return intValue * intValue;
        };
        getSquare(toSquare,9);
        //#9
        System.out.println("#9");
        ToIntFunction<String> lengthOfStr = str -> (int) s.length();
        getLengthStr(lengthOfStr,s);
        //#10
        System.out.println("#10");
        Consumer<String> printCurrentStr = str -> System.out.println(str);
        printStrN(printCurrentStr,"The END.",4 );
    }
//    public static String writeJava(Supplier<String> supplier){
//        return supplier.get();
//    }
    public static Supplier<String> writeJava(){
        return ()->"Java";
    }
//    public static void checkEmpty(String s, Predicate predicate){
//        System.out.println(predicate.test(s)? "Yes": "No");
//    }
    public static Predicate<String> checkEmpty(){
        return s1 -> s1.isEmpty();
    }
    public static BiFunction<String,Integer,String> biFunctionRepeat(){
        return (o, o2) -> {
            StringBuilder stringBuilder=new StringBuilder();
            for(int i=0;i<o2; i++) {
                stringBuilder.append(o);
            }
            return stringBuilder.toString();
        };
    }
    public static IntSupplier getRandom (){
            return ()-> (int) (Math.random()*10);
    }
    public static String retSrt(Function<BigDecimal, String> function4, BigDecimal bd){return function4.apply(bd);}
    public static void checkStrLength(Predicate3<String> predicate,String s, int min, int max){

        System.out.println(predicate.test(s,min,max) ? "the string matches the condition": "the string doesn't match the condition");
    }
    public static void randomInt(IntUnaryOperator getRand,int value){
        System.out.println(getRand.applyAsInt(value));
    }
    public static void getSquare(IntUnaryOperator toSquare,int value){
        System.out.println(value+"*"+value+"="+toSquare.applyAsInt(value));
    }
    public static void getLengthStr(ToIntFunction<String>lengthOfString,String str){
        System.out.println("string length is: "+lengthOfString.applyAsInt(str));
    }
    public static void printStrN(Consumer<String> printCurrentStr,String str,int q){
        for (int i=0;i<q;i++){
            printCurrentStr.accept(str);
        }
    }
}
