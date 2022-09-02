
import java.util.Scanner;
public class my {
    static void shuzu()
    {
        String s="i and you and she with love";
        String[] str;
        str=s.split(" ");
        System.out.println(str[0]);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        System.out.println(a);
        System.out.println("sortTest");
        int[] arr={6,3,8,2,9,1};
        for(int m=0;m<arr.length;m++) {
            System.out.print(arr[m]+" ");
            if(m==arr.length-1)
                System.out.println("");
        }
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                int temp = 0;
                if (arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int m=0;m<arr.length;m++) {
            System.out.print(arr[m]+" ");
        }
        var b=new int[4];
        System.out.println(b[1]);
        shuzu();
    }
}