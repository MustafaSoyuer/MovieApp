package com.mustafa.Service;

import com.mustafa.entity.Movie;
import com.mustafa.repository.MovieRepository;
import com.mustafa.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService implements ICrudService<Movie,Long> {
    private final MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> t) {
        return null;
    }

    @Override
    public Movie deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existById(Long aLong) {
        return false;
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public List<Movie> findByColumnAndValue(String columnName, Object value) {
        return null;
    }

    @Override
    public List<Movie> findAllEntity(Movie movie) {
        return null;
    }
}
