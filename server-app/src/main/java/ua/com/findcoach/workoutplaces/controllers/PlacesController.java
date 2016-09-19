package ua.com.findcoach.workoutplaces.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.findcoach.workoutplaces.api.PlaceDto;
import ua.com.findcoach.workoutplaces.converters.PlacesConverterService;
import ua.com.findcoach.workoutplaces.domain.Place;
import ua.com.findcoach.workoutplaces.services.PlacesService;

import java.util.List;

@Controller
@RequestMapping("/places")
public class PlacesController {

    @Autowired
    private PlacesService placesService;

    @Autowired
    private PlacesConverterService placesConverterService;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<PlaceDto> loadPlaces(@RequestParam(value="name", required=false) String name) {
        List<Place> places;
        if (name != null){
            places = placesService.findPlacesByName(name);
        }
        else {
            places = placesService.findAllPlaces();
        }

        return placesConverterService.convertPlacesToDtos(places);
    }

}
