public class Bird extends Animal implements Movable {

    Bird(String habit,boolean isFly,boolean isMammals){
        super(habit,isFly,isMammals);
    }
    public String move(){
        return "All birds are flying";
    }

}
