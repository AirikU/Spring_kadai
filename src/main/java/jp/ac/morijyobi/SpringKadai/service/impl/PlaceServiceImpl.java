package jp.ac.morijyobi.SpringKadai.service.impl;

import jp.ac.morijyobi.SpringKadai.bean.entity.Place;
import jp.ac.morijyobi.SpringKadai.bean.form.PlaceForm;
import jp.ac.morijyobi.SpringKadai.mapper.PlaceMapper;
import jp.ac.morijyobi.SpringKadai.service.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceMapper placeMapper;
    
    public PlaceServiceImpl(PlaceMapper placeMapper) {
        this.placeMapper = placeMapper;
    }

    @Override
    public Place registerPlace(PlaceForm placeForm) {
        Place place = new Place(
                -1,
                placeForm.getPlaceName(),
                placeForm.getFirstVisitDateTime(),
                placeForm.getLastVisitDateTime(),
                placeForm.getSituation()
        );

        placeMapper.insertPlace(place);

        return place;
    }

    @Override
    public List<Place> getAllPlaces() {
        return placeMapper.selectAllPlaces();
    }

    @Override
    public Place getPlaceById(int id) {
        return placeMapper.selectPlaceById(id);
    }

    @Override
    public int deletePlaceById(int id) {
        return placeMapper.deletePlaceById(id);
    }

    @Override
    public int updatePlaceById(Place place) {
        return placeMapper.updatePlaceById(place);
    }

    @Override
    public List<Place> getPlaceByKeyword(String keyword) {
        return placeMapper.selectPlaceByKeyword(keyword);
    }
}
