package com.dac;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.dac.bean.Ticket;
import com.dac.service.TicketBookingService;

@SpringBootApplication
public class SpringBootCrudOperationRest1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(SpringBootCrudOperationRest1Application.class, args);
		System.out.println("Application is started...");
		
		System.out.println("Bean names: " + Arrays.toString(ctxt.getBeanNamesForType(TicketBookingService.class)));
		
		
		TicketBookingService bean = ctxt.getBean("ticketBookingService", TicketBookingService.class);
		
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		//ticket.setBookingDate(new Date());
		ticket.setDestStation("Mumbai");
		ticket.setSourceStation("pune");
		ticket.setPassengerName("Dipak Aher");
		ticket.setEmail("abc@gmail.com");
		bean.createTicket(ticket);
		
		
		
	}

	
	
}
