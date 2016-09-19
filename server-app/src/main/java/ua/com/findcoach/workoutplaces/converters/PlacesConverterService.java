package ua.com.findcoach.workoutplaces.converters;

import org.springframework.stereotype.Service;
import ua.com.findcoach.workoutplaces.api.PlaceDto;
import ua.com.findcoach.workoutplaces.domain.Place;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlacesConverterService {

    public PlaceDto convertPlaceToDto(Place place) {
        PlaceDto dto = new PlaceDto();
        dto.setId(place.getId());
        dto.setName(place.getName());
        dto.setCity(place.getCity());
        dto.setAlias(place.getAlias());
        dto.setCountry(place.getCountry());
        dto.setPhone(place.getPhone());
        dto.setDescription(place.getDescription());
        dto.setAddress(place.getAddress());

        return dto;
    }

    public List<PlaceDto> convertPlacesToDtos(List<Place> places) {
        return places.stream().map(place -> convertPlaceToDto(place)).collect(Collectors.toList());
    }
}
