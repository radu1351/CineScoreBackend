package ro.cegedim.cinescore.movie.mapper;

import org.mapstruct.Mapper;
import ro.cegedim.cinescore.movie.dto.MovieCreateDto;
import ro.cegedim.cinescore.movie.dto.MovieResponseDto;
import ro.cegedim.cinescore.movie.dto.MovieUpdateDto;
import ro.cegedim.cinescore.movie.entity.Movie;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieResponseDto toResponse (Movie move);

    Movie toEntity(MovieCreateDto movieCreateDto);

    Movie toEntity(MovieUpdateDto movieUpdateDto);
}
