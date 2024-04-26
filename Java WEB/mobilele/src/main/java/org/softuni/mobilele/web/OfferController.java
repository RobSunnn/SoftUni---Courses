package org.softuni.mobilele.web;

import jakarta.validation.Valid;
import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.entity.enums.EngineEnum;
import org.softuni.mobilele.model.entity.enums.TransmissionEnum;
import org.softuni.mobilele.service.BrandService;
import org.softuni.mobilele.service.ModelService;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    private final BrandService brandService;

    private final ModelService modelService;

    public OfferController(OfferService offerService,
                           BrandService brandService,
                           ModelService modelService) {
        this.offerService = offerService;
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @GetMapping("/all")
    public ModelAndView all() {
        return new ModelAndView("offers");
    }


    @GetMapping("/add")
    public String add(Model model) {
        EngineEnum[] engineTypes = EngineEnum.values();
        TransmissionEnum[] transmissionTypes = TransmissionEnum.values();
        List<BrandDTO> allBrands = this.brandService.getAllBrands();

        model.addAttribute("engineTypes", engineTypes);
        model.addAttribute("transmissionTypes", transmissionTypes);
        model.addAttribute("allBrands", allBrands);


        return "offer-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("createOfferDTO")
                      @Valid CreateOfferDTO createOfferDTO,
                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "offer-add";
        }

        this.offerService.createOffer(createOfferDTO);

        return "index";
    }


//    @GetMapping("/{uuid}/details")
//    public ModelAndView details(@PathVariable("uuid") UUID uuid) {
//        return new ModelAndView("details");
//    }

}
