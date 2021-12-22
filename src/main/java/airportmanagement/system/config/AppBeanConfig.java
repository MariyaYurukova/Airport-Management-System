package airportmanagement.system.config;




import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@Configuration
public class AppBeanConfig {


    @Bean
    public ModelMapper modelMapper()  {
        return new ModelMapper();
    }


    @Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }

}
