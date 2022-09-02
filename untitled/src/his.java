import java.util.Scanner;
public class his {
        public static void main(String[] args) {
            //定义一个二维数组,第一个参数是行，第二个参数是列
            int[][] checkerBoard = new int[16][16];
            //绘制棋盘
            System.out.println("-------棋盘-------");
            for(int i=0;i<16;i++) {
                for(int j=0;j<16;j++) {
                    if(i == 0) {
                        checkerBoard[i][j] = j;//第一行的数字
                    }else if(j == 0) {
                        checkerBoard[i][j] = i;//第一列数字
                    }else {
                        checkerBoard[i][j] = 0;
                    }
                    if(checkerBoard[i][j] >= 10) {
                        System.out.print(checkerBoard[i][j]+" ");
                    }else {
                        System.out.print(checkerBoard[i][j]+"  ");
                    }
                }

                System.out.println();
            }
            //提示
            System.out.println("1表示黑方；2表示白方");
            System.out.println("规则：轮流下棋，输入想下棋位置的X，Y坐标；X为行数，Y列数。");
            System.out.println("请确认哪方先下棋，黑方先手则输入1，白方先手输入2");
            Scanner input = new Scanner(System.in);
            int choose = input.nextInt();//定义变量，判断奇偶选择谁下棋
            int blackX = 0;//黑方下棋位置变量
            int blackY = 0;
            int whiteX = 0;//白方下棋位置变量
            int whiteY = 0;
            int end = 1;//下棋结束信号，知道是谁下完了

            while(true) {
                if(choose%2 == 1) {//黑方先手
                    System.out.println("黑方：请输入坐标 XY");
                    blackX = input.nextInt();
                    blackY = input.nextInt();
                    checkerBoard[blackX][blackY] = 1;//赋值
                    end = 1;
                    //调用方法
                    if(win(end,blackX,blackY,checkerBoard) == 1){
                        System.out.println("恭喜黑方获胜");
                        break;
                    }
                    choose++;//更新变量，换人下棋
                }else {
                    System.out.println("白方：请输入坐标 XY");
                    whiteX = input.nextInt();
                    whiteY = input.nextInt();
                    checkerBoard[whiteX][whiteY] = 2;
                    end = 2;
                    if(win(end,whiteX,whiteY,checkerBoard) == 1){
                        System.out.println("恭喜白方获胜");
                        break;
                    }
                    choose++;
                }
                //下棋中刷新棋盘
                for(int k=0;k<16;k++) {
                    for(int l=0;l<16;l++) {
                        if(checkerBoard[k][l] >= 10) {
                            System.out.print(checkerBoard[k][l]+" ");
                        }else {
                            System.out.print(checkerBoard[k][l]+"  ");
                        }
                    }
                    System.out.println();
                }

            }
            //获胜后刷新棋盘
            for(int k=0;k<16;k++) {
                for(int l=0;l<16;l++) {
                    if(checkerBoard[k][l] >= 10) {
                        System.out.print(checkerBoard[k][l]+" ");
                    }else {
                        System.out.print(checkerBoard[k][l]+"  ");
                    }
                }
                System.out.println();
            }

        }
        //判断胜负
        public static int win(int end,int X,int Y,int[][] map) {
            //X行数
            //Y列数
            int count = 0;//计算相同棋子的个数
            int sum =0;
            //1.判断水平方向
            for(int q=1;q<16;q++) {
                if(map[X][q] == end) {
                    count++;
                }else {
                    count = 0;
                }
                if(count == 5) {
                    return 1;
                }
            }
            //2.判断垂直方向
            for(int w=1;w<16;w++) {
                if(map[w][Y] == end) {
                    count++;
                }else {
                    count = 0;
                }
                if(count == 5) {
                    return 1;
                }
            }
            //3.判断右斜方向/
            if(X+Y-1 < 16) {//边界坐标一定是(X+Y-1,1)和(1,X+Y-1)
                for(int e=1;e<(X+Y);e++) {
                    if(map[X+Y-e][e] == end) {
                        count++;
                    }else {
                        count = 0;
                    }
                    if(count == 5) {
                        return 1;
                    }
                }
            }else if(X+Y == 16) {//边界坐标一定是(15,1);(1,15)
                for(int r=1;r<16;r++) {
                    if(map[16-r][r] == end) {
                        count++;
                    }else {
                        count = 0;
                    }
                    if(count == 5) {
                        return 1;
                    }
                }
            }else {//X+Y>16;边界坐标一定是(15,X+Y-15);(X+Y-15,15)
                for(int t=1;t<(32-X-Y);t++) {
                    if(map[16-t][X+Y-16+t] == end) {
                        count++;
                    }else {
                        count = 0;
                    }
                    if(count == 5) {
                        return 1;
                    }
                }
            }
            //4.判断左斜方向
            if(X > Y) {//边界坐标一定是(X-Y+1,1)和(15+Y-X)
                for(int u=1;u<(15-X+Y+1);u++) {
                    if(map[X-Y+u][u] == end) {
                        sum++;
                    }else {
                        sum = 0;
                    }
                    if(sum == 5) {
                        return 1;
                    }
                }
            }else if(X == Y) {//边界坐标一定是(1,1);(15,15)
                for(int p=1;p<16;p++) {
                    if(map[p][p] == end) {
                        sum++;
                    }else {
                        sum = 0;
                    }
                    if(sum == 5) {
                        return 1;
                    }
                }
            }else {//Y>X;边界坐标一定是(1,Y+1-X);(15-Y+X,15)
                for(int n=1;n<(15-Y+X+1);n++) {
                    if(map[n][Y-X+n] == end) {
                        sum++;
                    }else {
                        sum = 0;
                    }
                    if(sum == 5) {
                        return 1;
                    }
                }
            }
            return 0;//无人获胜返回
        }

    }

