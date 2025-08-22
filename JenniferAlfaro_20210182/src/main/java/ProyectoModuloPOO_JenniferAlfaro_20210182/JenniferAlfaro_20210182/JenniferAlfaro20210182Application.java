package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JenniferAlfaro20210182Application {

	public static void main(String[] args) {
		SpringApplication.run(JenniferAlfaro20210182Application.class, args);
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(dotenvEntry -> System.setProperty(dotenvEntry.getKey(),dotenvEntry.getValue()));
	}

}
