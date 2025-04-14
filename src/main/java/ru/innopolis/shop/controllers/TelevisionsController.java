package ru.innopolis.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.shop.services.CustomersService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/customers")
public class CustomersController {

    private final CustomersService customersService;

    @GetMapping
    public String getStudentsPage(Model model) {
        model.addAttribute("customers", customersService.getAll());
        return "customers";
    }
}
