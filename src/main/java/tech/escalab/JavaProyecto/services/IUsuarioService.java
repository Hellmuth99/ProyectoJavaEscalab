package tech.escalab.JavaProyecto.services;

import tech.escalab.JavaProyecto.models.dto.UsuarioRequest;
import tech.escalab.JavaProyecto.models.entity.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUsuarioService {

    List<UsuarioRequest> getUsuarios();
    UsuarioRequest insertarUsuario(UsuarioRequest request);

    UsuarioRequest getUsuario(String id);

    //actualizar un usuario
    UsuarioRequest actualizarUsuario(UsuarioRequest usuarioRequest);
    public boolean eliminarUsuario(String id);

}
