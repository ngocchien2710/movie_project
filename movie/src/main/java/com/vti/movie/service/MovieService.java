package com.vti.movie.service;

import com.vti.movie.dtos.MovieDTO;
import com.vti.movie.entity.Movie;
import com.vti.movie.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {
   private final IMovieRepository movieRepository;

   private final ModelMapper modelMapper;

   @Autowired
   public MovieService(IMovieRepository movieRepository) {
       this.modelMapper = new ModelMapper();

       this.movieRepository = movieRepository;
   }
    @Override
    public List<MovieDTO> findAllShowingMovies() {
//        return movieRepository.findMoviesByOrderByIdDesc(1)
//                .stream()
//                .map(movie -> modelMapper.map(movie, MovieDTO.class))
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    public MovieDTO getById(Integer movieId) {
        return modelMapper.map(movieRepository.getById(movieId),MovieDTO.class);
    }

    @Override
    public List<MovieDTO> findAllShowingMoviesByName(String keyword) {
        return movieRepository.findMoviesByNameContaining(keyword)
                .stream().map(movie -> modelMapper.map(movie,MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(int id, Movie updatedMovie) {
        Movie existingMovie = movieRepository.findById(id).orElse(null);
        if (existingMovie != null) {
            existingMovie.setName(updatedMovie.getName());
//            existingMovie.setSmallImageURl(updatedMovie.getSmallImageURl());
            existingMovie.setDescription(updatedMovie.getDescription());
            existingMovie.setImgURL(updatedMovie.getImgURL());
//            existingMovie.setLargeImageURL(updatedMovie.getLargeImageURL());
            existingMovie.setDirector(updatedMovie.getDirector());
            existingMovie.setActors(updatedMovie.getActors());
            existingMovie.setCategories(updatedMovie.getCategories());
            existingMovie.setReleaseDate(updatedMovie.getReleaseDate());
            existingMovie.setDuration(updatedMovie.getDuration());
            existingMovie.setTrailerURL(updatedMovie.getTrailerURL());
//            existingMovie.setLanguage(updatedMovie.getLanguage());
            existingMovie.setRated(updatedMovie.getRated());
            existingMovie.setNationProducter(updatedMovie.getNationProducter());
            return movieRepository.save(existingMovie);
        } else {
            return null;
        }
    }

    @Override
    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
}

