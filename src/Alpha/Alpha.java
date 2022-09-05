package Alpha;

public class Alpha {

    int computer[][][] = new int[15][15][5];//电脑
    int player[][][] = new int[15][15][5];//玩家
    final static int[][] COMPUTER_SCORE = new int[][] { { 20, 30, 790, 800000 }, { 35, 800, 15000, 800000 } };
    final static int[][] PLAYER_SCORE = new int[][] { { 5, 10, 390, 100000 }, { 15, 400, 7000, 100000 } };

    interface Students {
        public default String getDesc() {
            return "顺序查找策略，有空即返回";
        }

        public default String getName() {
            return "五子棋";
        }

        public default String getSID() {
            return "五子棋";
        }

        public default String getDept() {
            return "五子棋";
        }
    }

    // 向机器人注入棋盘状态数组
    public Alpha() {

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                for (int k = 0; k < 5; k++) {
                    computer[i][j][k] = 0;
                    player[i][j][k] = 0;
                }
    }

    public int[] getPoint(int a[][]) {
        int[] point = new int[2];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (a[i][j] == 0) {
                    setComputerAndPlayer(a, i, j, 1);
                    setComputerAndPlayer(a, i, j, 2);
                }
            }
        point = getMax();
        return point;
    }

    public int[] getMax() {
        int[] result = new int[2];
        int computerMax = 0;
        int computerX = 0;
        int computerY = 0;
        int playerMax = 0;
        int playerX = 0;
        int playerY = 0;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (computerMax < computer[i][j][4]) {
                    computerMax = computer[i][j][4];
                    computerX = i;
                    computerY = j;
                }
            }
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (playerMax < player[i][j][4]) {
                    playerMax = player[i][j][4];
                    playerX = i;
                    playerY = j;
                }
            }

        if (computerMax > playerMax) {
            result[0] = computerX;
            result[1] = computerY;
        } else {
            result[0] = playerX;
            result[1] = playerY;
        }
        return result;
    }

    public void setComputerAndPlayer(int[][] a, int row, int col, int n) {
        getRow(a, row, col, n);
        getCol(a, row, col, n);
        getForward(a, row, col, n);
        getBack(a, row, col, n);
    }

    public void getRow(int[][] a, int row, int col, int n) {
        int count1 = 0;
        int count2 = 0;
        int flag1 = 0;
        int flag2 = 0;
        int result = 0;
        int flag = 0;
        // 横向遍历
        for (int i = row - 1; i >= 0; i--) {
            if (a[i][col] == n) {
                count1++;
                if (i == 0) {
                    flag1 = 1;
                    break;
                }
            } else if (a[i][col] == 0) {
                flag1 = 2;
                break;
            } else {
                flag1 = 1;
                break;
            }
        }
        for (int i = row + 1; i < 9; i++) {
            if (a[i][col] == n) {
                count2++;
                if (i == 8) {
                    flag2 = 1;
                    break;
                }
            } else if (a[i][col] == 0) {
                flag2 = 2;
                break;
            } else {
                flag2 = 1;
                break;
            }
        }
        result = count1 + count2 + 1;
        if (result <= 1)
            return;
        if (result > 5)
            return;
        if (flag1 == 2 && flag2 == 2)
            flag = 2;
        else if (flag1 == 1 && flag2 == 1)
            flag = 0;
        else
            flag = 1;
        if (n == 1) {
            if (flag != 0) {
                player[row][col][0] = PLAYER_SCORE[flag - 1][result - 2];
                player[row][col][4] += player[row][col][0];
            }

        } else {
            if (flag != 0) {
                computer[row][col][0] = COMPUTER_SCORE[flag - 1][result - 2];
                computer[row][col][4] += computer[row][col][0];
            }
        }
    }

    public void getCol(int a[][], int row, int col, int n) {
        int count1 = 0;
        int count2 = 0;
        int flag1 = 0;
        int flag2 = 0;
        int result = 0;
        int flag = 0;
        // 横向遍历
        for (int i = col - 1; i >= 0; i--) {
            if (a[row][i] == n) {
                count1++;
                if (i == 0) {
                    flag1 = 1;
                    break;
                }
            } else if (a[row][i] == 0) {
                flag1 = 2;
                break;
            } else {
                flag1 = 1;
                break;
            }
        }
        for (int i = col + 1; i < 9; i++) {
            if (a[row][i] == n) {
                count2++;
                if (i == 8) {
                    flag2 = 1;
                    break;
                }
            } else if (a[row][i] == 0) {
                flag2 = 2;
                break;
            } else {
                flag2 = 1;
                break;
            }
        }
        result = count1 + count2 + 1;
        if (result <= 1)
            return;
        if (result > 5)
            return;
        if (flag1 == 2 && flag2 == 2)
            flag = 2;
        else if (flag1 == 1 && flag2 == 1)
            flag = 0;
        else
            flag = 1;
        if (n == 1) {
            if (flag != 0) {
                player[row][col][1] = PLAYER_SCORE[flag - 1][result - 2];
                player[row][col][4] += player[row][col][1];
            }
        } else {
            if (flag != 0) {
                computer[row][col][1] = COMPUTER_SCORE[flag - 1][result - 2];
                computer[row][col][4] += computer[row][col][1];
            }
        }
    }

    public void getForward(int a[][], int row, int col, int n) {
        int count1 = 0;
        int count2 = 0;
        int flag1 = 0;
        int flag2 = 0;
        int result = 0;
        int flag = 0;
        // 横向遍历
        for (int i = row + 1, j = col - 1; i < 9 && j >= 0; i++, j--) {
            if (a[i][j] == n) {
                count1++;
                if (i == 8 && j == 0) {
                    flag1 = 1;
                    break;
                }
            } else if (a[i][j] == 0) {
                flag1 = 2;
                break;
            } else {
                flag1 = 1;
                break;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < 9; i--, j++)

        {
            if (a[i][j] == n) {
                count2++;
                if (i == 0 && j == 8) {
                    flag2 = 1;
                    break;
                }
            } else if (a[i][j] == 0) {
                flag2 = 2;
                break;
            } else {
                flag2 = 1;
                break;
            }
        }
        result = count1 + count2 + 1;
        if (result <= 1)
            return;
        if (result > 5)
            return;
        if (flag1 == 2 && flag2 == 2)
            flag = 2;
        else if (flag1 == 1 && flag2 == 1)
            flag = 0;
        else
            flag = 1;
        if (n == 1) {
            if (flag != 0) {
                player[row][col][2] = PLAYER_SCORE[flag - 1][result - 2];
                player[row][col][4] += player[row][col][2];
            }
        } else {
            if (flag != 0) {
                computer[row][col][2] = COMPUTER_SCORE[flag - 1][result - 2];
                computer[row][col][4] += computer[row][col][2];
            }
        }
    }

    public void getBack(int a[][], int row, int col, int n) {
        int count1 = 0;
        int count2 = 0;
        int flag1 = 0;
        int flag2 = 0;
        int result = 0;
        int flag = 0;
        for (int i = row + 1, j = col + 1; i < 9 && j < 9; i++, j++) {
            if (a[i][j] == n) {
                count1++;
                if (i == 8 && j == 8) {
                    flag1 = 1;
                    break;
                }
            } else if (a[i][j] == 0) {
                flag1 = 2;
                break;
            } else {
                flag1 = 1;
                break;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (a[i][j] == n) {
                count2++;
                if (i == 0 && j == 0) {
                    flag2 = 1;
                    break;
                }
            } else if (a[i][j] == 0) {
                flag2 = 2;
                break;
            } else {
                flag2 = 1;
                break;
            }
        }
        result = count1 + count2 + 1;
        if (result <= 1)
            return;
        if (result > 5)
            return;
        if (flag1 == 2 && flag2 == 2)
            flag = 2;
        else if (flag1 == 1 && flag2 == 1)
            flag = 0;
        else
            flag = 1;
        if (n == 1) {
            if (flag != 0) {
                player[row][col][3] = PLAYER_SCORE[flag - 1][result - 2];
                player[row][col][4] += player[row][col][3];
            }
        } else {
            if (flag != 0) {
                computer[row][col][3] = COMPUTER_SCORE[flag - 1][result - 2];
                computer[row][col][4] += player[row][col][3];
            }
        }
    }

}

