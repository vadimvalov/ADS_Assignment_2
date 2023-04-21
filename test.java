import java.util.Random;

public class test {
    public static void main(String[] args) {
        MyList<String> list1 = new MyArrayList<>();
        
        list1.add("10");
        list1.add("20");
        list1.add("30");

        System.out.println("Size of MyArrayList: " + list1.size());

        System.out.println("Contents of MyArrayList: " );
        for (int i = 0; i < list1.size(); i++) {
        System.out.print(list1.get(i) + " ");
     }
        System.out.println();

        list1.remove(1);

        System.out.print("Contents of MyArrayList after removing second element: ");
        for (int i = 0; i < list1.size(); i++) {
        System.out.print(list1.get(i) + " ");
        }
        System.out.println();


        
        MyList<Integer> list2 = new MyLinkedList<>();
        
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            list2.add(rand.nextInt(100));
        }
        
        System.out.println("Size of MyLinkedList: " + list2.size());
        System.out.println("Contents of MyLinkedList: ");
        for (int i = 0; i < list2.size(); i++) {
        System.out.print(list2.get(i) + " ");
        }
        System.out.println();
        
        list2.sort();
        
        System.out.println("Contents of MyLinkedList after sorting: ");
        for (int i = 0; i < list2.size(); i++) {
        System.out.print(list2.get(i) + " ");
        }
        System.out.println();
    }
}
