package tech.escalab.JavaProyecto;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Usuarios API RESTful", version = "1.0", description = "API RESTful para Usuarios"))
public class JavaProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaProyectoApplication.class, args);
	}

}
