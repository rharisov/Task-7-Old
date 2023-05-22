package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(value = "/cars")
    public String getAllCars(ModelMap model) {
        model.addAttribute("cars", carService.getCars());
        return "cars";
    }

    @GetMapping(value = "/cars", params = "count")
    public String getNumberCars(@RequestParam int count, ModelMap model) {
        model.addAttribute("cars", carService.getNumCars(count));
        return "cars";
    }
}
