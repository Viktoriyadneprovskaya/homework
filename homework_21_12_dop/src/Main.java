

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String checkPalindrome = "ABC BA";
        String checkPalindrome1 = "ABDS BA";
        String str = "Hello world";
        String str1 = "Hellloooo worrllld";

        int index1 = str.indexOf('l');
        int index2 = str.indexOf("Ja");
        boolean end = str.endsWith("va");
        int strLength = str.length();
        String replStr1 = str.replace("Hello", "Bye");
        StringMethods strMethods =new StringMethods(str);

        System.out.println("index char " + index1);
        System.out.println("index many chars " + index2);
        System.out.println("If ends on " + "va" + " " + end);
        System.out.println("String's length is " + strLength);
        System.out.println("Replace " + replStr1);
        System.out.println("Most repeated element");
        System.out.println(strMethods.povtor(str1));//это сколько раз, а какой именно элемент
        strMethods.validate(strMethods.isPalindrome(checkPalindrome));
        strMethods.validate(strMethods.isPalindrome(checkPalindrome1));
        System.out.println(str1.chars().distinct().count());
        System.out.println(strMethods.delDublicate(str1));
        System.out.println(strMethods.delDublicate(str));
        }
    }



