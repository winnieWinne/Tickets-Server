package com.awesometickets.business.services;

import com.awesometickets.business.entities.*;
import com.awesometickets.business.entities.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    public MovieService() {
        super();
    }

    /**
     * Return the whole movie entity whose ID equals to @param movieId.
     */
    public Movie getMovieWithAllDetails(Integer movieId) {
        return movieRepo.findOneWithAllDetails(movieId);
    }

    /**
     * Return the list of ID of movie whose status equals to @param status.
     */
    public List<Integer> getMovieByStatus(String status) {
        return movieRepo.findByMovieStatus(status);
    }

    /**
     * Return the list of (ID, URI of large poster) tuple.
     *
     * @param maxCount Maximum size of the result list
     */
    public List<Object[]> getLargePoster(int maxCount) {      
        ArrayList<Object[]> posters = new ArrayList<Object[]>();
        List<Object[]> movies = movieRepo.findLargePoster();
        int num = movies.size();
        int min = (maxCount < num) ? maxCount : num;
        for(int i = 0; i < min; ++i) {
            posters.add(movies.get(i));
        }
        return posters;
    }
}
