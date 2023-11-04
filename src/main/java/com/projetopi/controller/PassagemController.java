package com.projetopi.controller;

import com.projetopi.entidades.Passagem;
import com.projetopi.entidades.PassagemNotFoundException;
import com.projetopi.services.CidadeService;
import com.projetopi.services.PassagemService;
import com.projetopi.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PassagemController {

    @Autowired
    private PassagemService passagemService;

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/passagem")
    public String showPassagemList(Model model) {
        List<Passagem> passagens = passagemService.listAll();
        model.addAttribute("passagens", passagens);

        return "passagem";
    }

    @GetMapping("/passagem/new")
    public String showNewForm(Model model) {
        model.addAttribute("passagem", new Passagem());
        model.addAttribute("veiculos", veiculoService.listAll());
        model.addAttribute("cidades", cidadeService.listAll());

        return "passagem_form";
    }

    @PostMapping("/passagem/save")
    public String savePassagem(Passagem passagem, RedirectAttributes ra) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = sdf.format(passagem.getDataSaida());
        try {
            Date parsedDate = sdf.parse(formattedDate);
            passagem.setDataSaida(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        passagem.decrementPoltrona();
        passagemService.save(passagem);
        ra.addFlashAttribute("message", "A passagem foi cadastrada com sucesso.");
        return "redirect:/passagem"; }


    @GetMapping("/passagem/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Passagem passagem = passagemService.get(id);
            model.addAttribute("passagem", passagem);
            model.addAttribute("veiculos", veiculoService.listAll());
            model.addAttribute("cidades", cidadeService.listAll());

            return "passagem_form";
        } catch (PassagemNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/passagem";
        }
    }

    @GetMapping("/passagem/delete/{id}")
    public String deletePassagem(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            passagemService.delete(id);
            ra.addFlashAttribute("message", "A passagem com ID " + id + " foi deletada");
        } catch (PassagemNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/passagem";
    }



}