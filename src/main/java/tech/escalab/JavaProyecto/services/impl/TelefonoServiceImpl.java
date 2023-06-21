package tech.escalab.JavaProyecto.services.impl;

import org.springframework.stereotype.Service;
import tech.escalab.JavaProyecto.models.dto.TelefonoRequest;
import tech.escalab.JavaProyecto.models.dto.UsuarioRequest;
import tech.escalab.JavaProyecto.models.entity.Telefono;
import tech.escalab.JavaProyecto.models.entity.Usuario;
import tech.escalab.JavaProyecto.models.repository.TelefonoRepository;
import tech.escalab.JavaProyecto.models.repository.UsuarioRepository;
import tech.escalab.JavaProyecto.services.ITelefonoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelefonoServiceImpl  implements ITelefonoService {


    TelefonoRepository telefonoRepository;
    public TelefonoServiceImpl(TelefonoRepository telefonoRepository){

        this.telefonoRepository = telefonoRepository;
    }


    @Override
    public List<TelefonoRequest> getTelefonos(){

        List<Telefono> telefonos = telefonoRepository.findAll();
        List<TelefonoRequest> telefonosDto = new ArrayList<>();

        for (Telefono telefono : telefonos) {
            telefonosDto.add(TelefonoRequest.mapToDto(telefono));
        }

        return telefonosDto;
    }


    @Override
    public TelefonoRequest getTelefono(String id) {
        Optional<Telefono> telop = telefonoRepository.findById(id);


        return telop.map(telefono -> {
            TelefonoRequest telefonoRequest = new TelefonoRequest();
            telefonoRequest.setTelefono_id(telefono.getTelefono_id());
            telefonoRequest.setNumero(telefono.getNumero());
            telefonoRequest.setCod_pais(telefono.getCod_pais());
            telefonoRequest.setCod_ciudad(telefono.getCod_ciudad());

            return telefonoRequest;
        }).orElse(null);
    }


    @Override
    public boolean eliminarTelefono(String id) {

        Optional<Telefono> telefonoEncontrado = telefonoRepository.findById(id);

        if (telefonoEncontrado.isPresent()) {
            // El usuario existe, se puede eliminar
            telefonoRepository.deleteById(id);
            return true;
        } else {
            // El usuario no existe, no se puede eliminar
            return false;
        }

    }

}
