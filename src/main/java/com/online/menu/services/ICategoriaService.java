package com.online.menu.services;

import com.online.menu.entity.CategoriaEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICategoriaService {
    @Transactional
    void nuevaCategoria(CategoriaEntity categoria);
    @Transactional
    void editarCategoria(CategoriaEntity categoria);
    @Transactional
    void eliminarCategoria(Long id);
    @Transactional
    List<CategoriaEntity> getAllCategorias();
}
