package minesweeper;
import java.util.*;

public class Game {
    public Board playingBoard;
    private boolean end = false;
    public Mode mode;
    private static int foundMineNum = 0;
    private boolean bombed = false;

    private ArrayList<Integer> userInput = new ArrayList<>(1);

    Game(Board playingBoard) {
        this.playingBoard = playingBoard;
    }

    protected void printBoard(Board board) {
        System.out.print(" |123456789|\n" +
                "-|---------|\n");
        for (int i = 0; i < board.height; i++) {
            System.out.printf("%d|", (i + 1));
            for (int j = 0; j < board.width; j++) {
                System.out.print(board.contents[i][j]);
            }
            System.out.print("|\n");
        }
        System.out.print("-|---------|\n");
    }

    public static void incrementFoundMineNum() {
        foundMineNum++;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        intro(scanner);
        scanner.nextLine();
        System.out.println();
        playingBoard.setMinesPos(random);

        printBoard(playingBoard);
        while (!bombed && !end) {

            System.out.print("Set/unset mines marks or claim a cell as free: ");
            try {
                //input --> x,y and mode
                String[] userInputString = scanner.nextLine().split("[\\s]");
                userInput.clear();
                userInput.add(Integer.valueOf(userInputString[0]) - 1);
                userInput.add(Integer.valueOf(userInputString[1]) - 1);
                mode = Mode.getMode(userInputString[2].toUpperCase());

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                userInput.clear();
                continue;
            }
            //checking if place contains a mine
            if (mode!= Mode.MINE) {
                bombed = isBombed(userInput.get(0), userInput.get(1));
            }

            //initializing mode with a board and positions(x,y)
            mode.setBoard(playingBoard);
            mode.setPositions(userInput.get(0), userInput.get(1));

            //performing changes on board according to mode specified
            mode.performFunction();
            System.out.println(foundMineNum);

            System.out.print("\n");
            printBoard(playingBoard);

            //checking if player wins
            end = isEnd();
        }
        if (end) {
            System.out.println("Congratulations! You found all the mines!");
        } else if (bombed) {
            System.out.print("\n");
            for (ArrayList<Integer> minePosition: playingBoard.minePositions) {
                playingBoard.contents[minePosition.get(1)][minePosition.get(0)] = playingBoard.mineSymbol;
            }
            printBoard(playingBoard);
            System.out.println("You stepped on a mine and failed!\n");
        }
    }

    private boolean isEnd() {
        // if "." + "*" on board == total number of mines
        return foundMineNum+ playingBoard.getElementNum(playingBoard.unexploredFieldSymbol) == playingBoard.minesNum || foundMineNum== playingBoard.minesNum;
    }

    private boolean isBombed(int x,int y) {
        //checking if user entered a mine position
        return playingBoard.minePositions.contains(new ArrayList<>(Arrays.asList(x,y)));
    }

    //checking errors and asking user for mine numbers
    private void intro(Scanner scanner) {
        try {
            System.out.print("How many mines do you want on the field? ");

            playingBoard.setMinesNum(scanner);
            if (playingBoard.minesNum>0) return;
        } catch (InputMismatchException e) {}
        System.out.println("Error! only enter numbers greater than zero!");
        scanner.nextLine();
        intro(scanner);
    }

}
