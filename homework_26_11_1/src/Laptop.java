public class Laptop {
    String brand;
    boolean isTurnedOn;
    String welcomePhrase;
    int butteryAmount;

    public Laptop (String brand, boolean isTurnedOn, String welcomePhrase, int butteryAmount) {
        this.brand=brand;
        this.isTurnedOn=isTurnedOn;
        this.welcomePhrase=welcomePhrase;
        this.butteryAmount=butteryAmount;
    }

    public String convertStatus(boolean currentStatus) {
        if (currentStatus) {
            return "ON";
        }
        else {
            return "OFF";
        }
    }
    public String getLaptopBrand () {
        return brand;
    }

    public boolean getIsTurnedOn() {
        return isTurnedOn;
    }

    public boolean setIsTurnedOn (boolean isTurned) {
        this.isTurnedOn = isTurned;
        return isTurnedOn;
    }

    public boolean carTurnOnOff() {
        boolean currentStatus = getIsTurnedOn();
        return setIsTurnedOn(!currentStatus);
    }

    public void getWelcomePhrase () {
        System.out.println(welcomePhrase);
    }

    public int getButteryAmount () {
        return butteryAmount;
    }
    
    public void setButtery (){
        int currentAmount = getButteryAmount();
        butteryAmount -=Math.min(10,currentAmount);
        //butteryAmount -=10;
    }
    public void lowButteryAmount (boolean currentStatus) {
        if (butteryAmount <= 0){
            System.out.println("Your buttery amount is 0. laptop was turned off " + (carTurnOnOff()));
        }
        else if (butteryAmount > 0 && butteryAmount <= 10){
            System.out.println("Low charge buttery.You need to charge your laptop.");
        }
        else  {
            //setButtery();
            System.out.println(getButteryAmount());
    }
    }
}
