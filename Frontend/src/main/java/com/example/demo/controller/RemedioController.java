package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RemedioEntity;
import com.example.demo.interfaces.IRemedioService;

@Controller
@RequestMapping("crud/remedio") // http://localhost:9876/crud/remedio/
public class RemedioController {

    @Autowired
    private IRemedioService service;

    // 🔵 LISTAR
    @GetMapping("/")
    public String listarRemedios(Model model) {
        List<RemedioEntity> remedios = service.findAll();
        model.addAttribute("remedios", remedios);
        return "indexremedio";
    }

    // 🔴 ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/crud/remedio/";
    }

    // 🟢 FORM NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("remedio", new RemedioEntity());
        return "remedio-form";
    }

    // 🟢 GUARDAR
    @PostMapping("/guardar")
    public String guardar(RemedioEntity remedio) {
        service.save(remedio);
        return "redirect:/crud/remedio/";
    }

    // 🟡 EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        RemedioEntity remedio = service.findById(id);
        model.addAttribute("remedio", remedio);
        return "remedio-form";
    }
}