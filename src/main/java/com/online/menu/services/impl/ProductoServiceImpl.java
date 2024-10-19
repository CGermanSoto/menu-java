package com.online.menu.services.impl;

import com.online.menu.entity.ProductoEntity;
import com.online.menu.repository.IProductDAOHbn;
import com.online.menu.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductService {

    @Autowired
    private IProductDAOHbn iProductoDaoHbn;

    @Override
    public void guardarProducto(ProductoEntity producto) {
        this.iProductoDaoHbn.save(producto);
    }

    @Override
    public List<ProductoEntity> listaProductos(){
        return this.iProductoDaoHbn.findAll();
    }

    @Override
    public void editarProducto(ProductoEntity producto) {
//        ProductoEntity productoEditable = this.iProductoDaoHbn.findById(producto.getProductoId())
//                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
//        if(productoEditable == null){
//            productoEditable = producto;
//        }
        this.iProductoDaoHbn.save(producto);
    }


    @Override
    public void eliminarProducto(Long id) {
        this.iProductoDaoHbn.deleteById(id);
    }
}
