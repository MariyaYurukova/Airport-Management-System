package airportmanagement.system.web;

import airportmanagement.system.domain.models.binding.AddTravelReqModel;
import airportmanagement.system.domain.models.service.TravelServiceModel;
import airportmanagement.system.domain.models.views.AirportViewModel;
import airportmanagement.system.service.AirportService;
import airportmanagement.system.service.TravelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("travel")
public class TravelController extends BaseController {

    private final TravelService travelService;
    private final ModelMapper modelMapper;
    private final AirportService airportService;

    @Autowired
    public TravelController(TravelService travelService, ModelMapper modelMapper, AirportService airportService) {
        this.travelService = travelService;
        this.modelMapper = modelMapper;
        this.airportService = airportService;
    }

    @GetMapping("/add")
    public ModelAndView addTravel(@ModelAttribute("model") AddTravelReqModel addTravelReqModel, ModelAndView modelAndView) {
        List<AirportViewModel> airports = this.airportService.getAllAirports()
                .stream()
                .map(c -> this.modelMapper.map(c, AirportViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("airport", airports);
        modelAndView.addObject("model", addTravelReqModel);

        return super.view("add-travel", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addCOm(@ModelAttribute(name = "model") AddTravelReqModel addTravelReqModel, BindingResult bindingResult, ModelAndView modelAndView) throws ParseException {
        if(bindingResult.hasErrors()) {

            modelAndView.addObject("model",addTravelReqModel);
            return super.view("add-travel1", modelAndView);
        }



        TravelServiceModel travelServiceModel = this.modelMapper.map(addTravelReqModel, TravelServiceModel.class);
        this.travelService.saveTravel(travelServiceModel);


        return  super.redirect("/");
    }



}
