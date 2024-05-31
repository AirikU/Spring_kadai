package jp.ac.morijyobi.SpringKadai.mapper;

import jp.ac.morijyobi.SpringKadai.bean.entity.Training;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TrainingMapper {

    @Insert("INSERT INTO training(title, start_date_time, reserved) VALUES (#{title}, #{startDateTime}, #{reserved})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertTraining(Training training);

    @Select("SELECT * FROM training ORDER BY id")
    List<Training> selectAllTrainings();

    @Select("SELECT * FROM training WHERE id = #{id}")
    Training selectTrainingById(int id);

    @Delete("DELETE FROM training WHERE id = #{id}")
    int deleteTrainingById(int id);

    @Update("UPDATE training SET title = #{title}, " +
            "start_date_time = #{startDateTime}, " +
            "reserved = #{reserved} " +
            "WHERE id = #{id}")
    int updateTrainingById(Training training);

    @Select("SELECT * FROM training WHERE title LIKE CONCAT('%', #{keyword}, '%') ORDER BY id")
    List<Training> selectTrainingByKeyword(String keyword);
}
