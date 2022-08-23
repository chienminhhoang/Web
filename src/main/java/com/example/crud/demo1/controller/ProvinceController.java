package com.example.crud.demo1.controller;

import com.example.crud.demo1.model.Country;
import com.example.crud.demo1.model.Province;
import com.example.crud.demo1.service.ICountryService;
import com.example.crud.demo1.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private ICountryService countryService;
    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public List<Province> studentList() {
        return provinceService.findAll();
    }

    @ModelAttribute("country")
    public List<Country> classesList() {
        return countryService.findAll();
    }

    @GetMapping
    public ModelAndView findAllProvince() {

        return new ModelAndView("display");
    }

    @GetMapping("/create")
    public ModelAndView createProvince() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("province", new Province());
        return modelAndView;

    }

    @PostMapping("/create")
    public String create(@ModelAttribute("province") Optional<Province> province, RedirectAttributes redirectAttributes) {
        setImageOfProvince(province.get());
        MultipartFile multipartFile =
        if (province.isPresent()) {
            provinceService.save(province.get());

        } else {
            redirectAttributes.addFlashAttribute("message", "create fail, create again");
        }
        redirectAttributes.addFlashAttribute("message", "create successfully!!!");
        return "redirect:/province";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateProvince(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("update");
        Optional<Province> province = provinceService.findById(id);

        if (province.isPresent()) {
            modelAndView.addObject("province", province.get());
        } else {

            modelAndView.addObject("message", "Not exist province!");
        }
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("province") Optional<Province> province, RedirectAttributes redirectAttributes) {
        if (province.isPresent()) {
            provinceService.save(province.get());
            if (province.get().getImage() == null) {
                province.get().setImage(province.get().getImage());
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "update fail!!");
        }
        redirectAttributes.addFlashAttribute("message", "update successfully");
        return "redirect:/province";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

        provinceService.delete(id);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/province";
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam("search") Optional<String> name) {
        ModelAndView modelAndView = new ModelAndView("display");
        if (name.isPresent()) {
            List<Province> provinces = provinceService.findBySearch(name.get());
            modelAndView.addObject("provinces", provinces);
        }
        return modelAndView;
    }


    private void setImageOfProvince(Province province) {
        MultipartFile image = province.getImage();
        String imageUrl = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(), new File(fileUpload + image.getOriginalFilename()));
        } catch (IOException ex) {
            System.err.println("Error");
        }
        province.setImageUrl(imageUrl);
    }
}
