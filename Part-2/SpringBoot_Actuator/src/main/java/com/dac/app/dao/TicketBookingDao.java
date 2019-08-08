package com.dac.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.dac.app.bean.Ticket;

//@Repository - this is optinal
public interface TicketBookingDao extends CrudRepository<Ticket,Integer> {//JpaRepository<Ticket, Integer>{ 


}
