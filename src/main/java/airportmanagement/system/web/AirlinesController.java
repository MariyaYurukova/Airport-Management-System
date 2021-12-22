package airportmanagement.system.web;


import airportmanagement.system.domain.entities.Airline;
import airportmanagement.system.domain.entities.Airport;
import airportmanagement.system.domain.models.views.AirlineViewModel;
import airportmanagement.system.domain.models.views.AirportViewModel;
import airportmanagement.system.service.AirlineService;
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
@RequestMapping("airline")
public class AirlinesController  extends BaseController {

    private final AirlineService airlineService;
    private final ModelMapper modelMapper;


    @Autowired
    public AirlinesController(AirlineService airlineService, ModelMapper modelMapper) {
        this.airlineService = airlineService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/all")
    public String all(Model model) {
        List<AirlineViewModel> airlines = this.airlineService.getAllAirlines()
                .stream()
                .map(e -> this.modelMapper.map(e, AirlineViewModel.class))
                .collect(Collectors.toList());


        model.addAttribute("airline", airlines);
      //  return ("airlines");
        return findPaginated(1, model);

    }


    @GetMapping("/all/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {


        Page<Airline> page = airlineService.findPaginated(pageNo, 7);
        //List < Employee > listEmployees = page.getContent();
        List<AirlineViewModel> airlines = this.airlineService.findPaginated(pageNo,7)
                .stream()
                .map(e -> this.modelMapper.map(e, AirlineViewModel.class))
                .collect(Collectors.toList());



        model.addAttribute("airline", airlines);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listAirlines", airlines);



        return ("airlines");
    }
}