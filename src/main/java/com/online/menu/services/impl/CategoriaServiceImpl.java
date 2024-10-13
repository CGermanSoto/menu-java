package com.online.menu.services.impl;

import com.online.menu.entity.CategoriaEntity;
import com.online.menu.entity.ProductoEntity;
import com.online.menu.repository.ICategoriaDAOHbn;
import com.online.menu.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private ICategoriaDAOHbn iCategoriaDAOHbn;

    @Override
    public void nuevaCategoria(CategoriaEntity categoria) {
        this.iCategoriaDAOHbn.save(categoria);
    }

    @Override
    public void editarCategoria(CategoriaEntity categoria) {
        Long id = categoria.getCategoriaId();
        CategoriaEntity categoriaEditable = this.iCategoriaDAOHbn.findById(categoria.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        categoriaEditable.setCategoria(categoria.getCategoria());
        this.iCategoriaDAOHbn.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        this.iCategoriaDAOHbn.deleteById(id);
    }

    @Override
    public List<CategoriaEntity> getAllCategorias() {
        return this.iCategoriaDAOHbn.findAll();
    }
}
