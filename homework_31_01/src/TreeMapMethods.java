import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapMethods {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        //1. Write a Java program to associate the specified value with the specified key in a Tree Map.
        map.put(8, "White");
        map.put(5, "Black");
        map.put(3, "Blue");
        map.put(1, "Red");
        map.put(2, "Yellow");
        map.put(4, "Orange");
        map.put(6, "Grey");
        map.put(7, "Green");
        map.put(9, "Pink");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=>" + entry.getValue());
        }
        System.out.println();
        //2. Write a Java program to copy a Tree Map content to another Tree Map.
        TreeMap<Integer, String> tree_map = new TreeMap<>();
        tree_map.put(15, "Cup");
        tree_map.put(16, "Knife");
        tree_map.put(17, "Spoon");
        map.putAll(tree_map);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=>" + entry.getValue());
        }
        System.out.println();
        //3. Write a Java program to search a key in a Tree Map.
        Integer a = 5;
        Integer b = 10;
        if (map.containsKey(a)) {
            System.out.println("Yes, this key exists");
        } else {
            System.out.println("No, this key doesn't exist");
        }
        if (map.containsKey(b)) {
            System.out.println("Yes, this key exists");
        } else {
            System.out.println("No, this key doesn't exist");
        }
        System.out.println();
        //4. Write a Java program to search a value in a Tree Map.
        String str = "White";
        String str1 = "Table";
        if (map.containsValue(str)) {
            System.out.println("Yes, this value exists");
        } else {
            System.out.println("No, this value doesn't exist");
        }
        if (map.containsValue(str1)) {
            System.out.println("Yes, this value exists");
        } else {
            System.out.println("No, this value doesn't exist");
        }
        System.out.println();
        //5. Write a Java program to get all keys from the given a Tree Map.
        System.out.println(map.keySet());
        System.out.println();
        //6. Write a Java program to delete all elements from a given Tree Map.
        tree_map.clear();
        System.out.println("Tree map after clear" + tree_map);
        System.out.println();
        //7. Write a Java program to sort keys in Tree Map by using comparator.
        TreeMap<Integer, String> tree_map1 = new TreeMap<Integer, String>(new sort_key());
        tree_map1.put(85,"Cup");
        tree_map1.put(68, "Table");
        tree_map1.put(25,"Tea");
        System.out.println(tree_map1);
        System.out.println();
        //8. Write a Java program to get a key-value mapping associated with the greatest key and the least key in a map.
        System.out.println("The greatest key "+map.firstEntry());
        System.out.println("The least key "+map.lastEntry());
        System.out.println();
        //9. Write a Java program to get the first (lowest) key and the last (highest) key currently in a map.
        System.out.println("The first key "+ map.firstKey());
        System.out.println("The last key "+map.lastKey());
        System.out.println();
        //10. Write a Java program to get a reverse order view of the keys contained in a given map.
        System.out.println("Reversed keys "+ map.descendingKeySet());
        System.out.println();
        //11. Write a Java program to get a key-value mapping associated with the greatest key less than or equal to the given key
        System.out.println(map.floorEntry(15));
        System.out.println(map.floorEntry(20));
        System.out.println(map.floorEntry(10));
        System.out.println();
        //12. Write a Java program to get the greatest key less than or equal to the given key.
        System.out.println(map.floorKey(15));
        System.out.println(map.floorKey(20));
        System.out.println(map.floorKey(10));
        System.out.println();
        //13. Write a Java program to get the portion of a map whose keys are strictly less than a given key.
        System.out.println(map.headMap(1));
        System.out.println(map.headMap(10));
        System.out.println(map.headMap(5));
        System.out.println();
        //14. Write a Java program to get the portion of this map whose keys are less than (or equal to, if inclusive is true) a given key.
        System.out.println(map.headMap(1,true));
        System.out.println(map.headMap(8,true));
        System.out.println(map.headMap(15,true));
        System.out.println();
        //15. Write a Java program to get the least key strictly greater than the given key. Return null if there is no such key.
        System.out.println(map.higherEntry(1));
        System.out.println(map.higherEntry(10));
        System.out.println(map.higherEntry(17));
        System.out.println();
        //16. Write a Java program to get a key-value mapping associated with the greatest key strictly less than the given key. Return null if there is no such key.
        System.out.println(map.lowerEntry(1));
        System.out.println(map.lowerEntry(10));
        System.out.println(map.lowerEntry(17));
        System.out.println();
        //17. Write a Java program to get the greatest key strictly less than the given key. Return null if there is no such key.
        System.out.println(map.lowerKey(1));
        System.out.println(map.lowerKey(10));
        System.out.println(map.lowerKey(17));
        System.out.println();
        //18. Write a Java program to get NavigableSet view of the keys contained in a map.
        System.out.println(map.navigableKeySet());
        System.out.println();
        //19. Write a Java program to remove and get a key-value mapping associated with the least key in a map.
        System.out.println(map.pollFirstEntry());
        System.out.println(map);
        System.out.println();
        //20. Write a Java program to remove and get a key-value mapping associated with the greatest key in this map.
        System.out.println(map.pollLastEntry());
        System.out.println(map);
        System.out.println();
        //21. Write a Java program to get the portion of a map whose keys range from a given key (inclusive), to another key (exclusive).
        System.out.println(map.subMap(2,15));
        System.out.println();
        //22. Write a Java program to get the portion of a map whose keys range from a given key to another key./
        System.out.println(map.subMap(2,true,15,true));
        System.out.println();
        //23. Write a Java program to get a portion of a map whose keys are greater than or equal to a given key.
        System.out.println(map.tailMap(4));
        System.out.println();
        //24. Write a Java program to get a portion of a map whose keys are greater than to a given key.
        System.out.println(map.tailMap(4,false));
        System.out.println();
        //25. Write a Java program to get a key-value mapping associated with the least key greater than or equal to the given key. Return null if there is no such key.
        System.out.println(map.ceilingEntry(9));
        System.out.println();
        //26. Write a Java program to get the least key greater than or equal to the given key. Returns null if there is no such key.
        System.out.println(map.ceilingKey(1));
        System.out.println(map.ceilingKey(10));
        System.out.println(map.ceilingKey(2));
        System.out.println(map.ceilingKey(17));
    }

    static class sort_key implements Comparator<Integer> {
        @Override
        public int compare(Integer int1, Integer int2) {
            return int1.compareTo(int2);
        }
    }
}
