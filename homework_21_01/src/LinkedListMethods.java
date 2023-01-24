import java.util.*;

public class LinkedListMethods {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<String>();
        //Write a Java program to append the specified element to the end of a linked list.
        linkedList.add("White");
        linkedList.add("Blue");
        linkedList.add("Black");
        linkedList.add("Pink");
        linkedList.add("Purple");
        //Write a Java program to iterate through all elements in a linked list
        for (Object o:linkedList) {
            System.out.println(o);
        }
        System.out.println();
        // Write a Java program to iterate through all elements in a linked list starting at the specified position
        Iterator itr =linkedList.listIterator(2);
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println();
        //Write a Java program to iterate a linked list in reverse order.
        Collections.reverse(linkedList);
        System.out.println(linkedList);
        System.out.println();
        //Дима, вопрос!
        //в решении задания был другой код, ниже написала Можно делать предыдущим методом? он мне кажется проще
        itr = ((LinkedList<String>) linkedList).descendingIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println();
        //Write a Java program to insert the specified element at the specified position in the linked list.
        linkedList.add(1, "Brown");
        System.out.println(linkedList);
        System.out.println();
        //Write a Java program to insert elements into the linked list at the first and last position.
        ((LinkedList<String>) linkedList).addFirst("Yellow");
        ((LinkedList<String>) linkedList).addLast("Red");
        System.out.println(linkedList);
        // Write a Java program to insert the specified element at the front of a linked list
        //((LinkedList<String>) linkedList).push("Grey");// я сделала так и оно работает, в решении код ниже
        ((LinkedList<String>) linkedList).offerFirst("Grey");
        System.out.println(linkedList);
        System.out.println();
        //Write a Java program to insert the specified element at the end of a linked list
        ((LinkedList<String>) linkedList).offerLast("Aquamarine");
        System.out.println(linkedList);
        System.out.println();
        //Write a Java program to insert some elements at the specified position into a linked list.
        LinkedList<String> linkedListOne = new LinkedList<String>();
        linkedListOne.add("Tree");
        linkedListOne.add("Flower");
        linkedList.addAll(1,linkedListOne);
        System.out.println(linkedList);
        System.out.println();
        //Write a Java program to get the first and last occurrence of the specified elements in a linked list
        System.out.println(((LinkedList<String>) linkedList).peekFirst());
        System.out.println(((LinkedList<String>) linkedList).peekLast());
        System.out.println();
        //так в решении
        System.out.println(((LinkedList<String>) linkedList).getFirst());
        System.out.println(((LinkedList<String>) linkedList).getLast());
        System.out.println();
        //Write a Java program to display the elements and their positions in a linked list
        for (int i =0; i<linkedList.size();i++){
            System.out.println(i+ "." +linkedList.get(i));
        }
        //Write a Java program to remove a specified element from a linked list
        linkedList.remove("Aquamarine");
        System.out.println(linkedList);
        System.out.println();
        //Write a Java program to remove first and last element from a linked list.
        Object firstElement = ((LinkedList<String>) linkedList).removeFirst();
        Object lastElement =((LinkedList<String>) linkedList).removeLast();
        System.out.println("First removed element: "+ firstElement);
        System.out.println("Last removed element: "+ lastElement);
        System.out.println(linkedList);
        System.out.println();
        //Write a Java program to remove all the elements from a linked list.
        linkedListOne.clear();
        System.out.println(linkedListOne);
        System.out.println();
        //Write a Java program of swap two elements in a linked list.
        Collections.swap(linkedList,2,4);
        System.out.println(linkedList);
        System.out.println();
        // Write a Java program to shuffle the elements in a linked list.
        Collections.shuffle(linkedList);
        System.out.println(linkedList);
        System.out.println();
        //Write a Java program to join two linked lists
        linkedListOne.add("Grey");
        linkedListOne.add("Red");
        linkedList.addAll(linkedListOne);
        System.out.println(linkedList);
        System.out.println();
        //Write a Java program to clone a linked list to another linked list.
        LinkedList<String> linkedListTwo = (LinkedList<String>) ((LinkedList<String>) linkedList).clone();
        System.out.println(linkedListTwo);
        System.out.println();
        //Write a Java program to remove and return the first element of a linked list.
        System.out.println("Removed first element: "+ ((LinkedList<String>) linkedList).pop());
        System.out.println("List from removing first element"+ linkedList);
        System.out.println();
        //Write a Java program to retrieve but does not remove, the first element of a linked list.
        System.out.println(((LinkedList<String>) linkedList).peekFirst());
        System.out.println();
        //Write a Java program to retrieve but does not remove, the last element of a linked list.
        System.out.println(((LinkedList<String>) linkedList).peekLast());
        System.out.println();
        //Write a Java program to check if a particular element exists in a linked list.
        System.out.println(linkedList.contains("Blue"));
        System.out.println();
        //Write a Java program to convert a linked list to array list.
        //можно ли было сделать через Object?
        //Object[] arrayList = linkedList.toArray();
        linkedListOne = new LinkedList<>(linkedListOne);
        for(Object o: linkedListOne){
            System.out.println(o);
        }
        System.out.println();
        //Write a Java program to compare two linked lists
        System.out.println();
        LinkedList<String> linkedListThree = new LinkedList<String>();
        for (Object o:linkedList){
            System.out.println(linkedListThree.add(String.valueOf(linkedListOne.contains(o))) ? "Yes" : "No");
         }
        //Write a Java program to test a linked list is empty or not.
        if(linkedList.isEmpty()){
            System.out.println("linked list is empty");
        }else {
            System.out.println("Linked list isn't empty");
        }
        System.out.println();
        //Write a Java program to replace an element in a linked list
        linkedList.set(1,"Red");
        System.out.println(linkedList);
    }
}
