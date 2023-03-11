import java.util.*;

public class HashSetMethods {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        //Write a Java program to append the specified element to the end of a hash set.
        hashSet.add("White");
        hashSet.add("Blue");
        hashSet.add("Black");
        hashSet.add("Pink");
        hashSet.add("Purple");
        System.out.println(hashSet);
        System.out.println();
        //Write a Java program to iterate through all elements in a hash list.
        for (Object o : hashSet) {
            System.out.println(o);
        }
        System.out.println();
        //Write a Java program to get the number of elements in a hash set.
        System.out.println("The number of hashset elements: " + hashSet.size());
        //Write a Java program to empty a hash set.
        //hashSet.clear();
        hashSet.removeAll(hashSet);
        System.out.println(hashSet);
        System.out.println();
        //Write a Java program to test a hash set is empty or not.
        if (hashSet.isEmpty()) {
            System.out.println("hashset is empty");
        } else {
            System.out.println("hashset isn't empty");
        }
        System.out.println();
        //Write a Java program to clone a hash set to another hash set.
        hashSet.add("White");
        hashSet.add("Blue");
        hashSet.add("Black");
        hashSet.add("Pink");
        hashSet.add("Purple");
        HashSet hashSetOne = (HashSet) hashSet.clone();
        System.out.println(hashSetOne);
        System.out.println();
        //Write a Java program to convert a hash set to an array.
        String[] strArray = new String[hashSet.size()];
        hashSet.toArray(strArray);
        for (String element : strArray) {
            System.out.println(element);
        }
        System.out.println();
        //Write a Java program to convert a hash set to a tree set.
        Set<String> tree = new TreeSet<String>(hashSetOne);
        System.out.println("TreeSet elements: ");
        for(String element : tree){
            System.out.println(element);
        }
        System.out.println();
        //Write a Java program to convert a hash set to a List/ArrayList.
        List<String> list = new ArrayList<String>(hashSetOne);
        System.out.println("Array list elements: "+list);
        System.out.println();
        //Write a Java program to compare two hash set
        HashSet<String> hashSetThree = new HashSet<String>();
//        for (Object o:hashSetOne){
//
//            System.out.println(hashSetThree.add(String.valueOf(hashSetOne.contains(o)))? "No" : "Yes");
//         }
        for (Object o:hashSetOne){

            System.out.println(hashSetThree.add(String.valueOf(hashSetOne.contains(o)))? "No" : "Yes");
        }
        System.out.println();
        //Write a Java program to compare two sets and retain elements which are same on both sets.
        System.out.println("First hashset: "+hashSet);
        System.out.println("Second hashset: "+hashSetOne);
        hashSetOne.remove("Black");
        hashSet.retainAll(hashSetOne);
        System.out.println(hashSet);
        System.out.println();
        //Write a Java program to remove all of the elements from a hash set
        hashSet.removeAll(hashSet);
        System.out.println("Hashset after remove: "+hashSet);
    }
}

