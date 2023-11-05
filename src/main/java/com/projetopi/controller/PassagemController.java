package com.projetopi.controller;

import com.projetopi.entidades.*;
import com.projetopi.services.CidadeService;
import com.projetopi.services.PassagemService;
import com.projetopi.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
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
        List<Passagem> passagemList = passagemService.listAll();
        model.addAttribute("passagemList", passagemList);
        return "passagem";
    }

    @GetMapping("/passagem/new")
    public String showNewForm(Model model) {
        List<Veiculo> veiculos = veiculoService.listAll();
        List<Cidade> cidades = cidadeService.listAll();
        model.addAttribute("passagem", new Passagem());
        model.addAttribute("veiculos", veiculos);
        model.addAttribute("cidades", cidades);
        model.addAttribute("pageTitle", "Cadastrar nova Passagem");
        return "passagem_form";
    }

    @GetMapping("/passagem/available-poltronas")
    @ResponseBody
    public ResponseEntity<List<Integer>> getAvailablePoltronas(@RequestParam("veiculoId") int veiculoId) {
        Veiculo veiculo = null;
        try {
            veiculo = veiculoService.get(veiculoId);
        } catch (VeiculoNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Integer> availablePoltronas = new ArrayList<>();
        for (int i = 1; i <= veiculo.getQtdPoltrnas(); i++) {
            availablePoltronas.add(i);
        }
        return ResponseEntity.ok(availablePoltronas);
    }

    @PostMapping("/passagem/save")
    public String savePassagem(Passagem passagem, RedirectAttributes ra) {
        // Set the foreign keys (veiculo, cidadeOrigem, cidadeDestino) based on passagem's attributes
        passagemService.save(passagem);
        ra.addFlashAttribute("message", "A passagem foi cadastrada com sucesso.");
        return "redirect:/passagem";
    }


    @GetMapping("/passagem/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Passagem passagem = passagemService.get(id);
            model.addAttribute("passagem", passagem);
            model.addAttribute("pageTitle", "Editar passagem (ID: " + id + ")");
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