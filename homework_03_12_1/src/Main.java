//создать класс Address, описать поля, характеризующие адрес
//создать пустой конструктор и контруктор, позволяющий заполнить поля при создании объекта
//создать метода set,get для полей класса
//переопределить метод equals, hashCode, toString

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long index;
        String country;
        String region;
        String city;
        String street;
        int homeNumber;
        int flatNumber;
        Address addressOne = new Address();
        System.out.println("Enter index: ");
        addressOne.setIndex(input.nextLong());
        System.out.println("Enter country: ");
        addressOne.setCountry(input.nextLine());
        System.out.println("Enter region: ");
        addressOne.setRegion(input.nextLine());
        System.out.println("Enter city: ");
        addressOne.setCity(input.nextLine());
        System.out.println("Enter street: ");
        addressOne.setStreet(input.nextLine());
        System.out.println("Enter home number: ");
        addressOne.setHomeNumber(input.nextInt());
        System.out.println("Enter flat number: ");
        addressOne.setFlatNumber(input.nextInt());

        Address addressTwo = new Address(41026,"Ukraine","Dnipropetrovsk","Dnipro","Kalinovaya Street",1245,352);
        System.out.println(addressOne.toString());
        System.out.println(addressOne.equals(addressTwo));
        System.out.println(addressOne.hashCode());
    }
}