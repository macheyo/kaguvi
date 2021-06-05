package zw.co.footprint.kaguvi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import zw.co.footprint.kaguvi.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)

public class KaguviApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaguviApplication.class, args);
	}

}
