import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListMethods {
    public static void main(String[] args) {
        List<String> arrayList =new ArrayList<String>();
        //Write a Java program to create a new array list, add some colors (string) and print out the collection.
        arrayList.add("Red");
        arrayList.add("White");
        arrayList.add("Black");
        arrayList.add("Blue");
        System.out.println(arrayList);
        //Write a Java program to iterate through all elements in a array list
        for (Object o:arrayList) {
            System.out.println(o);
        }
        //Write a Java program to insert an element into the array list at the first position
        arrayList.add(0,"Orange");
        System.out.println(arrayList);
        //Write a Java program to retrieve an element (at a specified index) from a given array list.
        System.out.println(arrayList.get(3));
        //Write a Java program to update specific array element by given element
        arrayList.set(2, "Purple");
        System.out.println(arrayList);
        //Write a Java program to remove the third element from a array list
        arrayList.remove(2);
        System.out.println(arrayList);
        //Write a Java program to search an element in a array list.
        System.out.println(arrayList.contains("Orange"));
        //Write a Java program to sort a given array list.
        Collections.sort(arrayList);
        System.out.println(arrayList);
        //Write a Java program to copy one array list into another.
        List<String> arrayListOne =new ArrayList<String>();
        arrayListOne.add("Pink");
        arrayListOne.add("Yellow");
        arrayListOne.add("Brown");
        arrayListOne.add("Silver");
        Collections.copy(arrayListOne,arrayList);
        System.out.println(arrayList);
        System.out.println(arrayListOne);
        //Write a Java program to shuffle elements in an array list.
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
        //Write a Java program to reverse elements in a array list
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        //Write a Java program to extract a portion of a array list.
        System.out.println(arrayList.subList(1,3));
        // Write a Java program to compare two array lists
        System.out.println(arrayList.containsAll(arrayListOne));
             ArrayList<String> arrayListTwo = new ArrayList<String>();
        for (String e : arrayList)
            arrayListTwo.add(arrayList.contains(arrayListOne) ? "Yes" : "No");
        System.out.println(arrayListTwo);
        //Write a Java program of swap two elements in an array list
        Collections.swap(arrayList,0,3);
        System.out.println(arrayList);
        //Write a Java program to join two array lists
        ArrayList<String> arrayListThree = new ArrayList<String>();
        arrayListThree.addAll(arrayListOne);
        arrayListThree.addAll(arrayList);
        System.out.println(arrayListThree);
        //Write a Java program to clone an array list to another array list
        arrayListThree = ((ArrayList<String>) ((ArrayList<String>) arrayList).clone());//почему 2 раза?
        System.out.println(arrayListThree);
        //Write a Java program to empty an array list
        //в чем разница между этими методами?
        arrayListThree.clear();
        System.out.println(arrayListThree);
        arrayListTwo.removeAll(arrayListTwo);
        System.out.println(arrayListTwo);
        //Write a Java program to test an array list is empty or not.
        System.out.println(arrayListTwo.isEmpty());
        //Write a Java program to trim the capacity of an array list the current list size
        ((ArrayList<String>) arrayList).trimToSize();
        System.out.println(arrayList);
        //Write a Java program to increase the size of an array list
        ((ArrayList<String>) arrayList).ensureCapacity(6);
        arrayList.add("Orange");
        arrayList.add("Pink");
        arrayList.add("Brown");
        System.out.println(arrayList);
        //Write a Java program to replace the second element of a ArrayList with the specified element.
        arrayList.set(1,"Tree");
        System.out.println(arrayList);
        //Write a Java program to print all the elements of a ArrayList using the position of the elements.

        for (int i =0; i<arrayList.size();i++){
            System.out.println(i+ "." +arrayList.get(i));
        }

}
}