package com.dac.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dac.app.bean.Ticket;
import com.dac.app.dao.TicketBookingDao;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	public Ticket createTicket(Ticket ticket) {
		 ticketBookingDao.save(ticket);
		 return ticket;
	}

	public Optional<Ticket> getTicket(Integer ticketId) {
		return ticketBookingDao.findById(ticketId);
	}

	public List<Ticket> findAll() {
		return (List<Ticket>) ticketBookingDao.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
		 
	}

	public Ticket updateTicket(Ticket ticket) {
		if(ticketBookingDao.existsById(ticket.getTicketId())) {
			ticketBookingDao.delete(ticket);
		}
		ticketBookingDao.save(ticket);
		return ticket;
	}

}
