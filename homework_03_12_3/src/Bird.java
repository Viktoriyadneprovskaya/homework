public class Bird extends Animal implements Move{

    Bird(String habit,boolean isFly,boolean isMammals){
        super(habit,isFly,isMammals);
    }
    public String move(){
        return "All birds are flying";
    }//почему не работало в лайне,пока не добавила сюда пустой метод

    @Override
    public String voice() {
        return "";
    }

}
