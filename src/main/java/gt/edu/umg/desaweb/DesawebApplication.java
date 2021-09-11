package gt.edu.umg.desaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import gt.edu.umg.desaweb.utils.ConfigProperty;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableConfigurationProperties({ConfigProperty.class})
public class DesawebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesawebApplication.class, args);
	}

}
