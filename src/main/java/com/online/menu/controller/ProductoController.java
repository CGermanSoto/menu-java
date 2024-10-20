package com.online.menu.controller;

import com.online.menu.entity.ProductoEntity;
import com.online.menu.services.IProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class ProductoController {

    private final Logger logger = Logger.getLogger(ProductoController.class.getName());

    @Autowired
    private IProductService iProductService;

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/nuevo-producto")
    public void nuevoProducto(@RequestBody ProductoEntity productoEntity) {
        if (productoEntity.getImagenBase64() == null || productoEntity.getImagenBase64().isEmpty()) {
            logger.info("Error en servicio rest nuevoProducto: Imagen no proporcionada");
            throw new RuntimeException("ImagenBase64 no proporcionada");
        }

        try {
            byte[] imagenBytes = Base64.getDecoder().decode(productoEntity.getImagenBase64());
            productoEntity.setImagen(imagenBytes);
            iProductService.guardarProducto(productoEntity);
        } catch (IllegalArgumentException e) {
            logger.info("Error en servicio rest nuevoProducto: " + e);
            throw new RuntimeException("Error al decodificar la imagen", e);
        }
    }

    @GetMapping("/todos-los-productos")
    public ResponseEntity<List<ProductoEntity>> getAllProducts() {
        try {
            List<ProductoEntity> productos = iProductService.listaProductos();

            // Convertir los bytes de la imagen a Base64 para cada producto antes de enviarlo al frontend
            for (ProductoEntity producto : productos) {
                if (producto.getImagen() != null) {
                    String imagenBase64 = Base64.getEncoder().encodeToString(producto.getImagen());
                    producto.setImagenBase64(imagenBase64);
                }
            }

            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            logger.info("Error en servicio rest/getAllProducts: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
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
