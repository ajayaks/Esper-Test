package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.util.RandomTemperatureEventGenerator;

@SpringBootApplication
public class EsperTestApplication implements CommandLineRunner{
	/** Logger */
    private static Logger LOG = LoggerFactory.getLogger(EsperTestApplication.class);
    @Autowired
    RandomTemperatureEventGenerator generator;
    
    @Override
    public void run(String... args)
    {
    	long noOfTemperatureEvents = 1000;
    	generator.startSendingTemperatureReadings(noOfTemperatureEvents);
    	
    }

	public static void main(String[] args) {
		SpringApplication.run(EsperTestApplication.class, args);
		LOG.debug("Starting...");

        long noOfTemperatureEvents = 1000;

        if (args.length != 1) {
            LOG.debug("No override of number of events detected - defaulting to " + noOfTemperatureEvents + " events.");
        } else {
            noOfTemperatureEvents = Long.valueOf(args[0]);
        }

        // Load spring config
        //ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "application-context.xml" });
        //BeanFactory factory = (BeanFactory) appContext;

        // Start Demo
        //RandomTemperatureEventGenerator generator = (RandomTemperatureEventGenerator) factory.getBean("eventGenerator");
        //generator.startSendingTemperatureReadings(noOfTemperatureEvents);
	}
	
	
}
