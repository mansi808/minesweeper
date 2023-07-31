# minesweeper

cli version of minesweeper

---Enter x, y, mode <br></br>
---Mode --> free try to find safe fields <br></br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--> mine set/ unset mines on field <br> </br>

```
How many mines do you want on the field? 10

 |123456789|
-|---------|
1|.........|
2|.........|
3|.........|
4|.........|
5|.........|
6|.........|
7|.........|
8|.........|
9|.........|
-|---------|
Set/unset mines marks or claim a cell as free: 1 6 free

 |123456789|
-|---------|
1|.........|
2|.........|
3|.........|
4|111......|
5|//1......|
6|//2......|
7|/13......|
8|/2.......|
9|/2.......|
-|---------|
Set/unset mines marks or claim a cell as free: 8 2 free

 |123456789|
-|---------|
1|.........|
2|.......1.|
3|.........|
4|111......|
5|//1......|
6|//2......|
7|/13......|
8|/2.......|
9|/2.......|
-|---------|
Set/unset mines marks or claim a cell as free: 8 8 free

 |123456789|
-|---------|
1|.........|
2|.......1.|
3|.........|
4|111......|
5|//1......|
6|//2......|
7|/13......|
8|/2.....1.|
9|/2.......|
-|---------|
Set/unset mines marks or claim a cell as free: 1 3 free

 |123456789|
-|---------|
1|.........|
2|22.....1.|
3|/1.......|
4|111......|
5|//1......|
6|//2......|
7|/13......|
8|/2.....1.|
9|/2.......|
-|---------|

 |123456789|
-|---------|
1|X........|
2|22.....1.|
3|X1.X....X|
4|111......|
5|//1......|
6|//2X.....|
7|/13X....X|
8|/2X.X..1.|
9|/2X......|
-|---------|
You stepped on a mine and failed!

```
```

How many mines do you want on the field? 4

 |123456789|
-|---------|
1|.........|
2|.........|
3|.........|
4|.........|
5|.........|
6|.........|
7|.........|
8|.........|
9|.........|
-|---------|
Set/unset mines marks or claim a cell as free: 5 6 free
0

 |123456789|
-|---------|
1|.1//1....|
2|11//1....|
3|////1....|
4|////1....|
5|////112..|
6|//////111|
7|/////////|
8|/////////|
9|/////////|
-|---------|
Set/unset mines marks or claim a cell as free: 1 1 mine
1

 |123456789|
-|---------|
1|*1//1....|
2|11//1....|
3|////1....|
4|////1....|
5|////112..|
6|//////111|
7|/////////|
8|/////////|
9|/////////|
-|---------|
Set/unset mines marks or claim a cell as free: 9 3 free
1

 |123456789|
-|---------|
1|*1//1.1//|
2|11//1.1//|
3|////1.1//|
4|////1.211|
5|////112..|
6|//////111|
7|/////////|
8|/////////|
9|/////////|
-|---------|
Set/unset mines marks or claim a cell as free: 6 4 mine
2

 |123456789|
-|---------|
1|*1//1.1//|
2|11//1.1//|
3|////1.1//|
4|////1*211|
5|////112..|
6|//////111|
7|/////////|
8|/////////|
9|/////////|
-|---------|
Set/unset mines marks or claim a cell as free: 8 5 mine
3

 |123456789|
-|---------|
1|*1//1.1//|
2|11//1.1//|
3|////1.1//|
4|////1*211|
5|////112*.|
6|//////111|
7|/////////|
8|/////////|
9|/////////|
-|---------|
Set/unset mines marks or claim a cell as free: 9 5 free
3

 |123456789|
-|---------|
1|*1//1.1//|
2|11//1.1//|
3|////1.1//|
4|////1*211|
5|////112*1|
6|//////111|
7|/////////|
8|/////////|
9|/////////|
-|---------|
Set/unset mines marks or claim a cell as free: 6 1 free
3

 |123456789|
-|---------|
1|*1//1/1//|
2|11//111//|
3|////1.1//|
4|////1*211|
5|////112*1|
6|//////111|
7|/////////|
8|/////////|
9|/////////|
-|---------|
Congratulations! You found all the mines!

Process finished with exit code 0

```


