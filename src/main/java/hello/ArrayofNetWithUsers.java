package hello;

import java.util.HashMap;

public class ArrayofNetWithUsers {
    HashMap<Long, User> hashMap = new HashMap<>();

    public ArrayofNetWithUsers() {
        hashMap.put((long) 123, new User("1", (long) 2, "3"));
    }
}
