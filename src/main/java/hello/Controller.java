package hello;

import Model.User;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    ArrayofNetWithUsers arrayofNetWithUsers=new ArrayofNetWithUsers();
    @GetMapping("/Users")
    public HashMap<Long, User> getAll() {
        return arrayofNetWithUsers.hashMap;
    }
    @PostMapping("/Users/{NetName}")
    public User postUserInfo(@PathVariable("NetName") Long NetName, @RequestBody User user){
        System.out.println(NetName+""+user);
        User user1=user;
        System.out.println(user1.getFirst_name());
        arrayofNetWithUsers.hashMap.put(NetName,user1);
        System.out.println(arrayofNetWithUsers.hashMap.get(NetName));
        return user1;
    }
    @PutMapping("/Users/{NetName}")
    public User updateUserInfo(@PathVariable("NetName") Long NetName, @RequestBody User user){
        User user1 = arrayofNetWithUsers.hashMap.replace(NetName,user);
        return user1;
    }
    @DeleteMapping("/Users/{NetName}")
    public User deleteUserInfo(@PathVariable("NetName") Long NetName){
        User user1 = arrayofNetWithUsers.hashMap.remove(NetName);
        return user1;
    }



}