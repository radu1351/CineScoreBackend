package ro.cegedim.cinescore.movie.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.cegedim.cinescore.movie.dto.MovieCreateDto;
import ro.cegedim.cinescore.movie.dto.MovieResponseDto;
import ro.cegedim.cinescore.movie.service.MovieServiceImpl;

import java.time.LocalDate;
import java.util.List;

@RestController()
@RequestMapping("/movies")
public class MovieController {
    private final MovieServiceImpl movieService;

    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    List<MovieResponseDto> getMovies(@RequestParam(required = false) Long id,
                                     @RequestParam(required = false) String title,
                                     @RequestParam(required = false) LocalDate releaseDate){
        return movieService.getMovies(id, title, releaseDate);
    }

    @GetMapping("/{id}")
    MovieResponseDto getMovie(@PathVariable Long id){
        return movieService.getMovie(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    MovieResponseDto createMovie(@Valid @RequestBody final MovieCreateDto movieCreateDto) {
        return movieService.createMovie(movieCreateDto);
    }
}
