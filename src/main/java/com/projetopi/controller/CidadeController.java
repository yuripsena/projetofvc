package com.projetopi.controller;

import com.projetopi.entidades.Cidade;
import com.projetopi.entidades.CidadeNotFoundException;
import com.projetopi.entidades.UserNotFoundException;
import com.projetopi.services.CidadeService;
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
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping("/cidade")
    public String showCidadeList(Model model) {
        List<Cidade> listCidade = service.listAll();
        model.addAttribute("listCidade", listCidade);

        return "cidade";
    }

    @GetMapping("/cidade/new")
    public String showNewForm(Model model) {
        model.addAttribute("cidade", new Cidade());
        model.addAttribute("pageTitle", "Cadastrar nova Cidade");
        return "cidade_form";
    }

    @PostMapping("/cidade/save")
    public String saveCidade(Cidade cidade, RedirectAttributes ra) {
        service.save(cidade);
        ra.addFlashAttribute("message", "A cidade foi cadastrada.");
        return "redirect:/cidade";
    }

    @GetMapping("/cidade/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Cidade cidade = service.get(id);
            model.addAttribute("cidade", cidade);
            model.addAttribute("pageTitle", "Editar cidade (ID: " + id + ")");
            return "cidade_form";
        } catch (CidadeNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/cidade";
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/cidade/delete/{id}")
    public String deleteCidade(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "A cidade com ID " + id + " foi deletado");
        } catch (CidadeNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/cidade";
    }

    @PostMapping("/cidade/search")
    public String searchNomeCidadeByName(@RequestParam("searchNomeCidade") String searchNomeCidade, Model model) {
        List<Cidade> searchResult = service.searchByNomeCidade(searchNomeCidade);
        model.addAttribute("listCidade", searchResult);
        return "cidade";
    }

}
