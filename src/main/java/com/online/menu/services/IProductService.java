package com.online.menu.services;

import com.online.menu.entity.ProductoEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProductService {

    @Transactional
    void guardarProducto(ProductoEntity producto);

    @Transactional
    List<ProductoEntity> listaProductos();

    @Transactional
    void editarProducto(ProductoEntity producto);

    @Transactional
    void eliminarProducto(Long id);
}
