package com.geekbrains.gramophone.controllers;

import com.geekbrains.gramophone.entities.Track;
import com.geekbrains.gramophone.repositories.specifications.TrackSpecs;
import com.geekbrains.gramophone.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/tracklist")
public class TrackListController {
    private static final int INITIAL_PAGE = 0;
    private static final int PAGE_SIZE = 2;

    private TrackService trackService;

    @Autowired
    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public String shopPage(Model model,
                           @RequestParam(value = "page") Optional<Integer> page,
                           @RequestParam(value = "trackName", required = false) String trackName,
                           @RequestParam(value = "author", required = false) String author,
                           @RequestParam(value = "album", required = false) String album
    ) {
        final int currentPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Specification<Track> spec = Specification.where(null);
        StringBuilder filters = new StringBuilder();
        if (trackName != null) {
            spec = spec.and(TrackSpecs.titleContains(trackName));
            filters.append("&trackName=" + trackName);
        }
        if (author != null) {
            spec = spec.and(TrackSpecs.authorNameContains(author));
            filters.append("&author=" + author);
        }
        if (album != null) {
            spec = spec.and(TrackSpecs.albumContains(album));
            filters.append("&album=" + album);
        }

        Page<Track> tracks = trackService.getTracksWithPagingAndFiltering(currentPage, PAGE_SIZE, spec);

        model.addAttribute("tracks", tracks.getContent());
        model.addAttribute("page", currentPage);
        model.addAttribute("totalPage", tracks.getTotalPages());

        model.addAttribute("filters", filters.toString());

        model.addAttribute("author", author);
        model.addAttribute("album", album);
        model.addAttribute("trackName", trackName);
        return "track-list";
    }

    @GetMapping("/track_info/{id}")
    public String trackPage(Model model, @PathVariable(value = "id") Long id) {
        Track track = trackService.findById(id);
        model.addAttribute("track", track);
        return "track-page";
    }
    
}
