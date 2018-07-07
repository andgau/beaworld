package es.sinjava.ui.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Extractor {

	private static DateFormat df = new SimpleDateFormat("HH:mm:ss, sss");
	private Date timeStamp;
	private String level;
	private String thread;
	private String message;
	private String methodClass;

	public Extractor(String trace) {
		System.out.println("---ESTE No Peta" +trace);
		String[] fields = trace.split(" ");
		String timeStampString = fields[0].concat(" ").concat(fields[1]);
		// current
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,sss");
		try {
			timeStamp = df.parse(timeStampString.trim());
		} catch (ParseException e) {

		}
		level = fields[2];

		int startMess = 0;

		// Tareas no programadas
		if (fields[3].contains("[ACTIVE]")) {

			thread = fields[5].replaceAll("'", "");
			methodClass = fields[10].substring(1, fields[10].length() - 1);
			startMess = 11;
		} else {
			thread = fields[3];
			methodClass = fields[4].substring(1, fields[4].length() - 1);

			startMess = 4;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = startMess; i < fields.length; i++) {
			sb.append(fields[i]);
		}
		message = sb.toString();

	}

	@Override
	public String toString() {
		return "Event [date=" + df.format(timeStamp) + " Level=" + level + ", thread=" + thread + ", message=" + message
				+ ", methodClass=" + methodClass + "]";
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date date) {
		this.timeStamp = date;
	}

	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMethodClass() {
		return methodClass;
	}

	public void setMethodClass(String methodClass) {
		this.methodClass = methodClass;
	}

}
