public class Cat extends Animal implements Movable {

    Cat(String habit,boolean isFly,boolean isMammals){
        super(habit,isFly,isMammals);
    }
    public String move(){
        return "All cats are running";
    }

}
