package com.practicheskaya.madethat.Service;

import com.practicheskaya.madethat.Repository.UserRepository;
import com.practicheskaya.madethat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Сохранение
    public User save(User user) {
        return userRepository.save(user);
    }

    // Удаление
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    // Поиск по ID
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    // Получить всех пользователей
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}