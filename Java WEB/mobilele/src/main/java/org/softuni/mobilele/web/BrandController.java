package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.service.BrandService;
import org.softuni.mobilele.service.ModelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BrandController {

    private final BrandService brandService;

    private final ModelService modelService;

    public BrandController(BrandService brandService, ModelService modelService) {
        this.brandService = brandService;
        this.modelService = modelService;
    }


    @GetMapping("brands/all")
    public String all(Model model) {

        List<BrandDTO> allBrands = this.brandService.getAllBrands();
        model.addAttribute("allBrands", allBrands);

        return "brands";
    }
}
