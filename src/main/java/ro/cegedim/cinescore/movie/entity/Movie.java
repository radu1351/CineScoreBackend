package ro.cegedim.cinescore.movie.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "movie" , schema = "public")
public class Movie {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;
}
