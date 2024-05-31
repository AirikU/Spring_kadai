package jp.ac.morijyobi.SpringKadai.service;

import jp.ac.morijyobi.SpringKadai.bean.entity.Training;
import jp.ac.morijyobi.SpringKadai.bean.form.TrainingForm;

import java.util.List;

public interface TrainingService {
    Training registerTraining(TrainingForm trainingForm);

    List<Training> getAllTrainings();

    Training getTrainingById(int id);

    int deleteTrainingById(int id);

    int updateTrainingById(Training training);

    List<Training> getTrainingByKeyword(String keyword);
}
