import java.util.Random;

public class Main {

    static Random rand = new Random();

    static double right = 0;
    static double wrong = 0;
    static double percentRight;

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){ // does the sim n number of times
            start();
        }

        makePercent();
        System.out.println(percentRight * 100 + "%");
    }

    public static void makePercent(){ // updates percent
        percentRight = right / (right + wrong);
    }

    private static void start() {
        int computerChoice = rand.nextInt(3); // generates correct door
        int correctChoice = rand.nextInt(3); // generates computer choice
        int revealedChoice = -1;
        int choice = -1;

        for(int i = 0; i < 3; i++){ // loops through 0, 1, and 2 to find option available to "reveal"
            if(i != correctChoice && i != computerChoice){
                revealedChoice = i;
            }
        }

        for(int i = 0; i < 3; i++){ // switches the computers choice to the other available option. I use a placeholder variable to avoid changes in the number itself to mess with the checking of the computer choice.
            if(i != computerChoice && i != revealedChoice){
                choice = i;
            }
        }

        computerChoice = choice;

        if(computerChoice == correctChoice){ // checks if the choice is right
            right++;
        } else {
            wrong++;
        }
    }
}
