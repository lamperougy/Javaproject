import java.util.*;
class AnimalShelf{
        Queue<int []> dog,cat;
    public AnimalShelf() {
        cat=new LinkedList<>();
        dog=new LinkedList<>();
    }
    public void enqueue(int[] animal){
          if(animal[1]==0){
              this.cat.add(animal);
          }else if(animal[1]==1){
              this.dog.add(animal);
          }
    }
    //返回值为[编号，类别]的数组
    public int[] dequeueAny() {
        if(this.dog.isEmpty()&&this.cat.isEmpty()) {
            return new int[] {-1,-1};
        }else if (this.dog.isEmpty()==true&&this.cat.isEmpty()==false) {
            return cat.poll();
        }else if (this.cat.isEmpty()==true&&this.dog.isEmpty()==false) {
            return dog.poll();
        }else {
            int[] arr1=dog.poll();
            int[] arr2=cat.poll();
            System.out.println(arr1[0]+arr1[1]+"\t"+arr2[0]+arr2[1]);
            if(arr1[0]<arr2[0]){
                return arr1;
            }else{
                return arr2;
            }
        }
    }
      //将队列中队顶数组元素返回
    public int[] dequeueDog() {
            if(this.dog.isEmpty()==false){
                return this.dog.poll();
            }
            return new int[]{-1,-1};
    }

    public int[] dequeueCat(){
        if(this.cat.isEmpty()==false){
            return this.cat.poll();
        }
        return new int[]{-1,-1};
    }
}
public class thirdweek3{
    public static void main(String[] args){
        AnimalShelf shelf=new AnimalShelf();
        Scanner input=new Scanner(System.in);
        String str1=input.nextLine();
        String[] s1=str1.split(",");      //逗号为输入分隔符
        List<String> list1=new ArrayList<>();
        for(int i=0;i<s1.length;i++){
            list1.add(s1[i]);
        }
        int i=0;
        while(i<s1.length){
            if(list1.get(i).equals("AnimalShelf")==true){
                System.out.println("null");
            }
            if(list1.get(i).equals("enqueue")==true){
                String str2=input.nextLine();
                String[] s2=str2.split(",");     //逗号为输入分隔符（两个数字）
                int[] arr=new int[]{Integer.parseInt(s2[0]),Integer.parseInt(s2[1])};
                shelf.enqueue(arr);
                System.out.println("null");
            }
            if(list1.get(i).equals("dequeueAny")==true){
                int[] a= shelf.dequeueAny();              //函数调用一次，不然会多弹出队列元素
                System.out.println(a[0]+","+a[1]+"\t");
            }
            if(list1.get(i).equals("dequeueDog")==true){
                int[] b= shelf.dequeueDog();
                System.out.println(b[0]+","+b[1]+"\t");
            }
            if(list1.get(i).equals("dequeueCat")==true){
                int[] c= shelf.dequeueCat();
                System.out.println(c[0]+","+c[1]+"\t");
            }
            i++;
        }

    }
}
