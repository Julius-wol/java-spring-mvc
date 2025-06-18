package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return (List<User>) this.userRepository.findAll();
    }

    public List<User> getAllUserByEmail(String email) {
        List<User> arrUser = this.userRepository.findByEmail(email);
        return arrUser;
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public User handleSaveUser(User webUser) {
        User eric = this.userRepository.save(webUser);
        return eric;
    }

    public void deleteById(long id) {
        this.userRepository.deleteById(id);
    }
}
