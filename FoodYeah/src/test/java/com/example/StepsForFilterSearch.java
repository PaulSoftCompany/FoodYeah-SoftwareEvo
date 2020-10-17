package com.example;

import com.example.entity.OrderDetail;
import com.example.entity.Product;
import com.example.entity.ProductCategory;
import com.example.service.ProductCategoryService;
import com.example.service.ProductService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StepsForFilterSearch extends SpringIntegrationTest{

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService categoryService;
    private Product product;
    private Product product2;
    private Product product3;
    private ProductCategory productCategory;
    private List<Product> productList;

    void GenerarDatos() {

        ///////////////////////////////////////////////
        productCategory = new ProductCategory();
        productCategory.setProductCategoryName("Category");
        productCategory.setProductCategoryDescription("test");
        categoryService.createProduct_Category(productCategory);
        /////////////////////////////////////////////////
        product = new Product();
        product.setProductName("Product1");
        product.setCategory(productCategory);
        product.setStock(20);
        String[] ingredients = {"Ingredient1", "Ingredient2"};
        product.setIngredients(ingredients);
        product.setProductPrice(30);
        product.setImageUrl("test");

        product2 = new Product();
        product2.setProductName("Product2");
        product2.setCategory(productCategory);
        product2.setStock(20);
        String[] ingredients2 = {"Ingredient1", "Ingredient2"};
        product2.setIngredients(ingredients2);
        product2.setProductPrice(30);
        product2.setImageUrl("test");

        product3 = new Product();
        product3.setProductName("Product3");
        product3.setCategory(productCategory);
        product3.setStock(20);
        String[] ingredients3 = {"Ingredient1", "Ingredient2"};
        product3.setIngredients(ingredients3);
        product3.setProductPrice(30);
        product3.setImageUrl("test");


        productService.createProduct(product);
        productService.createProduct(product2);
        productService.createProduct(product3);
    }

    @Given("a user who wants to search for a specific dish,")
    public void aUserWhoWantsToSearchForASpecificDish() {
        GenerarDatos();
    }

    @When("he gives the drop-down box to filter dishes,")
    public void heGivesTheDropDownBoxToFilterDishes() {

        productList = productService.findByCategoryId(1);
    }

    @Then("the platform should show all the food filter options and order them in the order that the user selects")
    public void thePlatformShouldShowAllTheFoodFilterOptionsAndOrderThemInTheOrderThatTheUserSelects() {
        for (Product product : productList) {
            System.out.println(product.getProductName());
        }

    }
}
