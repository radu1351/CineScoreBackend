package ro.cegedim.cinescore.movie.dto;

import java.time.LocalDate;

public record MovieUpdateDto(String title, LocalDate releaseDate, String description,
                             Integer durationMinutes) {
}
