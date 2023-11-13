package com.vti.movie.repository;

import com.vti.movie.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Integer> {
    @Query("SELECT DISTINCT  s.finishTime , s.startTime FROM Schedule s WHERE s.movie.id=:movieId AND s.cinema.id" +
            "= :cinemaId AND s.movieDate=:movieDate")
    List<LocalTime> getStartTimeByMovie_IdAndCinema_IdAndStartDate(
            @Param("movieId") Integer movieId
            , @Param("cinemaId") Integer cinemaId
            , @Param("movieDate") LocalDate movieDate);

    @Query("SELECT  s.finishTime , s.startTime FROM Schedule s " +
            "WHERE s.movie.id =:movieId " +
            "AND s.cinema.id = :cinemaId " +
            "AND s.movieDate = :movieDate " +
            "AND s.startTime = :startTime " +
            "AND s.finishTime = :finishTime " +
            "AND s.room.id =:roomId")
    List<Schedule> getScheduleByMovieAndCinemaAndMovieDateAndStartTimeAndRoom
            (@Param("movieId") Integer movieId,
             @Param("cinemaId") Integer cinemaId,
             @Param("movieDate") LocalDate movieDate,
             @Param("startTime") LocalTime startTime,
             @Param("finishTime") LocalTime finishTime,
             @Param("roomId") Integer roomId);

//    List<Schedule>
//
}
