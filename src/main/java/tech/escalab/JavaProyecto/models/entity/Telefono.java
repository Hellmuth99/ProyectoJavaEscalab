package tech.escalab.JavaProyecto.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

@Entity
@Table(name = "telefonos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Telefono extends RepresentationModel<Telefono> {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    private String telefono_id;

    @Column(name = "numero" ,nullable = false)
    private String numero;
    @Column(name = "cod_ciudad" ,nullable = false)
    private String cod_ciudad;
    @Column(name = "cod_pais",nullable = false)
    private String cod_pais;


}
