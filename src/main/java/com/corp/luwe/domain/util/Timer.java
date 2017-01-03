package com.corp.luwe.domain.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * @author Ivan Lampert
 */
public final class Timer {

	private Timer() {
	}
	
	public static String formatDateToString(LocalDate date) {
		return (date != null ? date.format(DateTimeFormatter.ofPattern("dd/MM/yyy")) : "");
	}
	
	public static String dayOfWeekName(LocalDate date) {
		return (date != null ? date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()) : "");
	}
	
}
