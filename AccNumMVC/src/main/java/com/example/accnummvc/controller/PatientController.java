package com.example.accnummvc.controller;

import com.example.accnummvc.entity.Patient;
import com.example.accnummvc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
//    @GetMapping("/")
//    public String viewHomePage(Model model) {
//        model.addAttribute("listpatient", patientService.getAll());
//        return "home";
//    }
    @PostMapping("/savesampleacc")
    public String savesampleacc(@ModelAttribute("patient") Patient patient) {
        patientService.savesampleacc(patient);
        return "redirect:/sampleacc";
    }
}
