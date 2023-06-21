package tech.escalab.JavaProyecto.commons.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class UsuarioResponse {

    private String id;
    private Date created;
    private Date modified;
    private boolean isActive;

    public UsuarioResponse(String id, Date created, Date modified, boolean isActive) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.isActive = isActive;
    }


}
