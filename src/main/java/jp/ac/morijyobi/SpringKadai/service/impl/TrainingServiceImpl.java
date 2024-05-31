package jp.ac.morijyobi.SpringKadai.service.impl;

import jp.ac.morijyobi.SpringKadai.bean.entity.Training;
import jp.ac.morijyobi.SpringKadai.bean.form.TrainingForm;
import jp.ac.morijyobi.SpringKadai.mapper.TrainingMapper;
import jp.ac.morijyobi.SpringKadai.service.TrainingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {
    private final TrainingMapper trainingMapper;

    public TrainingServiceImpl(TrainingMapper trainingMapper) {
        this.trainingMapper = trainingMapper;
    }

    @Override
    public Training registerTraining(TrainingForm trainingForm) {
        Training training = new Training(
                -1,
                trainingForm.getTitle(),
                trainingForm.getStartDateTime(),
                trainingForm.getReserved()
        );

        trainingMapper.insertTraining(training);

        return training;
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingMapper.selectAllTrainings();
    }

    @Override
    public Training getTrainingById(int id) {
        return trainingMapper.selectTrainingById(id);
    }

    @Override
    public int deleteTrainingById(int id) {
        return trainingMapper.deleteTrainingById(id);
    }

    @Override
    public int updateTrainingById(Training training) {
        return trainingMapper.updateTrainingById(training);
    }

    @Override
    public List<Training> getTrainingByKeyword(String keyword) {
        return trainingMapper.selectTrainingByKeyword(keyword);
    }
}

