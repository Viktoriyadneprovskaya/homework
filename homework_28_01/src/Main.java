import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<String> list = new LinkedList<>();
//        list.clear();
//        list.contains("Ytkkj");
//        list.get(0);
//        list.isEmpty();
//        Iterator var = list.iterator();
//        while(var.hasNext()) {
//            Object o = var.next();
//            System.out.println(o);
//        }
//        list.remove(1);
//        list.add(2,"tree");
//        list.set(1,"tree");

        LinkedListImpl linkedList =new LinkedListImpl<>();
        linkedList.add("String1");
        linkedList.add("String2");
        linkedList.add("String3");
        linkedList.add("String4");
        linkedList.add("String5");
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));

//        Iterator iterator1=linkedList.iterator();
        System.out.println("======");
//        while(iterator1.hasNext()) {
//            Object o = iterator1.next();
//            System.out.println(o);
//        }
//        System.out.println("========");
//        System.out.println(linkedList.isEmpty());
//        linkedList.clear();
//        System.out.println(linkedList);
//        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.remove(2));
    }
}
