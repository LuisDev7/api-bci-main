package cl.bci.api.response;


import cl.bci.api.model.PhoneModel;

import java.io.Serializable;
import java.util.ArrayList;

public class UserResponse implements Serializable {
    private static final long serialVersionUID = -1322029309116586072L;
    private String id;
    private String name;
    private String email;
    private String created;
    private String modified;
    private String last_login;
    private String token;
    private String isactive;
    private ArrayList<PhoneModel> phones;

    public UserResponse() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return this.modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getLast_login() {
        return this.last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIsactive() {
        return this.isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public ArrayList<PhoneModel> getPhones() {
        return this.phones;
    }

    public void setPhones(ArrayList<PhoneModel> phones) {
        this.phones = phones;
    }
}

