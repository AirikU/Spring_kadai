package jp.ac.morijyobi.SpringKadai.mapper;

import jp.ac.morijyobi.SpringKadai.bean.entity.Place;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlaceMapper {
    @Insert("INSERT INTO place(place_name, first_visit_date_time, last_visit_date_time, situation) VALUES (#{placeName}, #{firstVisitDateTime}, #{lastVisitDateTime}, ${situation})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertPlace(Place place);

    @Select("SELECT * FROM place ORDER BY id")
    List<Place> selectAllPlaces();

    @Select("SELECT * FROM place WHERE id = #{id}")
    Place selectPlaceById(int id);

    @Delete("DELETE FROM place WHERE id = #{id}")
    int deletePlaceById(int id);

    @Update("UPDATE place SET place_name = #{palceName}, " +
            "first_visit_date_time = #{firstVisitDateTime}, " +
            "last_visit_date_time = #{lastVisitDateTime}, " +
            "situation = #{situation}, " +
            "WHERE id = #{id}")
    int updatePlaceById(Place place);

    @Select("SELECT * FROM place WHERE place_name LIKE CONCAT('%', #{keyword}, '%') ORDER BY id")
    List<Place> selectPlaceByKeyword(String keyword);
}
