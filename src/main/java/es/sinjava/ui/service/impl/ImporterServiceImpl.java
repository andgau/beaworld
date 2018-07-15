package es.sinjava.ui.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sinjava.ui.domain.LogEvent;
import es.sinjava.ui.repository.LogEventRepository;
import es.sinjava.ui.service.IImporterService;
import es.sinjava.ui.util.Extractor;

@Service
public class ImporterServiceImpl implements IImporterService {
	
	private Logger logger = LoggerFactory.getLogger(ImporterServiceImpl.class);

	LogEventRepository logEventRepository;

	@Autowired
	public ImporterServiceImpl(LogEventRepository eventRepository) {
		logEventRepository = eventRepository;
		importEvents("Coco");
	}

	@Override
	public boolean importEvents(String pathFile) {

		File file = new File("bent_core.log.2018-06-28-33.log");
		List<String> entries = new ArrayList<>();
		try {
			entries = FileUtils.readLines(file);
		} catch (IOException e) {
			logger.error("Error en la importación ", e);
		}

		for (Iterator<String> it = entries.iterator(); it.hasNext();) {
			String current = it.next();

			if (current.startsWith("2018")) {
				Extractor extractor = new Extractor(current);
				LogEvent newEvent = new LogEvent();
				newEvent.setAppAlias("Guay");
				newEvent.setCreated(extractor.getTimeStamp());
				newEvent.setLevel(extractor.getLevel());
				newEvent.setMethodClass(extractor.getMethodClass());
				newEvent.setMessageEvent(extractor.getMessage());
				newEvent.setThread(extractor.getThread());
				logEventRepository.save(newEvent);
			}
		}

		return true;
	}

}
