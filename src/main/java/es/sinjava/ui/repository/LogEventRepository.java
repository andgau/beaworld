package es.sinjava.ui.repository;

import org.springframework.data.repository.CrudRepository;

import es.sinjava.ui.domain.LogEvent;

public interface LogEventRepository extends CrudRepository<LogEvent, Long> {

}
