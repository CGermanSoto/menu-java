package com.online.menu.controller;

import com.online.menu.entity.ProductoEntity;
import com.online.menu.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductService iProductService;

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/nuevo-producto")
    public void nuevoProducto(@RequestBody ProductoEntity productoEntity){
        ProductoEntity nuevoProducto = new ProductoEntity();
        nuevoProducto.setNombre(productoEntity.getNombre());
        nuevoProducto.setCategoria(productoEntity.getCategoria());
        nuevoProducto.setDescripcion(productoEntity.getDescripcion());
        nuevoProducto.setImagen(productoEntity.getImagen());
        nuevoProducto.setPrecio(productoEntity.getPrecio());

        this.iProductService.guardarProducto(nuevoProducto);
    }

    @GetMapping("/todos-los-productos")
    public List<ProductoEntity> EditProducto(){
        return this.iProductService.listaProductos();
    }

    @PutMapping("/editar-producto")
    public void editarProducto(@RequestBody ProductoEntity producto){
        this.iProductService.editarProducto(producto);
    }

    @PostMapping("/eliminar-producto")
    public void EliminarProducto(@RequestParam Long idProducto){
        this.iProductService.eliminarProducto(idProducto);
    }

}
