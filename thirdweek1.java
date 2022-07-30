import java.util.*;

class Solution1{
     public static int timeRequiredToBuy(int[] arr,int k){
         int sum=0;
         while(arr[k]!=0) {
             for (int i = 0; i < arr.length; i++) {
                 if (arr[i] != 0 && arr[k] != 0) {
                     arr[i]--;
                     sum++;
                 }
             }
         }
         return sum;
     }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        String[] str1=str.split(",");   //逗号为输入分隔符
        int[] arr =new int[str.length()];
        for(int i=0;i< str1.length;i++){
            arr[i] = Integer.parseInt(str1[i]);
        }
        int m= input.nextInt();
        System.out.println(timeRequiredToBuy(arr,m));
    }
}
