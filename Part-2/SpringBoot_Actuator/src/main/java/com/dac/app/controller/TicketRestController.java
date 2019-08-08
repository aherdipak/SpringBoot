package com.dac.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dac.app.bean.Ticket;
import com.dac.app.service.TicketBookingService;


//@RestController
public class TicketRestController {
	
	@Autowired
	TicketBookingService ticketBookingService;
	
	@GetMapping("/welcome")
	public String getWelcome() {
		System.out.println("Welcome..!!!");
		return "Welcome in spring boot application...";
		
	}
	
	@RequestMapping("/allStudent")
	public List<Ticket> allTickets() {
		return ticketBookingService.findAll();
	}
	
	@GetMapping(value = "/getTicket/{ticketId}")
	public Optional<Ticket> getTicket(@PathVariable("ticketId") Integer ticketId) {
		System.out.println(ticketId);
		return  ticketBookingService.getTicket(ticketId);
	}
	
	@PostMapping(value = "/createTicket.htm")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return  ticketBookingService.createTicket(ticket);
	}
	
	@DeleteMapping("/delete/{ticketId}")
	public boolean deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketBookingService.deleteTicket(ticketId);
		return true;
	}
	
	@PutMapping(value = "/update")
	public Ticket updateTicket(@RequestBody Ticket ticket) {
		return  ticketBookingService.updateTicket(ticket);
		//return ticket;
	}

}
