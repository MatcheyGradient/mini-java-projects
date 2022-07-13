import java.util.Scanner;

public class CaesarCipherCycler {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine(); // gets ciphered text

        char[] charArray = text.toCharArray();

        for(int i = 0; i < 26; i++) {
            for (char c : charArray) {
                System.out.print(c);
            }
            System.out.println("");

            for (int j = 0; j < charArray.length; j++) {
                charArray[j] = convertChar(charArray[j]);
            }
        }
    }

    public static char convertChar(char c){ // goofy char shifter. probably an astronomically better way to do this somewhere
        if(c == 'a'){
            return 'b';
        } else if(c == 'b'){
            return 'c';
        } else if(c == 'c'){
            return 'd';
        } else if(c == 'd'){
            return 'e';
        } else if(c == 'e'){
            return 'f';
        } else if(c == 'f'){
            return 'g';
        } else if(c == 'g'){
            return 'h';
        } else if(c == 'h'){
            return 'i';
        } else if(c == 'i'){
            return 'j';
        } else if(c == 'j'){
            return 'k';
        } else if(c == 'k'){
            return 'l';
        } else if(c == 'l'){
            return 'm';
        } else if(c == 'm'){
            return 'n';
        } else if(c == 'n'){
            return 'o';
        } else if(c == 'o'){
            return 'p';
        } else if(c == 'p'){
            return 'q';
        } else if(c == 'q'){
            return 'r';
        } else if(c == 'r'){
            return 's';
        } else if(c == 's'){
            return 't';
        } else if(c == 't'){
            return 'u';
        } else if(c == 'u'){
            return 'v';
        } else if(c == 'v'){
            return 'w';
        } else if(c == 'w'){
            return 'x';
        } else if(c == 'x'){
            return 'y';
        } else if(c == 'y'){
            return 'z';
        } else if(c == 'z'){
            return 'a';
        } else if(c == 'A'){
            return 'B';
        } else if(c == 'B'){
            return 'C';
        } else if(c == 'C'){
            return 'D';
        } else if(c == 'D'){
            return 'E';
        } else if(c == 'E'){
            return 'F';
        } else if(c == 'F'){
            return 'G';
        } else if(c == 'G'){
            return 'H';
        } else if(c == 'H'){
            return 'I';
        } else if(c == 'I'){
            return 'J';
        } else if(c == 'J'){
            return 'K';
        } else if(c == 'K'){
            return 'L';
        } else if(c == 'L'){
            return 'M';
        } else if(c == 'M'){
            return 'N';
        } else if(c == 'N'){
            return 'O';
        } else if(c == 'O'){
            return 'P';
        } else if(c == 'P'){
            return 'Q';
        } else if(c == 'Q'){
            return 'R';
        } else if(c == 'R'){
            return 'S';
        } else if(c == 'S'){
            return 'T';
        } else if(c == 'T'){
            return 'U';
        } else if(c == 'U'){
            return 'V';
        } else if(c == 'V'){
            return 'W';
        } else if(c == 'W'){
            return 'X';
        } else if(c == 'X'){
            return 'Y';
        } else if(c == 'Y'){
            return 'Z';
        } else if(c == 'Z'){
            return 'A';
        }
        return c;
    }
}
