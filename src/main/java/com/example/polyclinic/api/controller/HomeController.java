package com.example.polyclinic.api.controller;

import com.example.polyclinic.model.Patient;
import com.example.polyclinic.persist.db.postgres.PatientRepository;
import com.example.polyclinic.persist.db.postgres.entity.PatientEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PatientRepository patientRepository;

    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("message", "Открыта главная страница поликлиники");
        return "home";
    }

    @GetMapping("/patient/new")
    public String newPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientForm";
    }

    @PostMapping("/patient/new")
    public String addPatient(@Valid @ModelAttribute Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "patientForm";
        }

        patientRepository.save(new PatientEntity(
                null,
                patient.getFirstName(),
                patient.getLastName(),
                patient.getBirthDate(),
                patient != null ? patient.getPhoneNumber() : null,
                patient != null ? patient.getAddress() : null
        ));
        // сохраните объект patient, например, в базе данных

        return "redirect:/home";
    }
}
