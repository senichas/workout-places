package ua.com.findcoach.workoutplaces.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.findcoach.workoutplaces.domain.Place;
import ua.com.findcoach.workoutplaces.repository.PlacesRepository;

import java.util.List;

@Service
public class PlacesService {

    @Autowired
    private PlacesRepository placesRepository;

    public List<Place> findAllPlaces() {
        return placesRepository.findAll();
    }

    public List<Place> findPlacesByName(String name) {
        List<Place> places = placesRepository.findPlacesByName(name);
        return places;
    }

}
