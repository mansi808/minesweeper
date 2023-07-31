package minesweeper;
import java.util.*;

//all positions are stored as x,y

public class Board {
    public int minesNum = 0;
    public int height;
    public int width;
    String unexploredFieldSymbol = "."; //unexplored position
    String exploredFieldSymbol = "/"; //has no surrounding mines when explored
    String setMineSymbol = "*"; //according to user input ->spaces which contains mines
    String mineSymbol = "X"; //exposed when user loses
    public String[][] contents;
    public ArrayList<ArrayList<Integer>> minePositions = new ArrayList<>(minesNum);
    public ArrayList<ArrayList<Integer>> exploredFieldPositions = new ArrayList<>();


    Board(int height, int width) {
        this.height = height;
        this.width = width;
        contents = setContents();
    }


    public void setMinesNum(Scanner scanner) {
        minesNum = scanner.nextInt();
    }

    public String[][] setContents() {
        String[][] array = new String[height][width];
        for (int i=0; i<height; i++) {
            Arrays.fill(array[i], unexploredFieldSymbol);
        }
        return array;
    }

    public void setMinesPos(Random random) {
        for (int i=1; i<=minesNum; i++) {
            int x = random.nextInt(0, width);
            int y = random.nextInt(0, height);
            if (!contents[y][x].equals(mineSymbol)) {
                ArrayList<Integer> minePos = new ArrayList<>(Arrays.asList(x,y));
                minePositions.add(minePos);
            } else {
                i--;
            }
        }
    }

    public void setSurroundingMinesNum(int x, int y) {
        exploredFieldPositions.add(new ArrayList<>(Arrays.asList(x,y)));
        int surroundingMineNum = 0;
        for (int i = -1; i <= +1; i++) {
            for (int j = -1; j <= +1; j++) {
                if (!(x+j==x && y+i==y) && (y + i < height) && (x + j < width) && (y + i > -1) && (x + j > -1)) {
                    if (minePositions.contains(Arrays.asList(x + j, y + i))) {
                        surroundingMineNum++;
                    }
                }
            }
        }
        switch (surroundingMineNum) {
           case 0 -> {
                contents[y][x] = exploredFieldSymbol;
                for (int i = -1; i <= +1; i++) {
                    for (int j = -1; j <= +1; j++) {
                        if (!(x + j == x && y + i == y) && (y + i < height) && (x + j < width) && (y + i > -1) && (x + j > -1)) {
                            if (!exploredFieldPositions.contains(Arrays.asList(x + j, y + i))) {
                                setSurroundingMinesNum(x + j, y + i);
                            }
                        }

                    }
                }
           } default -> contents[y][x] = String.valueOf(surroundingMineNum);
        }
    }

    public int getElementNum(String symbol) {
        int N = 0;
        for (String[] row: contents) {
            for (String element : row) {
                if (element.equals(symbol)) N++;
            }
        } return N;
    }

}

