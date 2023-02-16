package com.jpmc.theater.schedule.format;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jpmc.theater.LocalDateProvider;
import com.jpmc.theater.model.Showing;

import java.util.List;

public class SchedulePrinterJson extends SchedulePrinterFormatAbstract {

    @Override
    public void printSchedule(List<Showing> schedule, LocalDateProvider provider) {
        System.out.println(provider.currentDate());
        System.out.println("===================================================");

        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.findAndRegisterModules();
        try {
            String json = objectMapper.writeValueAsString(schedule);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
