import java.util.*;
public class secondweek3 {
    public static void main(String[] args) {
        int[][] pos={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};   //马坐标的几种变化
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int x=input.nextInt();
        int y=input.nextInt();
        int[][] step=new int[n][m];   //对点最少次数统计的数组
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                step[i][j]=-1;
            }
        }
        int[][] flag=new int[n][m];   //对是否能够到达的标记
        bfs(pos,flag,step,x,y,n,m);
        pointPrint(step,n,m);
    }
    public static void bfs(int[][] arr,int[][] flag,int[][] step,int x,int y,int n,int m)
    {
        //用队列、bfs算法求解
        Queue<Integer> xpos=new LinkedList<Integer>();
        Queue<Integer> ypos=new LinkedList<Integer>();
        xpos.offer(x);
        ypos.offer(y);
        flag[x-1][y-1]=1;
        step[x-1][y-1]=0;
        while(!xpos.isEmpty()&&!ypos.isEmpty()){     //队列非空时插入新的元素(八个方向的坐标值)进入队列
            int xline=xpos.poll();   //每次弹出的坐标为下一次开始搜索的起点
            int yline=ypos.poll();
            for(int i=0;i<8;i++){
                int xline1=xline+arr[i][0];
                int yline1=yline+arr[i][1];
                if(xline1>=1&&xline1<=n&&yline1>=1&&yline1<=m){
                    if(flag[xline1-1][yline1-1]==0) {
                        flag[xline1-1][yline1-1] = 1;
                        step[xline1-1][yline1-1] = step[xline-1][yline-1] + 1;    //原理：距离近的先走，并将flag置于1，使后面慢的不再走此步，类推为最短距离
                        xpos.offer(xline1);
                        ypos.offer(yline1);
                    }
                }
            }
        }
    }
    public static void pointPrint(int[][] arr,int n,int m)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.printf("%-5d",arr[i][j]);
            }
            System.out.println();
        }
    }
}
