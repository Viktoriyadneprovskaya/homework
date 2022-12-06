public class Cat extends Animal implements Move{

    Cat(String habit,boolean isFly,boolean isMammals){
        super(habit,isFly,isMammals);
    }
    public String move(){
        return "All cats are running";
    }

    @Override
    public String voice() {

        return "";
    }
}
