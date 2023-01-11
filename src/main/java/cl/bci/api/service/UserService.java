package cl.bci.api.service;


import cl.bci.api.entity.User;
import cl.bci.api.exception.EmailException;
import cl.bci.api.model.PhoneModel;
import cl.bci.api.model.UserModel;
import cl.bci.api.repository.UserRepository;
import cl.bci.api.response.UserResponse;
import cl.bci.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    private UserRepository userRepository;
    private PhoneService phoneService;


    @Autowired
    public UserService(UserRepository userRepository, PhoneService phoneService) {
        this.userRepository = userRepository;
        this.phoneService = phoneService;

    }

    public ResponseEntity save(UserModel userModel) {

        UserResponse userResponse = new UserResponse();
        this.findEmail(userModel.getEmail());
        User user = this.saveAndFlush(this.createObject(userModel));
        ArrayList<PhoneModel> phones = this.phoneService.save(userModel.getPhones(), user.getIdUser());
        userResponse = createModel(user, phones);

        return new ResponseEntity(userResponse, HttpStatus.CREATED);


    }

    public ResponseEntity findAllUsers() {
        List<User> users = findAll();
        List<UserResponse> usersResponse = new ArrayList<>();
        if (users != null) {
            for (User u : users) {
                UserResponse userResponse = new UserResponse();
                ArrayList<PhoneModel> phones = this.phoneService.findByIdUser(u.getIdUser());
                userResponse = createModel(u, phones);
                usersResponse.add(userResponse);

            }
        }
        return new ResponseEntity<>(usersResponse, HttpStatus.OK);
    }

    public User createObject(UserModel userModel) {
        LocalDate date = LocalDate.now();
        User user = new User();
        JwtUtil jwt = new JwtUtil();
        if (userModel.getIdUser() != null && !userModel.getIdUser().equals("")) {
            user.setIdUser(Integer.valueOf(userModel.getIdUser().toString()));
            user.setModified(date);
        } else {
            user.setCreated(date);
            user.setToken(jwt.getJWTToken(userModel.getEmail().toString()));
        }

        if (userModel.getName() != null && !userModel.getName().equals("")) {
            user.setName(userModel.getName().toString());
        }

        if (userModel.getEmail() != null && !userModel.getEmail().equals("")) {
            user.setEmail(userModel.getEmail().toString());
        }

        if (userModel.getPassword() != null && !userModel.getPassword().equals("")) {
            user.setPassword(DigestUtils.md5DigestAsHex(userModel.getPassword().getBytes()));
        }

        user.setLast_login(date);
        user.setIsactive("ACTIVE");
        return user;
    }


    public UserResponse createModel(User user, ArrayList<PhoneModel> phones) {
        UserResponse userResponse = new UserResponse();
        if (user.getIdUser() != null) {
            userResponse.setId(user.getIdUser().toString());
        }

        if (user.getName() != null && !user.getName().equals("")) {
            userResponse.setName(user.getName().toString());
        }

        if (user.getEmail() != null && !user.getEmail().equals("")) {
            userResponse.setEmail(user.getEmail().toString());
        }

        if (user.getCreated() != null && !user.getCreated().equals("")) {
            userResponse.setCreated(user.getCreated().toString());
        }

        if (user.getLast_login() != null && !user.getLast_login().equals("")) {
            userResponse.setLast_login(user.getLast_login().toString());
        }

        if (user.getToken() != null && !user.getToken().equals("")) {
            userResponse.setToken(user.getToken().toString());
        }

        if (user.getIsactive() != null && !user.getIsactive().equals("")) {
            userResponse.setIsactive(user.getIsactive().toString());
        }

        if (!phones.isEmpty()) {
            userResponse.setPhones(phones);
        }
        return userResponse;
    }

    public <S extends User> S saveAndFlush(S entity) {
        return this.userRepository.saveAndFlush(entity);
    }


    public void findEmail(String email) {
        User emailResponse = this.userRepository.findByEmail(email);
        if (emailResponse != null) {
            throw new EmailException(HttpStatus.UNPROCESSABLE_ENTITY, "El correo ya registrado.");
        }
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

}
