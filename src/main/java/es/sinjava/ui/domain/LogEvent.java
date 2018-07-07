package es.sinjava.ui.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LogEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
//	@ManyToOne(optional = false)
//	private LogFile logfile;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;
	
	private String messageEvent;
	
	private String appAlias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessageEvent() {
		return messageEvent;
	}

	public void setMessageEvent(String messageEvent) {
		this.messageEvent = messageEvent;
	}

	public String getAppAlias() {
		return appAlias;
	}

	public void setAppAlias(String appAlias) {
		this.appAlias = appAlias;
	}
	
	
}
