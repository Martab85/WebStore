package com.packt.webstore.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.taglibs.standard.lang.jstl.StringLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.packt.webstore.domain.Product;

import javax.jws.WebParam;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public String allProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model){
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded) {
        productService.addProduct(productToBeAdded);
        return "redirect:/products";
    }

}
