package com.kaue.crud.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaue.crud.models.entidade.cliente;
import com.kaue.crud.models.repository.clienteRepository;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

@Controller
@RequestMapping("/api")
public class clienteController {

    @Autowired
    private clienteRepository ClienteRepository;

    // Mostrar view do cadastro
    @GetMapping("/view")
    public String create(Model model){
        Iterable<cliente> Clientes = ClienteRepository.findAll();
        model.addAttribute("cliente", Clientes);
        return "create";
    }

    // Cadastrar os clientes
    @PostMapping("/view/cadastrar")
    public String cadastrar(cliente Clientes){
        ClienteRepository.save(Clientes);
        return "redirect:/api/view";
    }

    //Deletar os clientes por id
    @GetMapping("/view/deletar{id}")
    public String deletarCliente(@PathVariable int id){  // Pelo PathVariable ira pegar o id da url e passar para o int id
        ClienteRepository.deleteById(id); // Deletar o cliente pelo id
        return "redirect:/api/view";
    }

    //Mostra a view que ira edirar o cliente
    @GetMapping("/view/alterar{id}")
    public String formAlterar(@PathVariable int id, Model model){
        Optional<cliente> Clientes = ClienteRepository.findById(id);
        model.addAttribute("cliente", Clientes.get());
        return "editar";
    }

    // Alterando cliente no BD
    @PostMapping("/view/editar{id}")
    public String alterar(cliente Cliente){ // Pegando parametro na URL e salvando no objeto Cliente e o @valid e para garantir os parametros da model
        ClienteRepository.save(Cliente);    // Ira salvar o objeto Cliente no BD
        return "redirect:/api/view";
    }

    
    
}
