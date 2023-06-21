package tech.escalab.JavaProyecto.controllers;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tech.escalab.JavaProyecto.commons.exceptions.Response;
import tech.escalab.JavaProyecto.commons.exceptions.UsuarioResponse;
import tech.escalab.JavaProyecto.models.dto.UsuarioRequest;
import tech.escalab.JavaProyecto.models.entity.Usuario;
import tech.escalab.JavaProyecto.services.IUsuarioService;
import tech.escalab.JavaProyecto.services.impl.UsuarioServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    UsuarioServiceImpl usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService){this.usuarioService=usuarioService;}




    @PostMapping("/")
    public ResponseEntity<?> insertarUsuario (@Valid @RequestBody UsuarioRequest usuarioRequest){
        UsuarioRequest usuario = usuarioService.insertarUsuario(usuarioRequest);

        if(usuario == null) {
           // Response errorResponse = new Response(HttpStatus.NOT_FOUND.value(), "No se pudo crear el usuario");
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);


        }else{

            String id = usuario.getId();
            Date created = new Date();
            Date modified = new Date();
            boolean isActive = true;
            UsuarioResponse usuarioResponse = new UsuarioResponse(id, created, modified, isActive);

            return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);

        }

    }

    @GetMapping("/")
    public ResponseEntity <?> getUsuarios(){
        List<UsuarioRequest> usuarios = usuarioService.getUsuarios();
        if (!usuarios.isEmpty()) {
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } else {
            Response errorResponse = new Response(HttpStatus.NOT_FOUND.value(), "No se encontraron usuarios");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable("id") String id){
        UsuarioRequest usuario = usuarioService.getUsuario(id);

        if(usuario == null)  {
            Response errorResponse = new Response(HttpStatus.NOT_FOUND.value(), "No se encontraró el usuario");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        } else {
            System.out.println("-si-encontre-user");
            return new ResponseEntity<>(usuario, HttpStatus.OK);

        }
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        UsuarioRequest usuarioActualizado = usuarioService.actualizarUsuario(usuarioRequest);

        if (usuarioActualizado == null) {
            Response errorResponse = new Response(HttpStatus.UNPROCESSABLE_ENTITY.value(), "No se pudo actualizar el usuario");
            return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        }



    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@Valid @PathVariable("id") String id){

        boolean eliminadoExitosamente = usuarioService.eliminarUsuario(id);

        if (eliminadoExitosamente) {
            // El usuario fue eliminado exitosamente
            Response response = new Response(HttpStatus.OK.value(), "Usuario" + id + "eliminado con éxito");
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else {
            // No se pudo encontrar el usuario con el ID proporcionado
            Response errorResponse = new Response(HttpStatus.NOT_FOUND.value(), "No se encontró el usuario");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

    }



}
