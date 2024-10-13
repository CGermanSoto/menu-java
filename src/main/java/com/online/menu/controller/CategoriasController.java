package com.online.menu.controller;

import com.online.menu.entity.CategoriaEntity;
import com.online.menu.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("categoria")
public class CategoriasController {

    @Autowired
    private ICategoriaService iCategoriaService;

    @PostMapping("/nueva-categoria")
    private void nuevaCategoria(@RequestBody CategoriaEntity categoria){
        this.iCategoriaService.nuevaCategoria(categoria);
    }

    @PutMapping("/modificar-categoria")
    private void modificarCategoria(@RequestBody CategoriaEntity categoria){
        this.iCategoriaService.editarCategoria(categoria);
    }

    @GetMapping("/traer-categorias")
    private List<CategoriaEntity> getAllCategorias(){
        return this.iCategoriaService.getAllCategorias();
    }

    @PostMapping("/eliminar-categoria")
    private void eliminarCategoria(@RequestParam Long id){
        this.iCategoriaService.eliminarCategoria(id);
    }

}
