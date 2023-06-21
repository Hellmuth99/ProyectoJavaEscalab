package tech.escalab.JavaProyecto.models.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.escalab.JavaProyecto.models.entity.Telefono;
import tech.escalab.JavaProyecto.models.entity.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    private String id;
    @NotEmpty(message = "El nombre del usuario es obligatorio")
    private String nombre;
    @NotEmpty(message = "El correo electrónico del usuario es obligatorio")
    @Email(message = "Por favor, proporciona una dirección de correo electrónico válida.")
    private String correo;
    @NotEmpty(message = "La contraseña del usuario es obligatoria")
    private String password;

    private LocalDateTime created;

    private LocalDateTime modified;

    @Valid
    private List<Telefono> telefonos;

    private boolean active;


    public static UsuarioRequest mapToDto(Usuario entity) {
        UsuarioRequest dto = new UsuarioRequest();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setPassword(entity.getPassword());
        dto.setActive(entity.isActive());
        dto.setCorreo(entity.getCorreo());
        dto.setCreated(entity.getCreated());
        dto.setModified(entity.getModified());
        dto.setTelefonos(entity.getTelefonos());
        return dto;
    }


    public static Usuario mapToEntity(UsuarioRequest dto){
        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setId(dto.getId());
        usuarioEntity.setNombre(dto.getNombre());
        usuarioEntity.setPassword(dto.getPassword());
        usuarioEntity.setActive(dto.isActive());
        usuarioEntity.setCorreo(dto.getCorreo());
        usuarioEntity.setCreated(dto.getCreated());
        usuarioEntity.setModified(dto.getModified());
        usuarioEntity.setTelefonos(dto.getTelefonos());
        return usuarioEntity;

    }




}
