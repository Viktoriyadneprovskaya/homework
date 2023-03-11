//создать класс Car с параметрами maxSpeed, fuelAmount,productionYear, price,brand,currentSpeed,isEngineStarted
//создать конструктор инициализирующий параметры заданные заводом изготовителем и методы получения этих значений
//создать метод, который заводит и выключает машину
//создать метод имитации педали газ/тормоз, каждое нажатие добавляет/уменьшает текущую скорость на 10км/час
//создать метод имитации звукового сигнала(вывод в консоль)
public class Main
{
    public static void main(String[] args) {
        Car car = new Car(220, 60.0f, "2022", 45000.0f, "Mazda", 0, true);
        car.getInfoCar();
        car.carSound();
        while (car.currentSpeed<60) {
            System.out.println("Push gas pedal: "+ car.gasPedal()+ "km/h");
        }

        while (car.currentSpeed>0) {
            car.stopPedal();

            if (car.currentSpeed==0) {
                System.out.println("This car was stopped already");
            } else {
                System.out.println("Push break pedal: " + car.currentSpeed + "km/h");
            }
        }

        System.out.println("Car was turned off. Current status: "+  car.convert(car.carTurnOff()));
    }
}