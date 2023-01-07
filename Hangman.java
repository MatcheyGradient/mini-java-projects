import java.util.Scanner;

public class Hangman {

    static int wrongLimit = 6;


    public static void main(String[] args){
        hang("zero0 lol");
    }

    static void hang(String word){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String[] words = word.split(" ");
        char[] guessArray = new char[word.length()];
        boolean done = false;

        System.out.println("Max amount of wrongs allowed: " + wrongLimit);
        printBoard(words);

        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ' ') guessArray[i] = ' ';
        }

        while(!done){
            boolean found = false;
            char guess = ' ';
            try{
                guess = sc.nextLine().charAt(0);
                if(sb.toString().contains(guess + "")){
                    guess = 0;
                    System.out.println("You have already guessed that wrong letter, try again.\n");
                    continue;
                }
            } catch (Exception ignored){ }

            for(int i = 0; i < word.length(); i++){
                if(word.charAt(i) == guess){
                    guessArray[i] = guess;
                    found = true;
                }
            }

            if(!found) sb.append(guess);
            System.out.printf("Wrong: %d\n", sb.length());
            if(sb.length() > wrongLimit){
                done = true;
                System.out.println("You failed to guess the word. :(");
            }

            for(char c : guessArray){
                System.out.print((c == 0)? "  " : (c != ' ')? c + " " : c);
            }

            System.out.println();
            printBoard(words);

            if(word.equals(new String(guessArray))){
                done = true;
                System.out.println("Congrats! You guessed all the letters correctly!");
            }
        }
    }

    static void printBoard(String[] words){
        for (String s : words) {
            for(int i = 0; i < s.length(); i++){
                System.out.print("- ");
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}