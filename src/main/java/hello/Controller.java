package hello;

import Model.User;
import Repository.UserRepository;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    UserRepository userRepository=new UserRepository();
    @GetMapping("Users")
    public HashMap<Long, User> getAll() {
        HashMap<Long,User> hashMap=new HashMap<>();
        for(User user:userRepository.getUsers())
            hashMap.put(user.getId(),user);
        return hashMap;
    }
    @PostMapping("Users/{NetName}")
    public User postUserInfo(@PathVariable("NetName") Long NetName, @RequestBody User user){
        System.out.println(NetName+""+user);
        User user1=user;
        userRepository.createUser(user1);
        System.out.println(user1.getFirst_name());
        System.out.println(userRepository.getUser(Integer.parseInt(NetName.toString())));
        return user1;
    }
    @PutMapping("Users/{NetName}")
    public User updateUserInfo(@PathVariable("NetName") Long NetName, @RequestBody User user){
        userRepository.updateUser(user);
        return user;
    }
    @DeleteMapping("Users/{NetName}")
    public User deleteUserInfo(@PathVariable("NetName") Long NetName){
        userRepository.deleteUser(Integer.parseInt(NetName.toString()));
        return userRepository.getUser(Integer.parseInt(NetName.toString()));
    }



}