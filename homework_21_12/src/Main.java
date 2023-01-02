import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("GAME");
        Computer computer = new Computer();
        User user = new User();
        do {
            System.out.println("Make your choice, enter Stone, Scissors or Paper, or Q for quit");

            user.setChoice(in.nextLine());
            if (user.getChoice().equals(new String("Q"))) {
                System.out.println("Goodbye");
                break;}
            computer.setComputerChoice(computer.randomize());
            System.out.println("Your choice is: " + user.getChoice());
            System.out.println("Computer's choice is: "+ computer.getComputerChoice());
            Judgement judge = new Judgement(user.getChoice(),computer.getComputerChoice());
            System.out.println("Result is "+ judge.checkResult());

        }while (true);

    }
}
