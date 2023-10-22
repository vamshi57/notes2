package in.nareshit.raghu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudDcCompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDcCompanyServiceApplication.class, args);
	}

}
