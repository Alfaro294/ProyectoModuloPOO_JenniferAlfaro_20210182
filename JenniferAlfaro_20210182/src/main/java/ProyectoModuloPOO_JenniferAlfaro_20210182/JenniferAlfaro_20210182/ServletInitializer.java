package ProyectoModuloPOO_JenniferAlfaro_20210182.JenniferAlfaro_20210182;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JenniferAlfaro20210182Application.class);
	}

}
