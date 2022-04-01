package com.mir00r.moviecatelogservices.controllers;

import com.mir00r.moviecatelogservices.models.CatalogItem;
import com.mir00r.moviecatelogservices.models.Movie;
import com.mir00r.moviecatelogservices.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mir00r on 1/4/22
 * @project IntelliJ IDEA
 */
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);

        if (userRating == null) return new ArrayList<>();
        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://ratings-data-service/ratingsdata/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName() == null ? "Hello World" : movie.getName(), movie.getDescription(), rating.getRating());
                }).collect(Collectors.toList());
    }
}
