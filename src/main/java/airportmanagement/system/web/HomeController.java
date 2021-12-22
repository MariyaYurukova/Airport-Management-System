package airportmanagement.system.web;


import airportmanagement.system.domain.entities.Airline;
import airportmanagement.system.domain.entities.Airport;
import airportmanagement.system.domain.models.service.AirlineServiceModel;
import airportmanagement.system.domain.models.service.AirportServiceModel;
import airportmanagement.system.domain.models.service.MyResponse;
import airportmanagement.system.domain.models.views.AirlineViewModel;
import airportmanagement.system.domain.models.views.AirportViewModel;
import airportmanagement.system.service.AirlineService;
import airportmanagement.system.service.AirportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController  extends BaseController {


    private final AirlineService airlineService;
    private final ModelMapper modelMapper;
    private final AirportService airportService;


    @Autowired
    public HomeController(AirlineService airlineService, ModelMapper modelMapper, AirportService airportService) {
        this.airlineService = airlineService;
        this.modelMapper = modelMapper;
        this.airportService = airportService;
    }



    @GetMapping("/")
    public String index(Model model) {
       return ("index");
    }


    @RequestMapping(value = "add-airline", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> addAirline(@RequestBody AirlineServiceModel airlineServiceModel) {
        airlineService.addAirline(airlineServiceModel);
        MyResponse<AirlineServiceModel> response = new MyResponse<>("success", airlineServiceModel);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "add-airport", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> addAirline(@RequestBody AirportServiceModel airportServiceModel) {
        airportService.addAirport(airportServiceModel);
        MyResponse<AirportServiceModel> response = new MyResponse<>("success", airportServiceModel);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }





    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {


        Page<Airline> page = airlineService.findPaginated(pageNo, 3);
        //List < Employee > listEmployees = page.getContent();
        List<AirlineViewModel> airlines = this.airlineService.findPaginated(pageNo,3)
                .stream()
                .map(e -> this.modelMapper.map(e, AirlineViewModel.class))
                .collect(Collectors.toList());


        model.addAttribute("airline", airlines);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listAirlines", airlines);




        return "index";
    }







}