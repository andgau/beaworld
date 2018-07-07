package es.sinjava.ui.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sinjava.ui.domain.LogEvent;
import es.sinjava.ui.repository.LogEventRepository;
import es.sinjava.ui.service.IEventService;

@Service
public class EventServiceImpl implements IEventService {
	
	@Autowired
	LogEventRepository logEventRepository;

	@Override
	public boolean populateEvent() {
		System.out.println("Se ha llamado al servicio");
		LogEvent eventLog= new LogEvent();
		eventLog.setAppAlias("Guay");
		eventLog.setCreated(new Date());
		logEventRepository.save(eventLog);
		System.out.println("Elementos "+ logEventRepository.count() );
		return true;
	}

}