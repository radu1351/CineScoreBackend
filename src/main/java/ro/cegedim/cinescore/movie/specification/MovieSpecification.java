package ro.cegedim.cinescore.movie.specification;

import org.springframework.data.jpa.domain.Specification;
import ro.cegedim.cinescore.movie.entity.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Predicate;

public class MovieSpecification {

    public static Specification<Movie> withFilters(Long id, String title, LocalDate releaseDate) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (id != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), id));
            }

            if (title != null) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("title")), "%" + title + "%"));
            }

            if (releaseDate != null) {
                predicates.add(criteriaBuilder.equal(root.get("releaseDate"), releaseDate));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

    }
}
