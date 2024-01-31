import java.util.*;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        // insert element
        map.put("India", 120);
        map.put("USA", 50);
        map.put("china", 150);
        System.out.println(map);
        map.put("china", 180);
        System.out.println(map);

        // search
        if (map.containsKey("china")) {
            System.out.println("key is present in the map");
        } else {
            System.out.println("key is not present");
        }

        System.out.println(map.get("India"));
        System.out.println(map.get("china"));

        // iterator
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        System.out.println();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }
        map.remove("china");
        System.out.println(map);
    }
}
