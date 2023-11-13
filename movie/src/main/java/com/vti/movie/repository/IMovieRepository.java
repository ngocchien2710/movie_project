package com.vti.movie.repository;

import com.vti.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
//    List<Movie> findMoviesByOrderByIdDesc(Integer isShowing);
    List<Movie> findMoviesByNameContaining( String name);
}
