package fr.esiea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringWebApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringWebApp.class);

    public static int state = -1;

    public static void main(String[] args) {
        SpringApplication.run(SpringWebApp.class);
        Runnable updateQualityTask = () -> {
            String threadName = Thread.currentThread().getName();
            DataBaseController dc = DataBaseController.getInstance();
            List<Item> listItems = dc.getItems();
            GildedRose g = new GildedRose(listItems.toArray(new Item[listItems.size()]));
            g.updateQuality();
            dc.setItems(g.getItems());
            LOGGER.info("updateQuality with " + threadName);
        };
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(updateQualityTask, 0L, 15L, TimeUnit.MINUTES);
        state = 0;
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            LOGGER.info("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                LOGGER.info(beanName);
            }

        };
    }
}