package com.travix.medusa.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateConversion {
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public String parseDate(LocalDateTime date) {
        String formatDateTime = date.format(formatter);
        return formatDateTime;
    }
	
}
