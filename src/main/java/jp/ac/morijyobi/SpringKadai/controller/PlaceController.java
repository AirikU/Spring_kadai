package jp.ac.morijyobi.SpringKadai.controller;

import jp.ac.morijyobi.SpringKadai.bean.entity.Place;
import jp.ac.morijyobi.SpringKadai.bean.entity.Place;
import jp.ac.morijyobi.SpringKadai.bean.form.PlaceForm;
import jp.ac.morijyobi.SpringKadai.bean.form.PlaceForm;
import jp.ac.morijyobi.SpringKadai.service.PlaceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/place")
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/register")
    public String register() {
        return "place/register";
    }

    @PostMapping("/register")
    public String registerExe(@RequestParam String placeName,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime firstVisitDateTime,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime lastVisitDateTime,
                              @RequestParam String situation,
                              Model model) {

        // DBにINSERTする処理を呼び出す
        PlaceForm place = new PlaceForm(placeName, firstVisitDateTime, lastVisitDateTime, situation);
        Place placeEntity = placeService.registerPlace(place);
        System.out.println(placeEntity.getId());

        return "redirect:/place/list";

    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Place> placeList = placeService.getAllPlaces();
        model.addAttribute("placeList", placeList);

        return "place/list";
    }

    @GetMapping("/display-details")
    public String displayDetails(@RequestParam int placeId, Model model) {
        Place place = placeService.getPlaceById(placeId);
        model.addAttribute("place", place);

        return "place/details";
    }

    @GetMapping("/confirm-delete")
    public String confirmDelete(@RequestParam int placeId, Model model) {
        Place place = placeService.getPlaceById(placeId);
        model.addAttribute("place", place);

        return "place/delete";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int placeId, Model model) {
        int result = placeService.deletePlaceById(placeId);
        if (result > 0) {
            return "place/delete-success";
        } else {
            return "place/delete-failed";
        }
    }

    @GetMapping("/confirm-edit")
    public String confirmEdit(@RequestParam int placeId, Model model) {
        Place place = placeService.getPlaceById(placeId);
        model.addAttribute("place", place);

        return "place/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Place place, Model model) {
        int result = placeService.updatePlaceById(place);
        if (result > 0) {
            return "place/edit-success";
        } else {
            return "place/edit-failed";
        }
    }

    @GetMapping("/search")
    public String searchPlace(@RequestParam String keyword, Model model) {
        List<Place> placeList = placeService.getPlaceByKeyword(keyword);
        model.addAttribute("placeList", placeList);

        return "place/list";
    }
}
    
    