package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> showAll() {
        return userRepository.findAll();
    }

    @Override
    public User showUser(long id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void update(long id, User updatedUser) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }





//    private final UserDao userDao;
//
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        System.out.println("!!!");
//        this.userDao = userDao;
//    }
//
////    @Transactional(readOnly = true)
//    @Override
//    public List<User> showAll() {
//        System.out.println(userDao.showAll());
//        return userDao.showAll();
//    }
//
//    @Transactional
//    @Override
//    public void save(User user) {
//        userDao.save(user);
//    }
//
////    @Transactional(readOnly = true)
//    @Override
//    public User showUser(long id) {
//        return userDao.showUser(id);
//    }
//    @Transactional
//    @Override
//    public void update(long id, User updatedUser) {
//        userDao.update(id, updatedUser);
//    }
//
//
//    @Transactional
//    @Override
//    public void delete(long id) {userDao.delete(id);}


}
