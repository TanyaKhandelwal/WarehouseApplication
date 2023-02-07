package com.tanya.jwt.time;

import java.util.List;

public interface TimeService {
	Time getLastAddedEntry();
	List<Time> getEntryByUser(String userid);
}