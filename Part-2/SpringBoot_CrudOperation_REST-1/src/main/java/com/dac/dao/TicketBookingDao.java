package com.dac.dao;

import org.springframework.data.repository.CrudRepository;

import com.dac.bean.Ticket;

//@Repository - this is optinal
public interface TicketBookingDao extends CrudRepository<Ticket,Integer> {//JpaRepository<Ticket, Integer>{ 


}
