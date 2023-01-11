package cl.bci.api.model;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class PhoneModel implements Serializable {
    private static final long serialVersionUID = -9157776447942658052L;
    private String idPhone;
    @NotBlank(message = "El número es inválido")
    private String number;
    @NotBlank(message = "El código de ciudad es inválido")
    private String citycode;
    @NotBlank(message = "El código de país es inválido")
    private String contrycode;
    private String idUser;

    public PhoneModel() {
    }

    public String getIdPhone() {
        return this.idPhone;
    }

    public void setIdPhone(String idPhone) {
        this.idPhone = idPhone;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return this.citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getContrycode() {
        return this.contrycode;
    }

    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }

    public String getIdUser() {
        return this.idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}

