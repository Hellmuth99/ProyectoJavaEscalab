package tech.escalab.JavaProyecto.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.escalab.JavaProyecto.commons.exceptions.Response;
import tech.escalab.JavaProyecto.models.dto.TelefonoRequest;

import tech.escalab.JavaProyecto.models.dto.UsuarioRequest;
import tech.escalab.JavaProyecto.services.impl.TelefonoServiceImpl;


import java.util.List;

@RestController
@RequestMapping("/telefonos")
public class TelefonoController {

    TelefonoServiceImpl telefonoService;

    public TelefonoController(TelefonoServiceImpl telefonoService){this.telefonoService=telefonoService;}



    @GetMapping("/")
    public ResponseEntity<?> getTelefonos(){


        List<TelefonoRequest> telefonos = telefonoService.getTelefonos();
        if (!telefonos.isEmpty()) {
            return new ResponseEntity<>(telefonos, HttpStatus.OK);
        } else {
            Response errorResponse = new Response(HttpStatus.NOT_FOUND.value(), "No se encontraron telefonos");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getTelefono(@PathVariable("id") String id){
        TelefonoRequest telefono = telefonoService.getTelefono(id);

        if(telefono == null)  {

            Response errorResponse = new Response(HttpStatus.NOT_FOUND.value(), "No se encontraró el teléfono");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);


        } else {
            System.out.println("-si-encontre-user");
            return new ResponseEntity<>(telefono, HttpStatus.OK);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTelefono(@Valid @PathVariable("id") String id){

        boolean eliminadoExitosamente = telefonoService.eliminarTelefono(id);

        if (eliminadoExitosamente) {
            // El telefono fue eliminado exitosamente
            Response response = new Response(HttpStatus.OK.value(), "Teléfono " + id + " eliminado con éxito");
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else {
            // No se pudo encontrar el telefono con el ID proporcionado
            Response errorResponse = new Response(HttpStatus.NOT_FOUND.value(), "No se encontró el teléfono");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

    }
}
