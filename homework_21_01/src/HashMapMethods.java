import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapMethods {
    public static void main(String[] args) {
        Map<Integer,String> hashMap = new HashMap<>();
        //Write a Java program to associate the specified value with the specified key in a HashMap.
        hashMap.put(1,"White");
        hashMap.put(2,"Black");
        hashMap.put(3,"Blue");
        hashMap.put(4,"Pink");
        hashMap.put(5,"Purple");
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        for(Map.Entry x:hashMap.entrySet()){
            System.out.println(x.getKey()+"."+x.getValue());
        }
        System.out.println();
        // Write a Java program to count the number of key-value (size) mappings in a map.
        System.out.println("Hashmap size: "+hashMap.size());
        System.out.println();
        //Write a Java program to copy all of the mappings from the specified map to another map.
        Map<Integer,String> hashMapOne = new HashMap<Integer,String>();
        Map<Integer,String> hashMapThree = new HashMap<Integer,String>();
        hashMapOne.put(1,"Brown");
        hashMapOne.put(2,"Grey");
        hashMapOne.put(3,"Green");
        hashMapOne.put(4,"Purple");
        hashMapOne.put(5,"Pink");
        System.out.println("First map: "+hashMapThree);
        System.out.println("Second map: "+hashMapOne);
        hashMapThree.putAll(hashMapOne);
        System.out.println("Copied hashmap "+hashMapThree);
        System.out.println();
        //Write a Java program to remove all of the mappings from a map.
        hashMapThree.clear();
        System.out.println("Hashmap is empty" +hashMapThree);
        System.out.println();
        //Write a Java program to check whether a map contains key-value mappings (empty) or not.
        if(hashMap.isEmpty()){
            System.out.println("HashMap is empty");
        }else {
            System.out.println("HashMap isn't empty");
        }
        if(hashMapThree.isEmpty()){
            System.out.println("HashMap is empty");
        }else {
            System.out.println("HashMap isn't empty");
        }
        System.out.println();
        //Write a Java program to get a shallow copy of a HashMap instance.
        hashMapThree=(HashMap) ((HashMap<Integer, String>) hashMapOne).clone();
        System.out.println("Cloned hashMap: "+hashMapThree);
        System.out.println();
        //Write a Java program to test if a map contains a mapping for the specified key.
        if(hashMap.containsKey(2)){
            System.out.println("Yes,contains");
        }else {
            System.out.println("No");
        }
        System.out.println();
        //Write a Java program to test if a map contains a mapping for the specified value.
        if(hashMap.containsValue("Black")){
            System.out.println("Yes,contains");
        }else {
            System.out.println("No");
        }
        System.out.println();
        //Write a Java program to create a set view of the mappings contained in a map
        Set set =hashMap.entrySet();
        System.out.println(set);
        System.out.println();
        //Write a Java program to get the value of a specified key in a map.
        System.out.println("An element under key 2 is: "+hashMap.get(2));
        System.out.println();
        //Write a Java program to get a set view of the keys contained in this map
        Set set1 = hashMap.keySet();
        System.out.println(set1);
        System.out.println();
        //Write a Java program to get a collection view of the values contained in this map
        System.out.println("Collection view of hashmap values: "+hashMap.values());
    }
}
