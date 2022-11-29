//создать класс Car с параметрами maxSpeed, fuelAmount,productionYear, price,brand,currentSpeed,isEngineStarted
//создать конструктор инициализирующий параметры заданные заводом изготовителем и методы получения этих значений
//создать метод, который заводит и выключает машину
//создать метод имитации педали газ/тормоз, каждое нажатие добавляет/уменьшает текущую скорость на 10км/час
//создать метод имитации звукового сигнала(вывод в консоль)
public class Main
{
    public static void main(String[] args) {
        Car car = new Car(220, 60.0f, "2022", 45000.0f, "Mazda", 60, true);
        car.getInfoCar();
        System.out.println("Car was turned off. Current status: "+ car.TurnOff() + car.convert());//как убрать этот false?пробовала так car.TurnOff(car.convert()) не получается
        car.carSound();
        System.out.println("Add speed: "+ car.gasPedal()+ "km/h");
        //не хватило времени,чтоб подумать как зациклить
        System.out.println("Low speed: "+ car.stopPedal() + "km/h");
        System.out.println("Low speed: "+ car.stopPedal() + "km/h");
        System.out.println("Low speed: "+ car.stopPedal() + "km/h");
        System.out.println("Low speed: "+ car.stopPedal() + "km/h");
        System.out.println("Low speed: "+ car.stopPedal() + "km/h");
        System.out.println("Low speed: "+ car.stopPedal() + "km/h");
        System.out.println("Low speed: "+ car.stopPedal() + "km/h");
    }
}