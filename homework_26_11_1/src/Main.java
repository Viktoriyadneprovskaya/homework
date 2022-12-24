//Написать класс Laptop с полями brand, isTurnedOn, welcome Phrase< butteryAmount,инициализировать поля конструктором
//создать методы получения значений, вывода приветствия при загрузке, метод уменьшения заряда батареи
//если батареи осталось меньше 10%, вывести предупреждение на экран
//Если 0, выкл комп и вывести сообщение на экран

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Sumsung", true, "You are welcome!", 55);
        laptop.getWelcomePhrase();
        while (laptop.getIsTurnedOn() == true) {
            System.out.println("Laptop brand: " + laptop.getLaptopBrand());
            System.out.println("Laptop status: " + laptop.convertStatus(laptop.getIsTurnedOn()));
            //laptop.getWelcomePhrase();
            System.out.println("Current Laptop buttery charge: " + laptop.getButteryAmount());
            laptop.setButtery();
            laptop.lowButteryAmount(laptop.getIsTurnedOn());
        }
    }
}