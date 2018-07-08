package es.sinjava.ui.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sinjava.ui.domain.LogEvent;
import es.sinjava.ui.mvc.MessageController;
import es.sinjava.ui.repository.LogEventRepository;
import es.sinjava.ui.service.IEventService;

@Service
public class EventServiceImpl implements IEventService {
	
	private Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	LogEventRepository logEventRepository;

	@Override
	public boolean populateEvent() {
		logger.debug("Begin populateEvent");
		LogEvent eventLog= new LogEvent();
		eventLog.setAppAlias("Guay");
		eventLog.setCreated(new Date());
		logEventRepository.save(eventLog);
		return true;
	}

	@Override
	public Iterable<LogEvent>  getAllEvents() {
		logger.debug("Begin getAllEvents");
		Iterable<LogEvent> allEvents = logEventRepository.findAll();
		return allEvents;
	}

}
