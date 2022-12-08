
public class Animal {
    String habit;
    boolean isFly;
    boolean isMammals;

    Animal(String habit,boolean isFly,boolean isMammals){
        this.habit=habit;
        this.isFly=isFly;
        this.isMammals=isMammals;
    }
   String convert(boolean getConvert){
       if(getConvert){
            return "Yes";
       }
        else{
          return "No";
        }
   }
    String getHabit(){
        return habit;
    }

    boolean getIsFly(){
        return isFly;
    }

    boolean getIsMammals(){
        return isMammals;
    }
}
