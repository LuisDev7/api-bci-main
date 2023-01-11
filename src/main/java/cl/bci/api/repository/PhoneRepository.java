package cl.bci.api.repository;

import cl.bci.api.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    List<Phone> findByIdUser(Integer idUser);
}
