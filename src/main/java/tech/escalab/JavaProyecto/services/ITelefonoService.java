package tech.escalab.JavaProyecto.services;

import tech.escalab.JavaProyecto.models.dto.TelefonoRequest;
import tech.escalab.JavaProyecto.models.dto.UsuarioRequest;

import java.util.List;

public interface ITelefonoService {

    List<TelefonoRequest> getTelefonos();
    TelefonoRequest getTelefono(String id);

    public boolean eliminarTelefono(String id);
}
