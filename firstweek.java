import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.out;
class Lost
{
    public String thing;
    public String time;
    public String place;

    public Lost(String thing, String time, String place) {
        this.thing=thing;
        this.time=time;
        this.place=place;
    }
}
class card extends Lost
{
    public String id;
    public card(String thing,String time,String place,String id)
    {
        super(thing,time,place);
        this.id=id;
    }
}
class book extends Lost
{
    public String type;
    public book(String thing,String time,String place,String id)
    {
        super(thing,time,place);
        this.type=type;
    }
}
class Solution {
    public static int testDateCompare(String s, String s1)  {
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    //按标准时间输入
            Date date1 = sf.parse(s);
            Date date2 = sf.parse(s1);
            return date1.compareTo(date2);
        }catch (Exception exception)
        {
            return 0;
        }
    }
    public static void sortLost(Lost[] lostarray) {
        Lost temp=new Lost("a","b","c");   //初始化
        for(int i=0;i<lostarray.length;i++)
        {
            for(int j=i+1;j<lostarray.length;j++)
            {
                if(testDateCompare(lostarray[i].time,lostarray[j].time)==1)
                {
                    temp=lostarray[i];
                    lostarray[i]=lostarray[j];
                    lostarray[j]=temp;
                }
            }
        }
        for(int i=0;i<lostarray.length;i++)
        {
            System.out.println(lostarray[i].thing+" "+lostarray[i].time+" "+lostarray[i].place);
        }
    }
    public static void selectByKeyword(Lost[] lostarray, String keyword) {
        Scanner input = new Scanner(System.in);
        int count=0;
        System.out.println("根据输入关键字，查找结果如下：");
        for(int i=0;i<lostarray.length;i++)
        {
            if(lostarray[i].place.contains(keyword)==true)
            {
                System.out.println(lostarray[i].thing+" "+lostarray[i].time+" "+lostarray[i].place);
                count++;
            }
        }
        if (count == 0) {
            out.println("未查找到相关信息，请重新输入！");
            String key=input.nextLine();
            selectByKeyword(lostarray,key);
        }
    }
    public static void solution(Lost[] list,int t)
    {
        Scanner input = new Scanner(System.in);
        if(t==1) {
            out.println("按时间排序后打印:");
            sortLost(list);
            out.println("请选择功能：1.按时间排序\t2.关键字查找\t3.退出系统");
            int m = input.nextInt();
            solution(list,m);
        }else if(t==2) {
            out.println("按关键字查找失物,请输入关键字");
            String x = input.nextLine();
            selectByKeyword(list, x);
            out.println("请选择功能：1.按时间排序\t2.关键字查找\t3.退出系统");
            int n= input.nextInt();
            solution(list,n);
        }else if(t==3)
        {
            System.out.println("退出成功！");
        }else{
            out.println("其他功能未完善，敬请期待！");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner string=new Scanner(System.in);   //方法重构，消除换行符影响
        out.println("请选择输入失物的数量");
        int num = input.nextInt();
        Lost[] list = new Lost[num];
        card[] a=new card[num];
        book[] b=new book[num];
        int m=0,n=0;
        for (int i = 0; i < num; i++) {
            out.println("请输入失物类别（1.卡类\t2.书籍类");
            int x=input.nextInt();
            if(x==1)
            {
                out.println("请输入失物信息（失物、标准时间、地点、id,用逗号分隔）");
                String s1=string.nextLine();
                String[] str1=s1.split(",");
                list[i] =new Lost(str1[0],str1[1],str1[2]);
                a[m++]=new card(str1[0],str1[1],str1[2],str1[3]);
            }else if(x==2)
            {
                out.println("请输入失物信息（失物、标准时间、地点、类别,用逗号分隔）");
                String s2=string.nextLine();
                String[] str2=s2.split(",");
                list[i] =new Lost(str2[0],str2[1],str2[2]);
                b[n++]=new book(str2[0],str2[1],str2[2],str2[3]);
            }
        }
        out.println("打印失物信息（排序前）:");
        for (int i=0;i<num;i++) {
            System.out.println(list[i].thing+" "+list[i].time+" "+list[i].place);
        }
        out.println("请选择功能：1.按时间排序\t2.关键字查找\t3.退出系统");
        int t= input.nextInt();
        solution(list,t);
    }
}
