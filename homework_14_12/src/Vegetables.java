//реализовать внутренний класс, вложенный класс, анонимный класс через интерфей и анонимный класс через абстрактный класс

import java.util.Date;

public class Vegetables {
    public String potato = "potato";
    static String onion = "onion";
    static int fieldNumber =1;

    Vegetables() {
    }

    class Potato{ //внутренний класс inner class
        Date date = new Date("07/12/2022");
        void accessPotato(){
            System.out.println("Product name is "+ potato);
            System.out.println("Harvest field number is "+ fieldNumber);
            System.out.println("Potato harvest date: "+ date);
        }
        Watcher temperatureWatcher = new Watcher() {//реализация анонимного класса через интерфейс
            @Override
            public void startCheckStorageTemperature() {
                System.out.println("Start temperature monitoring");
            }
        };
        StorageWatcher mainStorage  = new StorageWatcher(){//реализация анонимного класса через абстрактный класс
            public void startCheckStorageTemperature(float currentTemp) {
                if ((currentTemp<=normalMaxTemp)&&(currentTemp>=normalMinTemp)){
                    System.out.println("Temperature is OK");
                } else {
                    System.out.println("We have a problem with temperature in "+mainStorage.storageName);
                }
            }
        };


    }

    static class Onion{//вложенный класс nested class
        void accessOnion(Vegetables vegetables, Potato potato){
            System.out.println("Product name is "+ onion);
            System.out.println("Harvest field number is "+ fieldNumber);
            System.out.println("Another product from the field is "+ vegetables.potato);
            System.out.println("Onion harvest date: "+ potato.date);
        }
    }


    public static void main(String[] args) {
        Vegetables vegetables =new Vegetables();
        Vegetables.Potato potatoOne = vegetables.new Potato();
        potatoOne.accessPotato();
        //можно так
        //Watcher potatoOneTemperature = potatoOne.temperatureWatcher;
        //potatoOneTemperature.startCheckStorageTemperature();
        //а можно 1 строкой
        //интересно как именно правильно)))
        potatoOne.temperatureWatcher.startCheckStorageTemperature();


        potatoOne.mainStorage.startCheckStorageTemperature(12.1f);
        System.out.println("----------------------");
        Onion onionOne = new Onion();
        onionOne.accessOnion(vegetables, potatoOne);
    }
}