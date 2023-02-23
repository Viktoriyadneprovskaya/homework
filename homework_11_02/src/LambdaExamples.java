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
        System.out.println("Is a string empty?");
        System.out.println(checkEmpty().test(s) ? "Yes": "No");
        //#3
        System.out.println("#3");
        System.out.println(biFunctionRepeat().apply(s,5));
        //#4
        System.out.println("#4");
        BigDecimal bd = new BigDecimal(3.14159265359793238462643383279502884197169399375105820974944592307816406286208998628034825);
        System.out.println(retSrt().apply(bd));
        //#5
        System.out.println("#5");
        System.out.println(checkStrLength(5,11).test(s) ? "the string matches the condition": "the string doesn't match the condition");

        //#6
        System.out.println("#6");
        System.out.println("Random number:");
        System.out.println(getRandom().getAsInt());
        //#7
        System.out.println("#7");
        System.out.println(randomInt().applyAsInt(20));
        //#8
        System.out.println("#8");
        int value =9;
        System.out.println(value+"*"+value+"="+getSquare().applyAsInt(value));
        //#9
        System.out.println("#9");
        System.out.println("string length is: "+ getLengthStr().applyAsInt(s));
        //#10
        System.out.println("#10");
//        Consumer<String> printCurrentStr = str -> System.out.println(str);
        printStrN(4).accept("The END.");
    }

    //#1
    public static Supplier<String> writeJava(){
        return ()->"Java";
    }
    //#2
    public static Predicate<String> checkEmpty(){
        return s1 -> s1.isEmpty();
    }
    //#3
    public static BiFunction<String,Integer,String> biFunctionRepeat(){
        return (o, o2) -> {
            StringBuilder stringBuilder=new StringBuilder();
            for(int i=0;i<o2; i++) {
                stringBuilder.append(o);
            }
            return stringBuilder.toString();
        };
    }
    //#4
    public static Function<BigDecimal, String> retSrt(){
        return bigDecimal-> "$"+bigDecimal;}
    //#5
    public static Predicate<String> checkStrLength(int minLength, int maxLength){
        return (str) -> {return str.length()<=maxLength && str.length()>=minLength;};
    }
    //#6
    public static IntSupplier getRandom (){
    return ()-> (int) (Math.random()*10);
}
    //#7
    public static IntUnaryOperator randomInt(){
        return (n)->(int) (Math.random()*n);
    }
    //#8
    public static IntUnaryOperator getSquare() {
        return intValue -> {
            return intValue * intValue;
        };
    }
    //#9
    public static ToIntFunction<String> getLengthStr(){
       return str -> (int) str.length();
    }
    //#10
    public static Consumer<String> printStrN(int q){
        return (String str) ->{
            for (int i=0;i<q;i++){
                System.out.println(str);
            }
        };
    }
}
