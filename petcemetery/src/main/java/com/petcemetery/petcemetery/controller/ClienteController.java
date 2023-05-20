package com.petcemetery.petcemetery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petcemetery.petcemetery.model.Cliente;
import com.petcemetery.petcemetery.repositorio.ClienteRepository;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam("email") String email, @RequestParam("senha") String senha) {
        Cliente cliente = clienteRepository.findByEmailAndSenha(email, senha);
        if (cliente == null) {
            return "redirect:/login";
        } else {
            return "redirect:/home";
        }
    }

    
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }
}
