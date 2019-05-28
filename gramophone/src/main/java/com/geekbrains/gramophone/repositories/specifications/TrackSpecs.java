package com.geekbrains.gramophone.repositories.specifications;

import com.geekbrains.gramophone.entities.Track;
import org.springframework.data.jpa.domain.Specification;

public class TrackSpecs {
    public static Specification<Track> titleContains(String word) {
        return (Specification<Track>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%" + word + "%");
    }

    public static Specification<Track> authorNameContains(String word) {
        return (Specification<Track>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("authorName"), "%" + word + "%");
    }

    public static Specification<Track> albumContains(String word) {
        return (Specification<Track>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("album"), "%" + word + "%");
    }

}
