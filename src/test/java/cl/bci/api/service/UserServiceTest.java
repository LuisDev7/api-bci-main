package cl.bci.api.service;

import cl.bci.api.entity.User;
import cl.bci.api.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        user= new User();
        user.setName("Marco");
        user.setEmail("marco@mail.com");
        user.setPassword("Marck22,");

    }


    @Test
    void saveAndFlush() {
        when(userRepository.saveAndFlush(any(User.class))).thenReturn(user);
        assertNotNull(userRepository.saveAndFlush(new User()));
    }


    @Test
    void find_email_is_null() {
        when(userRepository.findByEmail("marco@mail.com")).thenReturn(user);
        assertNull(userRepository.findByEmail("marco@email.com"));
    }

    @Test
    void find_email_is_not_null() {
        when(userRepository.findByEmail("marco@mail.com")).thenReturn(user);
        assertNotNull(userRepository.findByEmail("marco@mail.com"));
    }
}