package com.jpmc.theater;

import java.time.LocalDate;

public class LocalDateProvider {

	private LocalDateProvider() {
	}
	
    private static class DateHolder {
    	public static final LocalDateProvider instance = new LocalDateProvider();
    }
    
    public static LocalDateProvider getInstance() {
    	return DateHolder.instance;
    }

    public LocalDate currentDate() {
        return LocalDate.now();
    }
}
