package com.client.repository;

import org.springframework.data.repository.CrudRepository;

import com.client.model.EventLog;
/**
 * This implementation of the event log repository takes care of any CRUD operations on the table
 * @author madhu
 *
 */
public interface EventLogCrudRepository extends CrudRepository<EventLog, Long> {

}
