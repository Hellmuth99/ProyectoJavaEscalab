package tech.escalab.JavaProyecto.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.escalab.JavaProyecto.models.entity.Telefono;


public interface TelefonoRepository extends JpaRepository<Telefono,String> {
}
