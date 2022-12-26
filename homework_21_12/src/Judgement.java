public class Judgement {
    String sentence;
    String computerChoice;
    String userChoice;

    public Judgement(String userChoice, String computerChoice){
        this.computerChoice = computerChoice;
        this.userChoice = userChoice;
    }

    public String getSentence(){
        if (computerChoice.equals(userChoice)) {sentence = "Draw";}

        else if ((computerChoice.equals(new String("Stone")))&&(userChoice.equals(new String("Scissors")))) {sentence = "Computer won";}
        else if ((computerChoice.equals(new String("Paper")))&&(userChoice.equals("Stone"))) {sentence = "Computer won";}
        else if ((computerChoice.equals(new String("Scissors")))&&(userChoice.equals(new String("Paper")))) {sentence = "Computer won";}

        else if ((computerChoice.equals(new String("Scissors")))&&(userChoice.equals(new String("Stone")))) {sentence = "You won";}
        else if ((computerChoice.equals(new String("Stone")))&&(userChoice.equals(new String("Paper")))) {sentence = "You won";}
        else if ((computerChoice.equals(new String("Paper")))&&(userChoice.equals(new String("Scissors")))) {sentence = "You won";}
        else {sentence = "You made wrong choice";}
        return sentence;
    }
}
