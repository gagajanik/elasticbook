package com.example.elastic.resource;

import com.example.elastic.model.Users;
import com.example.elastic.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/name/{text}")
    public List<Users> searchName(@PathVariable final String text) {
        return usersRepository.findByName(text);
    }


    @GetMapping(value = "/salary/{salary}")
    public List<Users> searchSalary(@PathVariable final Long salary) {
        return usersRepository.findBySalary(salary);
    }


    @GetMapping(value = "/all")
    public List<Users> searchAll() {
        List<Users> usersList = new ArrayList<>();
        Iterable<Users> userses = usersRepository.findAll();
        userses.forEach(usersList::add);
        return usersList;
    }
    @GetMapping(value = "insert")
    public Users insert(){
        Users users =new Users();
        users.setId(2L);
        users.setName("gaga");
        users.setSalary(1200L);
       return usersRepository.save(users);
    }
    @GetMapping(value = "delete")
    public void delete(Long id) {
        usersRepository.delete(id);
    }
}
