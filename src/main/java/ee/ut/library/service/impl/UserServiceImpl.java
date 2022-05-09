package ee.ut.library.service.impl;

import ee.ut.library.domain.entity.User;
import ee.ut.library.exception.UserNotFoundException;
import ee.ut.library.repository.UserRepository;
import ee.ut.library.security.SecurityUtils;
import ee.ut.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(Long id) {
        if (id == null) {
            throw new UserNotFoundException(id);
        }
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User insert(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    @Transactional(readOnly = true)
    public User getUserWithAuthorities() {
        return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername)
                .orElseThrow(UserNotFoundException::new);
    }
}
