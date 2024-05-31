package jp.ac.morijyobi.SpringKadai.controller;

import jp.ac.morijyobi.SpringKadai.bean.entity.Training;
import jp.ac.morijyobi.SpringKadai.service.TrainingService;
import org.springframework.ui.Model;
import jp.ac.morijyobi.SpringKadai.bean.form.TrainingForm;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/training")
public class TrainingController {
    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("/register")
    public String register() {
        return "training/register";
    }

    @PostMapping("/register")
    public String registerExe(@RequestParam String title,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
                              @RequestParam int reserved,
                              Model model) {

        // DBにINSERTする処理を呼び出す
        TrainingForm training = new TrainingForm(title, startDateTime, reserved);
        Training trainingEntity = trainingService.registerTraining(training);
        System.out.println(trainingEntity.getId());

        return "redirect:/training/list";

    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Training> trainingList = trainingService.getAllTrainings();
        model.addAttribute("trainingList", trainingList);

        return "training/list";
    }

    @GetMapping("/display-details")
    public String displayDetails(@RequestParam int trainingId, Model model) {
        Training training = trainingService.getTrainingById(trainingId);
        model.addAttribute("training", training);

        return "training/details";
    }

    @GetMapping("/confirm-delete")
    public String confirmDelete(@RequestParam int trainingId, Model model) {
        Training training = trainingService.getTrainingById(trainingId);
        model.addAttribute("training", training);

        return "training/confirm-delete";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int trainingId, Model model) {
        int result = trainingService.deleteTrainingById(trainingId);
        if (result > 0) {
            return "training/delete-success";
        } else {
            return "training/delete-failed";
        }
    }

    @GetMapping("/confirm-edit")
    public String confirmEdit(@RequestParam int trainingId, Model model) {
        Training training = trainingService.getTrainingById(trainingId);
        model.addAttribute("training", training);

        return "training/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Training training, Model model) {
        int result = trainingService.updateTrainingById(training);
        if (result > 0) {
            return "training/edit-success";
        } else {
            return "training/edit-failed";
        }
    }

    @GetMapping("/search")
    public String searchTraining(@RequestParam String keyword, Model model) {
        List<Training> trainingList = trainingService.getTrainingByKeyword(keyword);
        model.addAttribute("trainingList", trainingList);

        return "training/list";
    }
}
