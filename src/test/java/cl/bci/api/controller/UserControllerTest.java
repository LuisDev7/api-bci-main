package cl.bci.api.controller;

import cl.bci.api.model.PhoneModel;
import cl.bci.api.model.UserModel;
import cl.bci.api.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;



@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    MockMvc mock;

    ObjectMapper om = new ObjectMapper();

    @Test
    void whitout_token_when_postSecure_then_forbidden() throws Exception  {
        UserModel user= new UserModel();
        user.setName("Marco Arcos");
        user.setPassword("Klave123,");
        user.setEmail("juan@mail.com");

        ArrayList<PhoneModel> phones= new ArrayList<>();
        PhoneModel phone1 = new PhoneModel();
        phone1.setCitycode("Santiago");
        phone1.setContrycode("Chile");
        phone1.setNumber("9999");
        phones.add(phone1);

        PhoneModel phone2 = new PhoneModel();
        phone2.setCitycode("Calama");
        phone2.setContrycode("Chile");
        phone2.setNumber("8899");
        phones.add(phone2);

        user.setPhones(phones);
        String request = om.writeValueAsString(user);
        MvcResult result = mock.perform(post("/user/addUser")
                .content(request))
                .andExpect(MockMvcResultMatchers.status().isForbidden()).andReturn();

    }

    @Test
    void given_token_when_postSecure_then_created() throws Exception {
        JwtUtil jwt = new JwtUtil();
        String accessToken= jwt.getJWTToken("admin@nisum.ec");

        UserModel user= new UserModel();
        user.setName("Marco Arcos");
        user.setPassword("Klave2001,");
        user.setEmail("juan@mail.com");

        ArrayList<PhoneModel> phones= new ArrayList<>();
        PhoneModel phone1 = new PhoneModel();
        phone1.setCitycode("Santiago");
        phone1.setContrycode("Chile");
        phone1.setNumber("9999");
        phones.add(phone1);

        PhoneModel phone2 = new PhoneModel();
        phone2.setCitycode("Calama");
        phone2.setContrycode("Chile");
        phone2.setNumber("8899");
        phones.add(phone2);

        user.setPhones(phones);

        String request = om.writeValueAsString(user);
        mock.perform(post("/user/addUser")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json;charset=UTF-8")
                        .content(request).accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    void given_mail_user_generate_valid_token_when_postSecure_then_created() throws Exception {
        JwtUtil jwt = new JwtUtil();


        UserModel user= new UserModel();
        user.setName("Marco Arcos");
        user.setPassword("Klave2001,");
        user.setEmail("juan3@mail.com");

        String accessToken= jwt.getJWTToken(user.getEmail());

        ArrayList<PhoneModel> phones= new ArrayList<>();
        PhoneModel phone1 = new PhoneModel();
        phone1.setCitycode("Santiago");
        phone1.setContrycode("Chile");
        phone1.setNumber("9999");
        phones.add(phone1);

        PhoneModel phone2 = new PhoneModel();
        phone2.setCitycode("Calama");
        phone2.setContrycode("Chile");
        phone2.setNumber("8899");
        phones.add(phone2);

        user.setPhones(phones);

        String request = om.writeValueAsString(user);
        mock.perform(post("/user/addUser")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json;charset=UTF-8")
                        .content(request).accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    void given_email_when_invalid_format_then_unprocessable() throws Exception {
        JwtUtil jwt = new JwtUtil();
        String accessToken= jwt.getJWTToken("admin@nisum.ec");

        UserModel user= new UserModel();
        user.setName("Marco Arcos");
        user.setPassword("Klave123,");
        user.setEmail("juanmail.com");

        ArrayList<PhoneModel> phones= new ArrayList<>();
        PhoneModel phone1 = new PhoneModel();
        phone1.setCitycode("Santiago");
        phone1.setContrycode("Chile");
        phone1.setNumber("9999");
        phones.add(phone1);

        PhoneModel phone2 = new PhoneModel();
        phone2.setCitycode("Calama");
        phone2.setContrycode("Chile");
        phone2.setNumber("8899");
        phones.add(phone2);

        user.setPhones(phones);

        String request = om.writeValueAsString(user);
        mock.perform(post("/user/addUser")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json;charset=UTF-8")
                        .content(request).accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());

    }

    @Test
    void given_password_when_invalid_secuence_then_unprocessable() throws Exception {
        JwtUtil jwt = new JwtUtil();
        String accessToken= jwt.getJWTToken("admin@nisum.ec");

        UserModel user= new UserModel();
        user.setName("Marco Arcos");
        user.setPassword("Klave123,");
        user.setEmail("juan@mail.com");

        ArrayList<PhoneModel> phones= new ArrayList<>();
        PhoneModel phone1 = new PhoneModel();
        phone1.setCitycode("Santiago");
        phone1.setContrycode("Chile");
        phone1.setNumber("9999");
        phones.add(phone1);

        PhoneModel phone2 = new PhoneModel();
        phone2.setCitycode("Calama");
        phone2.setContrycode("Chile");
        phone2.setNumber("8899");
        phones.add(phone2);

        user.setPhones(phones);

        String request = om.writeValueAsString(user);
        mock.perform(post("/user/addUser")
                .header("Authorization", "Bearer " + accessToken)
                .contentType("application/json;charset=UTF-8")
                .content(request).accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());

    }

    @Test
    void given_password_when_invalid_length_then_unprocessable() throws Exception {
        JwtUtil jwt = new JwtUtil();
        String accessToken= jwt.getJWTToken("admin@nisum.ec");

        UserModel user= new UserModel();
        user.setName("Marco Arcos");
        user.setPassword("Ka,");
        user.setEmail("juan@mail.com");

        ArrayList<PhoneModel> phones= new ArrayList<>();
        PhoneModel phone1 = new PhoneModel();
        phone1.setCitycode("Santiago");
        phone1.setContrycode("Chile");
        phone1.setNumber("9999");
        phones.add(phone1);

        PhoneModel phone2 = new PhoneModel();
        phone2.setCitycode("Calama");
        phone2.setContrycode("Chile");
        phone2.setNumber("8899");
        phones.add(phone2);

        user.setPhones(phones);

        String request = om.writeValueAsString(user);
        mock.perform(post("/user/addUser")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json;charset=UTF-8")
                        .content(request).accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());

    }

    @Test
    void given_password_without_special_character_then_unprocessable() throws Exception {
        JwtUtil jwt = new JwtUtil();
        String accessToken= jwt.getJWTToken("admin@nisum.ec");

        UserModel user= new UserModel();
        user.setName("Marco Arcos");
        user.setPassword("Karlamarin");
        user.setEmail("juan@mail.com");

        ArrayList<PhoneModel> phones= new ArrayList<>();
        PhoneModel phone1 = new PhoneModel();
        phone1.setCitycode("Santiago");
        phone1.setContrycode("Chile");
        phone1.setNumber("9999");
        phones.add(phone1);

        PhoneModel phone2 = new PhoneModel();
        phone2.setCitycode("Calama");
        phone2.setContrycode("Chile");
        phone2.setNumber("8899");
        phones.add(phone2);

        user.setPhones(phones);

        String request = om.writeValueAsString(user);
        mock.perform(post("/user/addUser")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json;charset=UTF-8")
                        .content(request).accept("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());

    }

}