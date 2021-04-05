package com.bezkoder.springjwt.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.UserRequest;
import com.bezkoder.springjwt.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<User> user(@PathVariable String id) {  //post ---> user
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
    }

	@GetMapping
    public List<User> list(@RequestParam(required = false) String username) {
        if (StringUtils.isEmpty(username)) {
            return userService.getAll();
        }
        return userService.findByUsername(username);
    }

    @PostMapping
    public void save(@RequestBody UserRequest request) {
        userService.save(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody UserRequest request) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            userService.update(id, request);
        } else {
            userService.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }
}
