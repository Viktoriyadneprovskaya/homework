import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayListImpl<String> list=new ArrayListImpl<>(3);
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");
        list.add("String5");
        list.add("String6");
        //System.out.println(list.get(3));
        list.add(2,"String7");
        System.out.println(list.get(2));
        for (int i =0; i< list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println();
        System.out.println("First element "+list.getFirst());
        System.out.println("Last element "+list.getLast());
        System.out.println("============");
        list.set(2,"tree");
        System.out.println("The set element is: "+list.get(2));
        System.out.println();
       if(list.isEmpty()){
           System.out.println("Array is empty");
       }else{
           System.out.println("Array isn't empty");
       }
        System.out.println("----Current array-----");
        for (int i =0; i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("---deleted element----");
        Object deletedEl = list.remove(3);
        System.out.println(deletedEl);
        System.out.println("---Array after remove----");
        for (int i =0; i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("====Contains======");
        System.out.println(list.contains("tree"));
        System.out.println("======Clear======");
        //не получается вывести пустой массив, хотя isEmpty показывает, что он пустой
        list.clear();
        System.out.println(list);
        System.out.println(list.isEmpty());
    }
}
