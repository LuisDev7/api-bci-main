package cl.bci.api.model;


import cl.bci.api.validations.ValidEmail;
import cl.bci.api.validations.ValidPassword;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;

public class UserModel implements Serializable {
    private static final long serialVersionUID = 5212972050464679331L;
    private String idUser;
    private String name;

    @ValidEmail
    private String email;

    @NotBlank(message = "La contraseña no puede ser vacío")
    @ValidPassword
    private String password;
    private ArrayList<PhoneModel> phones;

    public UserModel() {
    }

    public String getIdUser() {
        return this.idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<PhoneModel> getPhones() {
        return this.phones;
    }

    public void setPhones(ArrayList<PhoneModel> phones) {
        this.phones = phones;
    }
}
