//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

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

        print2DArray(twoDArray);


    }
    public static void print2DArray(int[][] twoDArray){
        System.out.println("|---|---|---|");
        for (int i = 0; i< 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.print(twoDArray[i][j] + " | ");
            }
            System.out.println();
            System.out.println("|---|---|---|");
        }
    }
}