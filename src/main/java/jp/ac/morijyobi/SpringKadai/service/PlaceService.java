package jp.ac.morijyobi.SpringKadai.service;

import jp.ac.morijyobi.SpringKadai.bean.entity.Place;
import jp.ac.morijyobi.SpringKadai.bean.form.PlaceForm;

import java.util.List;

public interface PlaceService {
    Place registerPlace(PlaceForm placeForm);

    List<Place> getAllPlaces();

    Place getPlaceById(int id);

    int deletePlaceById(int id);

    int updatePlaceById(Place place);

    List<Place> getPlaceByKeyword(String keyword);
}
