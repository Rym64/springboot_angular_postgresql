package com.bezkoder.springjwt.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.UserRequest;
import com.bezkoder.springjwt.repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public String save(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        user.setDatebirth(request.getDatebirth());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return userRepository.save(user)
                             .getId();
    }

    public void update(String id, UserRequest request) {
        Optional<User> user = findById(id);
        if (user.isPresent()) {
            User forUpdate = user.get();
            forUpdate.setUsername(request.getUsername());
            forUpdate.setAddress(request.getAddress());
            forUpdate.setPhone(request.getPhone());
            forUpdate.setDatebirth(request.getDatebirth());
            forUpdate.setEmail(request.getEmail());
            forUpdate.setPassword(request.getPassword());
            userRepository.save(forUpdate);
        }
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> findByUsername(String username) {
        return userRepository.findByUsernameContaining(username);
    }

    public void delete(String id) {
        Optional<User> user = findById(id);
        user.ifPresent(userRepository::delete);
    }
}
