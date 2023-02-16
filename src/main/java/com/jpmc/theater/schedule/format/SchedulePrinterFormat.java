package com.jpmc.theater.schedule.format;

import com.jpmc.theater.LocalDateProvider;
import com.jpmc.theater.model.Showing;

import java.util.List;

public interface SchedulePrinterFormat {

    void printSchedule(List<Showing> schedule, LocalDateProvider provider);

}
