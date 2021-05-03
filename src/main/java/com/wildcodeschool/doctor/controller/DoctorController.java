package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable String number) {
        
        if (number.equals("13")) {
            return new Doctor(13, "Jodie Whittaker");
        }
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (Exception e) {
            num = 0;
        }
        if (num > 0 && num < 13) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation {"+number+"}");

    }
}
