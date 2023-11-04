package com.projetopi.controller;

import com.projetopi.entidades.Veiculo;
import com.projetopi.entidades.VeiculoNotFoundException;
import com.projetopi.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping("/veiculo")
    public String showVeiculoList(Model model) {
        List<Veiculo> listVeiculo = service.listAll();
        model.addAttribute("listVeiculos",listVeiculo);

        return "veiculo";
    }

    @GetMapping("/veiculo/new")
    public String showNewForm(Model model) {
        model.addAttribute("veiculo", new Veiculo());
        model.addAttribute("pageTitle", "Cadastrar novo veiculo");
        return "veiculo_form";
    }

    @PostMapping("/veiculo/save")
    public String saveVeiculo(Veiculo veiculo, RedirectAttributes ra) {
        service.save(veiculo);
        ra.addFlashAttribute("messagee", "O veiculo foi cadastrado com sucesso.");
        return "redirect:/veiculo";
    }

    @GetMapping("/veiculo/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Veiculo veiculo = service.get(id);
            model.addAttribute("veiculo", veiculo);
            model.addAttribute("pageTitle", "Editar usuário (ID: " + id + ")");
            return "veiculo_form";
        } catch (VeiculoNotFoundException e) {
            ra.addFlashAttribute("messagee", e.getMessage());
            return "redirect:/veiculo";
        }
    }

    @GetMapping("/veiculo/delete/{id}")
    public String deleteVeiculo(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("messagee", "O veiculo com ID " + id + " foi deletado");
        } catch (VeiculoNotFoundException e) {
            ra.addFlashAttribute("messagee", e.getMessage());
        }
        return "redirect:/veiculo";
    }

    @PostMapping("/veiculo/search")
    public String searchVeiculoByNumero(@RequestParam("searchNumero") String searchNumero, Model model) {
        List<Veiculo> searchResult = service.searchByNumero(searchNumero);
        model.addAttribute("listVeiculo", searchResult);
        return "veiculo";
    }

}
