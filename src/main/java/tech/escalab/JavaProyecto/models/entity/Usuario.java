package tech.escalab.JavaProyecto.models.entity;


import jakarta.persistence.*;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.*;


@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends RepresentationModel<Usuario> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String nombre;
    @Column(nullable = false, unique = true)
    private String correo;

    private String password;

    @Column(name = "created", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created;

    @Column(name = "modified", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modified;
 /*   @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;*/

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private List<Telefono> telefonos = new ArrayList<>();





    @PrePersist
    public void prePersist() {
        if (id == null || id.isEmpty()) {
            id = UUID.randomUUID().toString();
        }
        if (created == null) {
            created = LocalDateTime.now();
            modified = LocalDateTime.now();
        }
        active = true;
    }

    @PreUpdate
    public void preUpdate() {
        modified = LocalDateTime.now();
    }

  /*  @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", correo='").append(correo).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", created=").append(created);
        sb.append(", modified=").append(modified);
        sb.append(", is_active=").append(is_active);
        sb.append(", telefonos=").append(telefonos);
        sb.append('}');
        return sb.toString();
    }*/

  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return is_active == usuario.is_active && id.equals(usuario.id) && Objects.equals(nombre, usuario.nombre) && Objects.equals(correo, usuario.correo) && Objects.equals(password, usuario.password) && Objects.equals(created, usuario.created) && Objects.equals(modified, usuario.modified) && Objects.equals(telefonos, usuario.telefonos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, correo, password, created, modified, is_active, telefonos);
    }*/
}
