public class Computer {
    String computerChoice;
    String[] rand = {"Stone", "Scissors", "Paper"};
    Computer(){}
    public String randomize(){
        return rand[(int) (Math.random()*2)];
    }

    public void setComputerChoice(String computerChoice) {
        this.computerChoice = computerChoice;
    }

    public String getComputerChoice(){
        return computerChoice;
    }
}
