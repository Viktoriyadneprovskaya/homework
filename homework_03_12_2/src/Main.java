import java.util.Date;

//Создать иерархию классов на основе абстрактного класса и наследников, паеренимающие его свойства и имеющие свои уникальные.
// Создать класс, использующий эти реализации, но по разному

public class Main {
    public static void main(String[] args) {
        Potato potato = new Potato("Potato", "Belarossa", new Date(22, 07, 22), 3, "Oval");
        Onion onion = new Onion("Onion", "Skopino", new Date(22, 06, 22), 1, "yellow");
        potato.getInfoProduct();
        Potato potatoOne = new Potato("Potato", "Red Lady", new Date(22, 05, 22), 2, "round");
        Potato potatoTwo = potatoOne;
        onion.getInfoProduct();
        //if(potato.stock == onion.stock){
        if (potato.checkStorage(potatoOne, potatoTwo)) {
            System.out.println("Products are in the same stock");
        } else {
            System.out.println("Products must be moved to the same stock");
            potato.moveToFourStock();
            onion.moveToFourStock();
        }

        System.out.println("Is potatoOne == potatoTwo? " + potatoOne.equals(potatoTwo));
        System.out.println("Is potato == potatoOne? " + potato.equals(potatoOne));
    }
}