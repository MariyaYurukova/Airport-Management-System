package airportmanagement.system.web;


import airportmanagement.system.domain.entities.Airport;
import airportmanagement.system.domain.models.views.AirportViewModel;
import airportmanagement.system.service.AirportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("airport")
public class AirportController extends BaseController {

    private final AirportService airportService;
    private final ModelMapper modelMapper;

    @Autowired
    public AirportController(AirportService airportService, ModelMapper modelMapper) {
        this.airportService = airportService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/all")
    public String all(Model model) {
        List<AirportViewModel> airports = this.airportService.getAllAirports()
                .stream()
                .map(c -> this.modelMapper.map(c, AirportViewModel.class))
                .collect(Collectors.toList());

        model.addAttribute("airport", airports);
        return findPaginated(1, model);
    }

    @GetMapping("/all/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {

        Page<Airport> page = airportService.findPaginated(pageNo, 7);
        //List < Employee > listEmployees = page.getContent();
        List<AirportViewModel> airports = this.airportService.findPaginated(pageNo, 7)
                .stream()
                .map(e -> this.modelMapper.map(e, AirportViewModel.class))
                .collect(Collectors.toList());


        model.addAttribute("airport", airports);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listAirports", airports);


        return ("airports");
    }
}