package com.example.accnummvc.controller;


import com.example.accnummvc.entity.LabId;
import com.example.accnummvc.repository.LabIdRepository;
import com.example.accnummvc.service.LabIdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Controller
public class LabIdController {

    private final LabIdService labIdService;
    private final LabIdRepository labIdRepository;

    public LabIdController(LabIdService labIdService, LabIdRepository labIdRepository) {
        this.labIdService = labIdService;
        this.labIdRepository = labIdRepository;
    }

    @GetMapping("/sampleacc")
    public String saveAcc(@ModelAttribute("LabId") LabId labId,Model model) {
        labIdService.saveAcc(labId);
        System.out.println(labId);

        model.addAttribute("lastlabId", labId);
        System.out.println(labId);
        return "acc";
    }


}

