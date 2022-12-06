public class Lion extends Cat {
    int maxLength;
    Lion(String habit,boolean isFly,boolean isMammals,int maxLength
    ){
        super(habit,isFly,isMammals);
        this.maxLength=maxLength;
    }
    int getMaxLength(){
        return maxLength;
    }
    public String move(){
       return "Lion is running";
    }
    public String voice(){
        return "Lion is roaring";
    }
}
