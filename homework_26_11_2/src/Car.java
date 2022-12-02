public class Car {
    int maxSpeed;
    float fuelAmount;
    String productionYear;
    float price;
    String brand;
    int currentSpeed;
    boolean isEngineStarted;

    public Car(int maxSpeed, float fuelAmount, String productionYear, float price, String brand, int currentSpeed, boolean isEngineStarted) {
        this.maxSpeed = maxSpeed;
        this.fuelAmount = fuelAmount;
        this.productionYear = productionYear;
        this.price = price;
        this.brand = brand;
        this.currentSpeed = currentSpeed;
        this.isEngineStarted = isEngineStarted;
    }

    public void getInfoCar() {
        System.out.println("Brand Car: " + brand);
        System.out.println("Production year: " + productionYear);
        System.out.println("Max speed: " + maxSpeed + "km/h");
        System.out.println("Fuel amount: " + fuelAmount + "l");
        System.out.println("Car price: " + price + "$");
        System.out.println("Car ON or OFF: " + convert(isEngineStarted));
        System.out.println("Current car speed: " + currentSpeed + "km/h");

    }

    public boolean getIsTurnedOn() {
        return isEngineStarted;
    }

    //переводит тру в он и фолс в оф
    public String convert(boolean isStarted) {
        if (isStarted) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    //выключает
    public boolean carTurnOff() {
        isEngineStarted = false;
        return isEngineStarted;
    }

    //имитация звукового сигнала
    public void carSound() {
        System.out.println("Car souds");
    }
    //педаль газ
    public int gasPedal(){
        currentSpeed+=10;
        return currentSpeed;
    }
    //педаль тормоз
	//хотела проверку if в отдельный метод вывести, но не сообразила как, наверное немного коряво этот метод получился
    public void stopPedal() {
        currentSpeed = Math.max(currentSpeed - 10, 0);
        //return currentSpeed;
    }
}