import java.util.Scanner;

public class secondweek2<T> {
    private static int size;
    private Node<T> first;
    private Node<T> last;
    private Object e;

    private static class Node<T> {
        private T data;
        private Node<T> pri;
        private Node<T> next;
        public Node(T data) {
            this.data = data;
        }
        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
        public Node<T> getPri() {
            return pri;
        }
        public void setPri(Node<T> pri) {
            this.pri = pri;
        }
        public Node<T> getNext() {
            return next;
        }
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    public static int getSize() {
        return size;
    }
    //添加节点到头部
    public boolean addFirst(T value){
        Node<T> node = new Node<>(value);
        if (size == 0) {
            first = node;
            last = first;
        }else {
            node.next = first;
            first.pri = node;
            first = node;
        }
        size++;
        return true;
    }
    //添加节点到尾部
    public boolean addLast(T value){
        if (size == 0){
            return addFirst(value);
        }else {
            Node<T> node = new Node<>(value);
            last.next = node;
            node.pri = last;
            last = node;
        }
        size++;
        return true;
    }
    //添加元素到指定位置
    public boolean add(int index,T value){
        try {
            if(index<0||index>size){
                int[] a=new int[3];
                a[-1]=1;
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("数据下标越界 Index:" + index + "\tsize:" + size);
            System.exit(1);
        }
        if(index == 0){
            return addFirst(value);
        }else if (index == size){
            return addLast(value);
        }else {
            Node<T> node = new Node<>(value);
            Node<T> head = first;
            for (int i = 0; i < index-1; i++) {
                head = head.getNext();
            }
            node.next = head.next;
            head.next = node;
            node.pri = head;
            node.next.pri = node;
        }
        size++;
        return true;
    }
    //删除头节点
    public T removeFirst(){
        if (size == 0){
            throw new RuntimeException("链表为空！");
        }
        T data = first.getData();
        Node<T> node = first.next;
        node.setPri(null);
        first = node;
        return data;
    }
    //删除尾节点
    public T removeLast(){
        if (size == 0){
            throw new RuntimeException("链表为空！");
        }
        T data = last.getData();
        Node<T> node = last.pri;
        node.setNext(null);
        last = node;
        return data;
    }
    //删除指定下标节点
    public T remove(int index){
            if(size == 0){
              throw new RuntimeException("链表为空！！！");
            }
        try {
            if(index<0||index>size){
                int[] a=new int[3];
                a[-1]=1;
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("数据下标越界 Index:" + index + "\tsize:" + size);
            System.exit(1);
        }
        if(index == 0){
            return removeFirst();
        }else {
            Node<T> node = first;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            Node<T> temp = node.next;
            if (temp != last){
                T data = temp.getData();
                node.next = temp.next;
                temp.next.pri = node;
                temp.setNext(null);
                return data;
            }else {
                return removeLast();
            }
        }
    }
    //获取输入下标对应的数据
    public T getIndex(int index) {
        try {
            if(index<0||index>size){
                int[] a=new int[3];
                a[-1]=1;
            }
            }catch(IndexOutOfBoundsException e){
                System.out.println("数据下标越界 Index:" + index + "\tsize:" + size);
                System.exit(1);
            }
            if (size == 0) {
                throw new RuntimeException("链表为空");
            } else if (size == 1) {
                return first.data;
            } else {
                Node<T> node = first;
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
                return node.data;
            }
        }
    //清空链表
    public void clear(){
        first.next = null;
        last = first;
    }
    //链表遍历输出
    public void print(){
        if (size == 0) {
            System.out.println("该链表为空!");
        }
        Node<T> node = first;
        while (node != null) {
            System.out.print(node.getData() + "\t");
            node = node.next;
        }
        System.out.println();
    }
    //反向链表输出
    public void printBackward(){
        System.out.print("链表反向输出：\n");
        Node current = last;
        while(current!=null) {
            System.out.println(current.data);
            current = current.pri;
        }
        System.out.println();
    }
    public static void main(String[] args){
        secondweek2 node = new secondweek2();
        Scanner input=new Scanner(System.in);
        int m,length=0;
        int index=0;
        System.out.println("请输入添加的节点信息：");
        String str = input.nextLine();
        node.add(index,str);
        index++;
        length++;
        while(true) {
            System.out.println("是否继续添加节点？(yes/no)");
            String ch=input.nextLine();
            if (ch.equals("no")==true||ch.equals("NO")==true){
                break;
            }
            System.out.println("请输入添加的节点信息：");
            String str1 = input.nextLine();
            node.add(index,str1);
            index++;
            length++;
            }
        node.print();
        node.printBackward();
        System.out.println("请选择以下功能：1.删除节点\t2.插入节点\t3.查找节点");
        m= input.nextInt();
        if(m==1){
            while(true) {
                System.out.println("请输入删除的节点下标：");
                int n = input.nextInt();
                node.remove(n);
                node.print();
                node.printBackward();
                System.out.println("是否继续删除节点？(yes/no)");
                String c=input.nextLine();   //消除回车符影响
                String ch1=input.nextLine();
                if(ch1.equals("no")==true||ch1.equals("NO")==true){
                    break;
                }
            }
        }else if(m==2){
            while(true) {
                System.out.println("请输入插入的节点下标及数据：");
                int in= input.nextInt();
                String str2 = input.nextLine();
                node.add(in, str2);
                System.out.println("是否继续插入节点？(yes/no)");
                String ch2=input.nextLine();
                if(ch2.equals("no")==true||ch2.equals("NO")==true){
                    break;
                }
            }
            node.print();
            node.printBackward();
        }else if(m==3){
            while(true) {
                System.out.println("请输入要查找的节点的下标：");
                int ind = input.nextInt();
                System.out.println(node.getIndex(ind));
                System.out.println("是否继续查找节点？(yes/no)");
                String c= input.nextLine();   //消除吸收字符影响
                String ch3=input.nextLine();
                if(ch3.equals("no")==true||ch3.equals("NO")==true){
                    break;
                }
            }
        }
        node.clear();
    }
}