package com.geekbrains.gramophone.services;

import com.geekbrains.gramophone.entities.Track;
import com.geekbrains.gramophone.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Track findById(Long id) {
        return trackRepository.findById(id).orElse(null);
    }

    public List<Track> getAllTrack() {
        return (List<Track>) trackRepository.findAll();
    }

    public Page<Track> getTracksWithPagingAndFiltering(int pageNumber, int pageSize, Specification<Track> trackSpecification) {
        return trackRepository.findAll(trackSpecification, PageRequest.of(pageNumber, pageSize));
    }

    public Track saveOrUpdate(Track track) {
        return trackRepository.save(track);
    }
}
