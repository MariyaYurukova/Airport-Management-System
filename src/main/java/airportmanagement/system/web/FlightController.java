package airportmanagement.system.web;

import airportmanagement.system.domain.entities.Flight;
import airportmanagement.system.domain.models.binding.AddFlightReqModel;
import airportmanagement.system.domain.models.service.AirlineServiceModel;
import airportmanagement.system.domain.models.service.FlightServiceModel;
import airportmanagement.system.domain.models.service.PassengerServiceModel;
import airportmanagement.system.domain.models.service.PlaneServiceModel;
import airportmanagement.system.domain.models.views.*;
import airportmanagement.system.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("flight")
public class FlightController extends BaseController {

    private final FlightService flightService;
    private final ModelMapper modelMapper;
    private final PlaneService planeService;
    private final AirportService airportService;
    private final AirlineService airlineService;
    private final TravelService travelService;
    private final PassengerService passengerService;


    @Autowired
    public FlightController(FlightService flightService, ModelMapper modelMapper, PlaneService planeService, AirportService airportService, AirlineService airlineService, TravelService travelService, PassengerService passengerService) {
        this.flightService = flightService;
        this.modelMapper = modelMapper;
        this.planeService = planeService;
        this.airportService = airportService;
        this.airlineService = airlineService;
        this.travelService = travelService;
        this.passengerService = passengerService;
    }

    @GetMapping("/add")
    public ModelAndView addFlight(@ModelAttribute("model") AddFlightReqModel addFlightReqModel, ModelAndView modelAndView) {


        modelAndView.addObject("model", addFlightReqModel);
        modelAndView.addObject("airline", airlineService.getAllAirlines()
                .stream()
                .map(c -> this.modelMapper.map(c, AirlineServiceModel.class))
                .collect(Collectors.toList()));
        modelAndView.addObject("travel", travelService.findAll()
                .stream()
                .map(t -> this.modelMapper.map(t, TravelViewModel.class))
                .collect(Collectors.toList()));
        modelAndView.addObject("airport", airportService.getAllAirports()
                .stream()
                .map(a -> this.modelMapper.map(a, AirportViewModel.class))
                .collect(Collectors.toList()));
        modelAndView.addObject("plane", planeService.findAllPlanes()
                .stream()
                .map(p -> this.modelMapper.map(p, PlaneViewModel.class))
                .collect(Collectors.toList()));
        return super.view("add-flight", modelAndView);
    }


    @PostMapping("/add")
    public ModelAndView addCOm(@Valid @ModelAttribute(name = "model") AddFlightReqModel addFlightReqModel, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {

            modelAndView.addObject("model", addFlightReqModel);
            modelAndView.addObject("airline", airlineService.getAllAirlines()
                    .stream()
                    .map(c -> this.modelMapper.map(c, AirlineServiceModel.class))
                    .collect(Collectors.toList()));
            modelAndView.addObject("travel", travelService.findAll()
                    .stream()
                    .map(t -> this.modelMapper.map(t, TravelViewModel.class))
                    .collect(Collectors.toList()));
            modelAndView.addObject("airport", airportService.getAllAirports()
                    .stream()
                    .map(a -> this.modelMapper.map(a, AirportViewModel.class))
                    .collect(Collectors.toList()));
            modelAndView.addObject("plane", planeService.findAllPlanes()
                    .stream()
                    .map(p -> this.modelMapper.map(p, PlaneViewModel.class))
                    .collect(Collectors.toList()));
            return super.view("add-flight1", modelAndView);
        }

        FlightServiceModel flightServiceModel = this.modelMapper.map(addFlightReqModel, FlightServiceModel.class);
        flightServiceModel.setOccupied(flightServiceModel.getOccupied());
        try {
            this.flightService.addFlight(flightServiceModel);
        } catch (Exception e) {
            modelAndView.addObject("model", addFlightReqModel);
            modelAndView.addObject("airline", airlineService.getAllAirlines()
                    .stream()
                    .map(c -> this.modelMapper.map(c, AirlineServiceModel.class))
                    .collect(Collectors.toList()));
            modelAndView.addObject("travel", travelService.findAll()
                    .stream()
                    .map(t -> this.modelMapper.map(t, TravelViewModel.class))
                    .collect(Collectors.toList()));
            modelAndView.addObject("airport", airportService.getAllAirports()
                    .stream()
                    .map(a -> this.modelMapper.map(a, AirportViewModel.class))
                    .collect(Collectors.toList()));
            modelAndView.addObject("plane", planeService.findAllPlanes()
                    .stream()
                    .map(p -> this.modelMapper.map(p, PlaneViewModel.class))
                    .collect(Collectors.toList()));

            return super.view("add-flight1", modelAndView);
        }

        PassengerServiceModel passengerServiceModel = this.modelMapper.map(addFlightReqModel, PassengerServiceModel.class);
        passengerServiceModel.setFlight(flightServiceModel.getId());

        this.passengerService.addPassenger(passengerServiceModel);


        return super.view("/details-flight", modelAndView);
    }

    @GetMapping("/all")
    public String all(Model model) {
        List<FlightViewModel> flight = this.flightService.findAllFlight()
                .stream()
                .map(f -> this.modelMapper.map(f, FlightViewModel.class))
                .collect(Collectors.toList());

        model.addAttribute("flight", flight);
        return findPaginated(1, model);
    }


    @GetMapping("/all/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {


        Page<Flight> page = flightService.findPaginated(pageNo, 7);
        //List < Employee > listEmployees = page.getContent();
        List<FlightViewModel> flight = this.flightService.findPaginated(pageNo, 7)
                .stream()
                .map(f -> this.modelMapper.map(f, FlightViewModel.class))
                .collect(Collectors.toList());


        model.addAttribute("flight", flight);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listFlight", flight);


        return ("flights");
    }


    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PlaneServiceModel> getCount(@PathVariable String id) {
        return new ResponseEntity<PlaneServiceModel>(planeService.findPlaneById(id), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> pessengerOBoard(@PathVariable String id) {
        return new ResponseEntity<Object>(flightService.countPassenger(id), HttpStatus.OK);
    }

}
