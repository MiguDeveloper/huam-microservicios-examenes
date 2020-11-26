package pe.tuna.huammicroserviciosexamenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HuamMicroserviciosExamenesApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuamMicroserviciosExamenesApplication.class, args);
    }

}
