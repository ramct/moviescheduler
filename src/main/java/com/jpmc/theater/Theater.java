package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Theater {

	private static final Logger logger = Logger.getLogger(Theater.class.getName());

	LocalDateProvider provider;
	private List<Showing> schedule;

	public Theater(LocalDateProvider provider) {
		this.provider = provider;

		Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
		Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
		Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), 9, 0);
		schedule = List.of(new Showing(turningRed, 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))),
				new Showing(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
				new Showing(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
				new Showing(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
				new Showing(spiderMan, 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))),
				new Showing(theBatMan, 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))),
				new Showing(turningRed, 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))),
				new Showing(spiderMan, 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))),
				new Showing(theBatMan, 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0))));
	}

	public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
		Showing showing;
		try {
			showing = schedule.get(sequence - 1);
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
		}
		return new Reservation(customer, showing, howManyTickets);
	}

	public void printSchedule() {
		logger.log(Level.INFO, "{0}", String.format("Current Schedule is %s%n", printScheduleAsJson()));
	}

	public String printScheduleAsString() {
		StringBuilder scheduleString = new StringBuilder();
		scheduleString.append(String.format("Date %s%n", provider.currentDate()));
		scheduleString.append(
				String.format("==============================================================================%n"));
		schedule.forEach(s -> scheduleString
				.append(String.format("%d: %s %-30s %s $%05.02f%n", s.getSequenceOfTheDay(), s.getStartTime(),
						s.getMovie().getTitle(), humanReadableFormat(s.getMovie().getRunningTime()), s.getMovieFee())));
		scheduleString.append(
				String.format("===============================================================================%n"));
		return scheduleString.toString();
	}

	public String printScheduleAsJson() {
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.registerModule(new JavaTimeModule());
		String json = "";
		try {
			json = objMapper.writeValueAsString(schedule);
		} catch (JsonProcessingException e) {
			logger.log(Level.SEVERE, "Failed to serialize object in JSON format. Json parse error", e);
		}
		return json;
	}

	private String humanReadableFormat(Duration duration) {
		long hour = duration.toHours();
		long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(hour);

		return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin,
				handlePlural(remainingMin));
	}

	// (s) postfix should be added to handle plural correctly
	private String handlePlural(long value) {
		if (value == 1) {
			return "";
		} else {
			return "s";
		}
	}

	public static void main(String[] args) {
		Theater theater = new Theater(LocalDateProvider.getInstance());
		theater.printSchedule();
	}
}
