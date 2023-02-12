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
@RequestMapping("/api/product")
@CrossOrigin(value = "*")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    public List<Product> allProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> productIdInformation(@PathVariable(value = "id") Integer id){
        Optional<Product> productOptional = productService.byId(id);
        if (productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/filter/{name}")
    public ResponseEntity<?> listProductsByName(@PathVariable(value = "name") String name){
        List<Product> productOptional = productRepository.findByNameContains(name);
        if (productOptional.isEmpty()){
            return ResponseEntity.ok("No existen coincidencias");
        }
        return ResponseEntity.ok(productOptional);
        //productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> productsByCategory(@PathVariable(value = "id") Integer id){
        List<Product> productOptional = productRepository.findByCategoryId(id);
        if (!categoryRepository.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe la categoría");
        }
        if (productOptional.isEmpty()){
            return ResponseEntity.ok("No existen productos asiciados a esa categoria");
        }
        return ResponseEntity.ok(productOptional);
    }

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
            productBD.setPromotion(product.getPromotion());

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

        return ResponseEntity.ok().body("oa");
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
