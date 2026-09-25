package ro.cegedim.cinescore.movie.dto;

import java.time.LocalDate;

public record MovieResponseDto(String id, String title, LocalDate releaseDate, String description,
                               Integer durationMinutes) {
}
