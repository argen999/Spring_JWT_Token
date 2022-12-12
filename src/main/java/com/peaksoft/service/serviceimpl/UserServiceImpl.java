package com.peaksoft.service.serviceimpl;

import com.peaksoft.entity.User;
import com.peaksoft.repository.UserRepository;
import com.peaksoft.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException(
                    String.format("User via id = %d not found!", id)
            );
        }
        userRepository.deleteById(id);
    }
}
