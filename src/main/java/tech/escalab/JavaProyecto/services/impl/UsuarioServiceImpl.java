package tech.escalab.JavaProyecto.services.impl;

import org.springframework.stereotype.Service;
import tech.escalab.JavaProyecto.models.dto.UsuarioRequest;
import tech.escalab.JavaProyecto.models.entity.Usuario;
import tech.escalab.JavaProyecto.models.repository.UsuarioRepository;
import tech.escalab.JavaProyecto.services.IUsuarioService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioRequest insertarUsuario(UsuarioRequest request) {


     Usuario usuarioEntity = UsuarioRequest.mapToEntity(request);
        usuarioRepository.save(usuarioEntity);
     return UsuarioRequest.mapToDto(usuarioEntity);

    }

    @Override
    public List<UsuarioRequest> getUsuarios(){

        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioRequest> usuariosDto = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuariosDto.add(UsuarioRequest.mapToDto(usuario));
        }

        return usuariosDto;
    }



    @Override
    public UsuarioRequest getUsuario(String id) {
        Optional<Usuario> userop = usuarioRepository.findById(id);

        return userop.map(usuario -> {
            UsuarioRequest usuarioRequest = new UsuarioRequest();
            usuarioRequest.setId(usuario.getId());
            usuarioRequest.setNombre(usuario.getNombre());
            usuarioRequest.setCorreo(usuario.getCorreo());
            usuarioRequest.setPassword(usuario.getPassword());
            usuarioRequest.setCreated(usuario.getCreated());
            usuarioRequest.setModified(usuario.getModified());
            usuarioRequest.setTelefonos(usuario.getTelefonos());
            usuarioRequest.setActive(usuario.isActive());
            return usuarioRequest;
        }).orElse(null);

    }

    @Override
    public UsuarioRequest actualizarUsuario(UsuarioRequest usuarioRequest) {

        usuarioRequest.setModified(java.time.LocalDateTime.now());
        Optional<Usuario> user = usuarioRepository.findById(usuarioRequest.getId());


        if (user.isPresent()) {
            Usuario usuario = user.get();


            // Actualiza los atributos del usuario con los valores proporcionados en usuarioRequest
            usuario.setNombre(usuarioRequest.getNombre());
            usuario.setCorreo(usuarioRequest.getCorreo());
            usuario.setPassword(usuarioRequest.getPassword());
            usuario.getCreated();
            usuario.setModified(usuarioRequest.getModified());
            usuario.setTelefonos(usuarioRequest.getTelefonos());
            usuario.setActive(usuarioRequest.isActive());

            // Guarda el usuario actualizado en la base de datos
            Usuario usuarioActualizado = usuarioRepository.save(usuario);

            // Construye y devuelve el objeto UsuarioRequest actualizado
            return new UsuarioRequest(
                    usuarioActualizado.getId(),
                    usuarioActualizado.getNombre(),
                    usuarioActualizado.getCorreo(),
                    usuarioActualizado.getPassword(),
                    usuarioActualizado.getCreated(),
                    usuarioActualizado.getModified(),
                    usuarioActualizado.getTelefonos(),
                    usuarioActualizado.isActive()
            );
        } else {
            return null; // excepción indicando que el usuario no existe
        }


    }

    @Override
    public boolean eliminarUsuario(String id) {

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);

        if (usuarioEncontrado.isPresent()) {
            // El usuario existe, se puede eliminar
            usuarioRepository.deleteById(id);
            return true;
        } else {
            // El usuario no existe, no se puede eliminar
            return false;
        }

    }

}
