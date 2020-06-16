public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(12);
        list.add(42);
        list.add(245);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        list.add(1234);
        System.out.println(list.toString());
    }
}
