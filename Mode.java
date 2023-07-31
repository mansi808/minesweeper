package minesweeper;
import java.util.*;

public enum Mode {
    FREE() {
        @Override
        public void performFunction() {
            playingBoard.setSurroundingMinesNum(x,y);
        }
    },
    MINE() {
        @Override
        public void performFunction() {
            //if "*" then to --> "."
            //if "." then to --> "*"
            playingBoard.contents[y][x] = playingBoard.contents[y][x].equals(playingBoard.unexploredFieldSymbol) ?  playingBoard.setMineSymbol : (playingBoard.contents[y][x].equals(playingBoard.setMineSymbol) ? playingBoard.unexploredFieldSymbol : playingBoard.contents[y][x]);
            if (playingBoard.minePositions.contains(new ArrayList<>(Arrays.asList(x,y)))) {
                Game.incrementFoundMineNum();
            }
        }
    };

    protected Board playingBoard;
    protected int x;
    protected int y;
    public abstract void performFunction();

    //setting mode according to user input
    //default mode = FREE
    public static Mode getMode(String option) {
        if (option.equals(MINE.name())) return Mode.MINE;
        else return Mode.FREE;
    }

    //associate mode with a board
    public void setBoard(Board board) {
        playingBoard = board;
    }

    //associate mode with set of positions
    public void setPositions(int posX, int posY) {
        x = posX;
        y = posY;
    }
}
