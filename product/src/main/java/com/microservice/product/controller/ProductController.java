package com.microservice.product.controller;

import com.microservice.product.dto.OrderDetailDTO;
import com.microservice.product.entity.Product;
import com.microservice.product.repository.CategoryRepository;
import com.microservice.product.repository.ProductRepository;
import com.microservice.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/product")
//@CrossOrigin(value = "**")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<?> addProducts(@Valid @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editProducts(@RequestBody Product product, @PathVariable(value = "id") Integer id){
        Optional<Product> productOptional =productService.byId(id);
        if (productOptional.isPresent()){
            Product productBD = productOptional.get();
            productBD.setName(product.getName());
            productBD.setDescription(product.getDescription());
            productBD.setStock(product.getStock());
            productBD.setPvp(product.getPvp());
            productBD.setPvd(product.getPvd());
            productBD.setImage(product.getImage());
            productBD.setBrand(product.getBrand());
            productBD.setWeight(product.getWeight());
            productBD.setSize(product.getSize());
            productBD.setPorcentajeDescuento(product.getPorcentajeDescuento());
            productBD.setExpiration((product.getExpiration()));
            productBD.setCategory(product.getCategory());

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.saveProduct(productBD));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> deleteProduct(@RequestParam(value = "id") Integer id){
        Optional<Product> optionalProduct = productService.byId(id);
        if (optionalProduct.isPresent()){
            productService.deletePoduct(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/reduce/stock")
    public ResponseEntity<?> reduceStockofProduct(@RequestBody List<OrderDetailDTO> orderDetailDTO){
        productService.updateStock(orderDetailDTO);
        return ResponseEntity.ok().body("Update Stock");
    }

    @PostMapping("/plus/stock")
    public ResponseEntity<?> plusStockofProduct(@RequestBody List<OrderDetailDTO> orderDetailDTO){
        productService.updateStockPlus(orderDetailDTO);
        return ResponseEntity.ok().body("Update Stock");
    }

/* en caso que optemos por usar excepciones personalizadas

    @DeleteMapping("/private/sucursal/{sucursalId}")
    public ResponseEntity<?> eliminarSucursal(@PathVariable Integer sucursalId){
        return sucursalRepo.findById(sucursalId).map(sucursal -> {
            sucursalRepo.delete(sucursal);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Sucursal con el ID : " + sucursalId + " no encontrada"));
    }
*/
}
