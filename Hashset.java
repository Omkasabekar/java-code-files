import java.util.*;

class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        // to set values.
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        // to print the size.
        System.out.println("the size of set is:" + set.size());

        // to print all elements.
        System.out.println(set);

        // to search value.
        if (set.contains(1)) {
            System.out.println("it contains 1");
        } else {
            System.out.println("not present");
        }
        if (!set.contains(7)) {
            System.out.println("not present");
        }

        // delete
        set.remove(1);
        if (!set.contains(1)) {
            System.out.println("deleted");
        }

        // iterator
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}