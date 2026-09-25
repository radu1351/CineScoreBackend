package ro.cegedim.cinescore.movie.service;

import ro.cegedim.cinescore.movie.dto.MovieCreateDto;
import ro.cegedim.cinescore.movie.dto.MovieResponseDto;
import ro.cegedim.cinescore.movie.dto.MovieUpdateDto;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {

    MovieResponseDto createMovie(final MovieCreateDto movieCreateDto);

    MovieResponseDto updateMovie(final MovieUpdateDto movieUpdateDto);

    List<MovieResponseDto> getMovies(Long id, String title, LocalDate releaseDate);

    MovieResponseDto getMovie(Long id);

    void deleteMovie(Long id);
}
