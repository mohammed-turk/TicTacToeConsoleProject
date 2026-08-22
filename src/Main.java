import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] twoDArray = new int[3][3];
        twoDArray[0][0] = 1;
        twoDArray[0][1] = 2;
        twoDArray[0][2] = 3;
        twoDArray[1][0] = 4;
        twoDArray[1][1] = 5;
        twoDArray[1][2] = 6;
        twoDArray[2][0] = 7;
        twoDArray[2][1] = 8;
        twoDArray[2][2] = 9;


        int playerNumber, computerNumber;

        int playerValue = 10;
        int computerValue = 11;

        boolean playerExit;
        boolean computerExit;
        int[] index;

        while (!checkWin(twoDArray)){

            playerExit = false;
            while (!playerExit) {
                print2DArray(twoDArray);
                System.out.println("Input player choice between 1 and 9: ");
                playerNumber = scanner.nextInt();
                index = getIndex(playerNumber);
                if (twoDArray[index[0]][index[1]] != 10 && twoDArray[index[0]][index[1]] != 11 ){
                    twoDArray[index[0]][index[1]] = 10;
                    playerExit = true;
                    System.out.println("Valid choice");
                }
                else
                    System.out.println("Invalid choice");


            }

            computerExit = false;
            while (!computerExit) {
                print2DArray(twoDArray);
                System.out.println("Computer choice: ");
                computerNumber = getRandom();
                index = getIndex(computerNumber);
                if (twoDArray[index[0]][index[1]] != 10 && twoDArray[index[0]][index[1]] != 11 ){
                    twoDArray[index[0]][index[1]] = 11;
                    computerExit = true;
                    System.out.println("Valid number");

                }
                else
                    System.out.println("Invalid number");
            }

        }
        print2DArray(twoDArray);






    }
    public static void print2DArray(int[][] twoDArray){
        System.out.println("|---|---|---|");
        for (int i = 0; i< 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                if (twoDArray[i][j] == 10)
                    System.out.print("X" + " | ");
                else if (twoDArray[i][j] == 11)
                    System.out.print("O" + " | ");
                else
                    System.out.print(twoDArray[i][j] + " | ");
            }
            System.out.println();
            System.out.println("|---|---|---|");
        }
    }
    public static boolean checkWin(int[][] twoDArray ){

        if (
                (twoDArray[0][0] == twoDArray[0][1] && twoDArray[0][0] == twoDArray[0][2])
                ||
                (twoDArray[1][0] == twoDArray[1][1] && twoDArray[1][0] == twoDArray[1][2])
                ||
                (twoDArray[2][0] == twoDArray[2][1] && twoDArray[2][0] == twoDArray[2][2])
                ||
                (twoDArray[0][0] == twoDArray[1][1] && twoDArray[0][0] == twoDArray[2][2])
                ||
                (twoDArray[0][2] == twoDArray[1][1] && twoDArray[0][2] == twoDArray[2][0])
                ||
                (twoDArray[0][0] == twoDArray[1][0] && twoDArray[0][0] == twoDArray[2][0])
                ||
                (twoDArray[0][1] == twoDArray[1][1] && twoDArray[0][1] == twoDArray[2][1])
                ||
                (twoDArray[0][2] == twoDArray[1][2] && twoDArray[0][2] == twoDArray[2][2])
        ){
            return true;
        }
        else
            return false;

    }
    public static int getRandom(){
        return ( (int) ((Math.random() * 9)) + 1);
    }

    public static int[] getIndex(int number){
        int[] index = new int[2];
        if (number == 1){
            index[0] = 0;
            index[1] = 0;
        } else if (number == 2) {
            index[0] = 0;
            index[1] = 1;
        }
        else if (number == 3) {
            index[0] = 0;
            index[1] = 2;
        } else if (number == 4) {
            index[0] = 1;
            index[1] = 0;
        }
        else if (number == 5) {
            index[0] = 1;
            index[1] = 1;
        }
        else if (number == 6) {
            index[0] = 1;
            index[1] = 2;
        }
        else if (number == 7) {
            index[0] = 2;
            index[1] = 0;
        }
        else if (number == 8) {
            index[0] = 2;
            index[1] = 1;
        }
        else if (number == 9) {
            index[0] = 2;
            index[1] = 2;
        }
        return index;
    }



}