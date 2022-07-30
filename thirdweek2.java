import java.util.*;
class RecentCounter{
    RecentCounter(){}
    private Queue<Integer> q=new LinkedList<>();
    public int ping(int t){
        while (!this.q.isEmpty()&&t>this.q.peek()+3000){
            this.q.poll();      //用this声明使用此队列，否则每次重新创建，均输出1
         }
        this.q.offer(t);
        return this.q.size();
    }

    }
public class thirdweek2{
    public static void main(String[] args) {
        RecentCounter time=new RecentCounter();
        Scanner input=new Scanner(System.in);
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        String str1=input.nextLine();
        String[] s1=str1.split(",");    //逗号为输入分隔符
        for(int i=0;i<s1.length;i++){
            list1.add(s1[i]);
        }
        String str2=input.nextLine();
        String[] s2=str2.split(",");      //逗号为输入分隔符
        for(int i=0;i<s2.length;i++){
            list2.add(s2[i]);
        }
        int i=0;
        while(i<s1.length){
            if(list1.get(i).equals("RecentCounter")==true){
                System.out.print("[null");
            }
            if(list1.get(i).equals("ping")==true){
                System.out.print(","+time.ping(Integer.parseInt(list2.get(i))));
            }
            i++;
        }
        System.out.print("]");
    }
}
