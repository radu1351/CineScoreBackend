package ro.cegedim.cinescore.movie.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ro.cegedim.cinescore.movie.exception.MovieNotFoundException;
import ro.cegedim.cinescore.movie.mapper.MovieMapper;
import ro.cegedim.cinescore.movie.dto.MovieCreateDto;
import ro.cegedim.cinescore.movie.dto.MovieResponseDto;
import ro.cegedim.cinescore.movie.dto.MovieUpdateDto;
import ro.cegedim.cinescore.movie.entity.Movie;
import ro.cegedim.cinescore.movie.repository.MovieRepository;
import ro.cegedim.cinescore.movie.specification.MovieSpecification;

import java.time.LocalDate;
import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public MovieResponseDto createMovie(MovieCreateDto movieCreateDto) {
        final Movie movie = movieMapper.toEntity(movieCreateDto);
        return movieMapper.toResponse(movieRepository.save(movie));
    }

    @Override
    public MovieResponseDto updateMovie(MovieUpdateDto movieUpdateDto) {
        return null;
    }

    @Override
    public List<MovieResponseDto> getMovies(Long id, String title, LocalDate releaseDate) {
        final Specification<Movie> specification = MovieSpecification.withFilters(id, title, releaseDate);

        final List<Movie> movies = movieRepository.findAll(specification);

        return movies.stream()
                .map(movieMapper::toResponse)
                .toList();
    }

    @Override
    public MovieResponseDto getMovie(Long id) {
        final Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id " + id + " not found"));
        return movieMapper.toResponse(movie);
    }

    @Override
    public void deleteMovie(Long id) {

    }
}
