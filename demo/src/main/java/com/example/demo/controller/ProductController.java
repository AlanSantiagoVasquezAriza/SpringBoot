package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "api/products")

public class ProductController {

    @Autowired
    private ProductService productService;


    // Ver todos los productos
    @GetMapping("/")
    public ModelAndView getAll(){
        List<Product> products = productService.getProducts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("products"); // nombre de tu archivo html
        return modelAndView;
    }


    // Crear un producto
    @PostMapping("/post")
    public String saveProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Integer price,
            @RequestParam("imageUrl") String imageUrl
    ){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);
        productService.savePoduct(product);

        // Redirige a la página 'success' después de guardar el producto
        return "redirect:/success";
    }


    // Editar un producto
    @PostMapping("/update")
    public String updateProduct(
            @RequestParam("id") int productId,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Integer price,
            @RequestParam("imageUrl") String imageUrl
    ){
        // Buscar el producto por su ID
        Optional<Product> optionalProduct = productService.getProductById(productId);

        if(optionalProduct.isPresent()){
            // Actualizar los campos del producto con los datos del formulario
            Product product = optionalProduct.get();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setImageUrl(imageUrl);

            // Guardar el producto actualizado
            productService.savePoduct(product);

            return "redirect:/success";
        } else {
            return "redirect:/nofound";
        }
    }


    // Eliminar un producto
    @PostMapping("/delete")
    public String updateProduct(
            @RequestParam("id") int productId
    ){
        // Buscar el producto por su ID
        Optional<Product> optionalProduct = productService.getProductById(productId);

        if(optionalProduct.isPresent()){
            // Eliminar el producto
            productService.deleteProductById(productId);

            return "redirect:/success";
        } else {
            return "redirect:/nofound";
        }
    }
}