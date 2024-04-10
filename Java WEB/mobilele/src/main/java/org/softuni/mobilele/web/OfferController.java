package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    public ModelAndView all() {
        return new ModelAndView("offers");
    }


    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("offer-add");
    }

    @PostMapping("/add")
    public ModelAndView add(CreateOfferDTO createOfferDTO) {
        offerService.createOffer(createOfferDTO);
        return new ModelAndView("index");
    }


    @GetMapping("/{uuid}/details")
    public ModelAndView details(@PathVariable("uuid") UUID uuid) {
        return new ModelAndView("details");
    }

}
