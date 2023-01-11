package cl.bci.api.service;

import cl.bci.api.entity.Phone;
import cl.bci.api.model.PhoneModel;
import cl.bci.api.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class PhoneService {
    private PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public ArrayList<PhoneModel> save(List<PhoneModel> phonesModel, Integer idUser) {
        ArrayList<PhoneModel> phones = new ArrayList();
        Iterator var5 = phonesModel.iterator();

        while (var5.hasNext()) {
            PhoneModel phone = (PhoneModel) var5.next();
            new PhoneModel();
            phone.setIdUser(idUser.toString());
            PhoneModel phoneModel = this.createModel((Phone) this.phoneRepository.save(this.createObject(phone)));
            phones.add(phoneModel);
        }

        return phones;
    }

    public ArrayList<PhoneModel> findByIdUser(Integer idUsuario) {
        ArrayList<PhoneModel> phonesModel = new ArrayList();
        List<Phone> phones = this.phoneRepository.findByIdUser(idUsuario);
        for (Phone p : phones) {
            new PhoneModel();
            PhoneModel phoneModel = createModel(p);
            phonesModel.add(phoneModel);
        }


        return phonesModel;
    }

    public PhoneModel createModel(Phone phone) {
        PhoneModel phoneModel = new PhoneModel();
        if (phone.getIdPhone() != null) {
            phoneModel.setIdPhone(phone.getIdPhone().toString());
        }

        if (phone.getNumber() != null && !phone.getNumber().equals("")) {
            phoneModel.setNumber(phone.getNumber().toString());
        }

        if (phone.getCitycode() != null && !phone.getCitycode().equals("")) {
            phoneModel.setCitycode(phone.getCitycode());
        }

        if (phone.getContrycode() != null && !phone.getContrycode().equals("")) {
            phoneModel.setContrycode(phone.getContrycode());
        }

        if (phone.getIdUser() != null) {
            phoneModel.setIdUser(phone.getIdUser().toString());
        }

        return phoneModel;
    }

    public Phone createObject(PhoneModel phoneModel) {
        Phone phone = new Phone();
        if (phoneModel.getIdPhone() != null && !phoneModel.getIdPhone().equals("")) {
            phone.setIdPhone(Integer.valueOf(phoneModel.getIdPhone()));
        }

        if (phoneModel.getNumber() != null && !phoneModel.getNumber().equals("")) {
            phone.setNumber(phoneModel.getNumber().toString());
        }

        if (phoneModel.getCitycode() != null && !phoneModel.getCitycode().equals("")) {
            phone.setCitycode(phoneModel.getCitycode());
        }

        if (phoneModel.getContrycode() != null && !phoneModel.getContrycode().equals("")) {
            phone.setContrycode(phoneModel.getContrycode());
        }

        if (phoneModel.getIdUser() != null && !phoneModel.getIdUser().equals("")) {
            phone.setIdUser(Integer.valueOf(phoneModel.getIdUser()));
        }

        return phone;
    }
}
