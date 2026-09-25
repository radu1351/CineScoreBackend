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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", description='" + description + '\'' +
                ", durationMinutes=" + durationMinutes +
                '}';
    }
}
