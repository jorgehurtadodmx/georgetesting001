package com.george.artifactgeorge.controller;

import com.george.artifactgeorge.entity.Categoria;
import com.george.artifactgeorge.entity.Producto;
import com.george.artifactgeorge.repository.CategoriaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoriaController {

    private CategoriaRepository categoriaRepository;


    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // anotación que mapea las peticiones GET a la URL "/categorias"
    @GetMapping("/categorias") // http://localhost:8080/productos
    public String findAll(Model model) {
        // crear una lista con todos los productos
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);

        return "categoria-list";
    }

    //create form para nueva categoria
    @GetMapping("/categorias/nuevo")
    public String createForm(Model model) {
        model.addAttribute("categoria", new Categoria());


        return "categoria-form";
    }

    @GetMapping("/categorias/{id}/editar")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Categoria> productoOpt = categoriaRepository.findById(id);

        if (productoOpt.isPresent()) {
            model.addAttribute("categoria", productoOpt.get());

        } else {
            model.addAttribute("error", "Categoria no encontrado");
        }

        return "categoria-form";
    }

}