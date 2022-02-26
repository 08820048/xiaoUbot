package simbot.xiaoU;

import love.forte.simbot.annotation.SimbotApplication;
import love.forte.simbot.spring.autoconfigure.EnableSimbot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author 22170
 */
@EnableSimbot
@SimbotApplication
@EnableScheduling
@SpringBootApplication
public class SimbotExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimbotExampleApplication.class, args);
    }



}
