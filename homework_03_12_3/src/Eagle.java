public class Eagle extends Bird{
    String color;

    Eagle(String habit,boolean isFly,boolean isMammals,String color){
        super(habit,isFly,isMammals);
        this.color=color;
    }

    String getColor() {
        return color;
    }
    public String move(){
        return "Eagle is flying";
    }
}
