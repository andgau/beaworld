package es.sinjava.ui.service;

import es.sinjava.ui.domain.LogEvent;

public interface IEventService {
	
	boolean populateEvent();

	Iterable<LogEvent>  getAllEvents();

}
