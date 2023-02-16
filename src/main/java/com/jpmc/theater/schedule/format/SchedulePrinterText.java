package com.jpmc.theater.schedule.format;

import com.jpmc.theater.LocalDateProvider;
import com.jpmc.theater.model.Showing;

import java.util.List;

public class SchedulePrinterText extends SchedulePrinterFormatAbstract {

    @Override
    public void printSchedule(List<Showing> schedule, LocalDateProvider provider) {
        System.out.println(provider.currentDate());
        System.out.println("===================================================");
        schedule.forEach(s -> System.out.println(s.getSequenceOfTheDay() + ": " + s.getStartTime() + " " + s.getMovie().getTitle() + " " + humanReadableFormat(s.getMovie().getRunningTime()) + " $" + s.getMovieFee()));
        System.out.println("===================================================");
    }

}
