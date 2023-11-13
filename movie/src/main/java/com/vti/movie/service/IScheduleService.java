package com.vti.movie.service;

import com.vti.movie.dtos.ScheduleDTO;
import com.vti.movie.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface IScheduleService {
    List<String> getStartTimes(Integer movieId, Integer cinemaId, LocalDate movieDate);

    List<ScheduleDTO> getSchedules(Integer movieId, Integer cinemaId, String movieDate, String startTime,String finishTime ,Integer roomId);

    List<Schedule> getAllSchedules();

    Schedule getScheduleById(int id);

    Schedule createSchedule(Schedule schedule);

    Schedule updateSchedule(int id, Schedule updatedSchedule);

    void deleteSchedule(int id);
}
