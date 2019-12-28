package com.api.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import static java.time.temporal.TemporalAdjusters.*;


public class DateTimeCalculatorUtil {
	
	public static final String TODAY = "today";
	public static final String LAST_MONTH = "lastMonth";
	
	public static final String START_TIME="START_TIME";
	public static final String END_TIME="END_TIME";
	
	private DateTimeCalculatorUtil() {}
	
	public static Map<String,LocalDateTime> calculateTime (String time) {
		Map<String, LocalDateTime> dates = new HashMap<>();
		switch (time) {
		case TODAY:
			dates.put(START_TIME, calculateTodayMidNight());
			dates.put(END_TIME, LocalDateTime.now());
			break;
		case LAST_MONTH:
			dates.put(START_TIME, calculdateFirstDayLastMonth());
			dates.put(END_TIME, calculdateLastDayLastMonth());
			break;
			
		default:
			break;
		}
		
		return dates;
	}
	
	private static LocalDateTime calculateTodayMidNight () {
		LocalTime midnight = LocalTime.MIDNIGHT;
		LocalDate today = LocalDate.now();
		return LocalDateTime.of(today, midnight);
	}
	
	private static LocalDateTime calculdateFirstDayLastMonth () {
		LocalTime midnight = LocalTime.MIDNIGHT;
		LocalDate today = LocalDate.now();
		LocalDateTime dt1 = LocalDateTime.of(today, midnight);
		return dt1.minusMonths(1).with(firstDayOfMonth());
	}
	
	private static LocalDateTime calculdateLastDayLastMonth () {
		LocalTime midnight = LocalTime.now();
		LocalDate today = LocalDate.now();	
		LocalDateTime dt1 = LocalDateTime.of(today, midnight);
		return dt1.minusMonths(1).with(lastDayOfMonth());		
	}
	
}