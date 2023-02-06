import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class TreeSetMethods {
    public static void main(String[] args) {
        TreeSet<String> treeSet =new TreeSet<>();
        //Write a Java program to create a new tree set, add some colors (string) and print out the tree set.
        treeSet.add("White");
        treeSet.add("Black");
        treeSet.add("Red");
        treeSet.add("Yellow");
        treeSet.add("Pink");
        treeSet.add("Blue");
        System.out.println(treeSet);
        System.out.println();
        //Write a Java program to iterate through all elements in a tree set.
        for (String s:treeSet){
            System.out.println(s);
        }
        System.out.println();
        //Write a Java program to add all the elements of a specified tree set to another tree set.
        TreeSet<String> treeSetOne =new TreeSet<>();
        treeSetOne.add("Cup");
        treeSetOne.add("Plate");
        treeSetOne.add("Spoon");
        treeSetOne.add("Knife");
        treeSet.addAll(treeSetOne);
        System.out.println(treeSet);
        System.out.println();
        //Write a Java program to create a reverse order view of the elements contained in a given tree set
        Iterator iterator = treeSet.descendingIterator();
        System.out.println("reversed treeSet");
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        System.out.println();
        // Write a Java program to get the first and last elements in a tree set
        System.out.println("The first treeSet element: "+treeSet.first());
        System.out.println("The last treeSet element: "+treeSet.last());
        System.out.println();
        //Write a Java program to clone a tree set list to another tree set.
        TreeSet<String> treeSetTwo = (TreeSet<String>) treeSet.clone();
        System.out.println(treeSetTwo);
        System.out.println();
        //Write a Java program to get the number of elements in a tree set.
        System.out.println(treeSet.size());
        System.out.println();
        //Write a Java program to compare two tree sets.
        for (String str:treeSet){
            System.out.println(treeSetTwo.contains(str)? "Yes" : "No");
        }
        System.out.println();

        for (String str:treeSet){
            System.out.println(treeSetOne.contains(str)? "Yes" : "No");
        }
        System.out.println();
        //Write a Java program to find the numbers less than 7 in a tree set.
        TreeSet<Integer> integerTreeSet =new TreeSet<>();
        TreeSet<Integer> upToSeven = new TreeSet<>();
        integerTreeSet.add(25);
        integerTreeSet.add(18);
        integerTreeSet.add(23);
        integerTreeSet.add(4);
        integerTreeSet.add(8);
        integerTreeSet.add(95);
        integerTreeSet.add(56);
        integerTreeSet.add(47);
        integerTreeSet.add(20);
        upToSeven= (TreeSet<Integer>) integerTreeSet.headSet(7);
        iterator=upToSeven.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+ " ");
        }
        System.out.println();
        System.out.println();
        // Write a Java program to get the element in a tree set which is greater than or equal to the given element.
        Integer a =45;
        System.out.println(integerTreeSet.ceiling(a));
        System.out.println();
        // Write a Java program to get the element in a tree set which is less than or equal to the given element.
        System.out.println(integerTreeSet.floor(a));
        System.out.println();
        //Write a Java program to get the element in a tree set which is strictly greater than or equal to the given element.
        a=47;
        System.out.println(integerTreeSet.higher(a));
        //Write a Java program to get an element in a tree set which is strictly less than the given element
        a=47;
        System.out.println(integerTreeSet.lower(a));
        System.out.println();
        //Write a Java program to retrieve and remove the first element of a tree set
        System.out.println("removed the first element "+integerTreeSet.pollFirst());
        System.out.println(integerTreeSet);
        System.out.println();
        //Write a Java program to retrieve and remove the last element of a tree set
        System.out.println("removed the last element "+integerTreeSet.pollLast());
        System.out.println(integerTreeSet);
        System.out.println();
        //Write a Java program to remove a given element from a tree set.
        System.out.println(integerTreeSet.remove(25));
        System.out.println(integerTreeSet);
    }
}
