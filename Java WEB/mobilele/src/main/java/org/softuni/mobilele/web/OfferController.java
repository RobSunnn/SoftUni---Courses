package org.softuni.mobilele.web;

import jakarta.validation.Valid;
import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.dto.ModelsDTO;
import org.softuni.mobilele.model.entity.enums.EngineEnum;
import org.softuni.mobilele.model.entity.enums.TransmissionEnum;
import org.softuni.mobilele.service.BrandService;
import org.softuni.mobilele.service.ModelService;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        if (!model.containsAttribute("createOfferDTO")) {
            model.addAttribute("createOfferDTO", CreateOfferDTO.empty());
        }

        List<BrandDTO> allBrands = this.brandService.getAllBrands();

        model.addAttribute("allBrands", allBrands);

        return "offer-add";
    }

    @PostMapping("/add")
    public ModelAndView add(
            @Valid CreateOfferDTO createOfferDTO,
            BindingResult bindingResult,
            RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("createOfferDTO", createOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return new ModelAndView("redirect:/offers/add");
        }


        UUID newOfferUUID = offerService.createOffer(createOfferDTO);

        return new ModelAndView("redirect:/offers/" + newOfferUUID);
    }


    @GetMapping("/{uuid}")
    public String details(@PathVariable("uuid") UUID uuid) {
        return "details";
    }

}
