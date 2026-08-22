import java.util.InputMismatchException;
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

        int numberOfRounds = 0;


        int playerNumber, computerNumber;

        int playerValue = 10;
        int computerValue = 11;
        boolean tie = false;

        boolean playerExit;
        boolean computerExit;
        int[] index;

            while (!checkWin(twoDArray)[0] && !tie){

                playerExit = false;
                while (!playerExit && !tie) {
                    if (checkFull(twoDArray)) {
                        System.out.println("Tie");
                        tie = true;
                        break;
                    }
                    print2DArray(twoDArray);
                    System.out.println("Input player choice between 1 and 9: ");

                    try {
                        playerNumber = scanner.nextInt();
                        inValaidNumber(playerNumber);
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Please enter a number");
                        scanner.next();
                        continue;
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    index = getIndex(playerNumber);

                    if (twoDArray[index[0]][index[1]] != 10 && twoDArray[index[0]][index[1]] != 11
                            && (
                            (twoDArray[0][0] == 1)
                                    ||
                                    (twoDArray[0][1] == 2)
                                    ||
                                    (twoDArray[0][2] == 3)
                                    ||
                                    (twoDArray[1][0] == 4)
                                    ||
                                    (twoDArray[1][1] == 5)
                                    ||
                                    (twoDArray[1][2] == 6)
                                    ||
                                    (twoDArray[2][0] == 7)
                                    ||
                                    (twoDArray[2][1] == 8)
                                    ||
                                    (twoDArray[2][2] == 9)


                    )
                    ){
                        twoDArray[index[0]][index[1]] = 10;
                        playerExit = true;
                    }
                    else
                        System.out.println("Invalid choice");


                }

                computerExit = false;
                while (!computerExit && !tie) {
                    if (checkFull(twoDArray)) {
                        System.out.println("Tie");
                        tie = true;
                        break;
                    }
                    print2DArray(twoDArray);
                    System.out.print("Computer choice: ");
                    computerNumber = getRandom();
                    System.out.println(" " + computerNumber);
                    try {
                        inValaidNumber(computerNumber);
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Please enter a number");
                        scanner.next();
                        continue;
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    index = getIndex(computerNumber);
                    if (twoDArray[index[0]][index[1]] != 10 && twoDArray[index[0]][index[1]] != 11
                            && (
                            (twoDArray[0][0] == 1)
                                    ||
                                    (twoDArray[0][1] == 2)
                                    ||
                                    (twoDArray[0][2] == 3)
                                    ||
                                    (twoDArray[1][0] == 4)
                                    ||
                                    (twoDArray[1][1] == 5)
                                    ||
                                    (twoDArray[1][2] == 6)
                                    ||
                                    (twoDArray[2][0] == 7)
                                    ||
                                    (twoDArray[2][1] == 8)
                                    ||
                                    (twoDArray[2][2] == 9)


                    )
                    ){
                        twoDArray[index[0]][index[1]] = 11;
                        computerExit = true;


                    }
                    else
                        System.out.println("Invalid number");
                }

                if (checkWin(twoDArray)[0]){
                    if (checkWin(twoDArray)[1] && !tie){
                        print2DArray(twoDArray);
                        System.out.println("Player has won");
                    }
                    else if (!checkWin(twoDArray)[1] && !tie) {
                        print2DArray(twoDArray);
                        System.out.println("Computer has won");
                    }

                }

            }









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
    public static boolean[] checkWin(int[][] twoDArray ){
        boolean win;
        boolean playerWon;
        boolean[] result = new boolean[2];

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

            if(
                    (twoDArray[0][0] == twoDArray[0][1] && twoDArray[0][0] == twoDArray[0][2] && twoDArray[0][0] == 10)
                            ||
                            (twoDArray[1][0] == twoDArray[1][1] && twoDArray[1][0] == twoDArray[1][2] && twoDArray[1][0] == 10)
                            ||
                            (twoDArray[2][0] == twoDArray[2][1] && twoDArray[2][0] == twoDArray[2][2] && twoDArray[2][0] == 10)
                            ||
                            (twoDArray[0][0] == twoDArray[1][1] && twoDArray[0][0] == twoDArray[2][2] && twoDArray[0][0] == 10)
                            ||
                            (twoDArray[0][2] == twoDArray[1][1] && twoDArray[0][2] == twoDArray[2][0] && twoDArray[0][2] == 10)
                            ||
                            (twoDArray[0][0] == twoDArray[1][0] && twoDArray[0][0] == twoDArray[2][0] && twoDArray[0][0] == 10)
                            ||
                            (twoDArray[0][1] == twoDArray[1][1] && twoDArray[0][1] == twoDArray[2][1] && twoDArray[0][1] == 10)
                            ||
                            (twoDArray[0][2] == twoDArray[1][2] && twoDArray[0][2] == twoDArray[2][2] && twoDArray[0][2] == 10)
            ){
                win = true;
                playerWon = true;
                result[0] = win;
                result[1] = playerWon;
            }
            else{
                result[0] = true;
                result[1] = false;
            }
            return result;
        }
        else{
            result[0] = false;
            result[1] = false;
            return result;
        }


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

    public static boolean checkFull(int[][] twoDArray){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (twoDArray[i][j] != 10 && twoDArray[i][j] != 11)
                    return false;
        return true;
    }

    public static void inValaidNumber(int number) throws Exception{
        if (!(number >= 1 && number <=9))
            throw new Exception("numbers should be between 1 and 9");
    }



}