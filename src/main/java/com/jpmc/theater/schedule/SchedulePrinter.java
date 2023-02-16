package com.jpmc.theater.schedule;

import com.jpmc.theater.LocalDateProvider;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.schedule.format.SchedulePrinterJson;
import com.jpmc.theater.schedule.format.ScheduleFormat;
import com.jpmc.theater.schedule.format.SchedulePrinterFormat;
import com.jpmc.theater.schedule.format.SchedulePrinterText;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum SchedulePrinter {
    INSTANCE;

    private static final Map<ScheduleFormat, SchedulePrinterFormat> scheduleFormats = new HashMap<>() {{
        put(ScheduleFormat.TEXT, new SchedulePrinterText());
        put(ScheduleFormat.JSON, new SchedulePrinterJson());
    }};

    public void printSchedule(ScheduleFormat scheduleFormat, List<Showing> schedule, LocalDateProvider provider) {
        scheduleFormats.get(scheduleFormat).printSchedule(schedule, provider);
    }

}
