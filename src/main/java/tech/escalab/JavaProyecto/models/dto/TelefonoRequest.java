package tech.escalab.JavaProyecto.models.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.escalab.JavaProyecto.models.entity.Telefono;

import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TelefonoRequest {



    private String telefono_id;

    @NotEmpty(message = "El Numero es obligatorio")
    private String numero;
    @NotEmpty(message = "La Ciudad es obligatoria")
    private String cod_ciudad;
    @NotEmpty(message = "el Codigo de Pais es obligatorio")
    private String cod_pais;


    public static TelefonoRequest mapToDto(Telefono telefono){
        TelefonoRequest telefonoRequest = new TelefonoRequest();
        telefonoRequest.setTelefono_id(telefono.getTelefono_id());
        telefonoRequest.setNumero(telefono.getNumero());
        telefonoRequest.setCod_ciudad(telefono.getCod_ciudad());
        telefonoRequest.setCod_pais(telefono.getCod_pais());
        return telefonoRequest;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonoRequest that = (TelefonoRequest) o;
        return telefono_id == that.telefono_id && Objects.equals(numero, that.numero) && Objects.equals(cod_ciudad, that.cod_ciudad) && Objects.equals(cod_pais, that.cod_pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefono_id, numero, cod_ciudad, cod_pais);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TelefonoRequest{");
        sb.append("id=").append(telefono_id);
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", cod_ciudad='").append(cod_ciudad).append('\'');
        sb.append(", cod_pais='").append(cod_pais).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
