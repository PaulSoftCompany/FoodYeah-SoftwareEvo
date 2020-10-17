package com.example;

import com.example.entity.*;
import com.example.repository.*;
import com.example.service.*;
import com.example.service.impl.OrderServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.xmlunit.diff.Comparison;

import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class StepsForVirtualPayment extends SpringIntegrationTest  {

    @Autowired
   private ProductService productService;
    @Autowired
   private ProductCategoryService categoryService;
    @Autowired
   private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerCategoryService customerCategoryService;
    @Autowired
    private RoleService roleService;

    private Order order;
    private OrderDetail detail;
    private Product product;
    private Customer customer;
    private Role role;
    private CustomerCategory customerCategory;
    private ProductCategory productCategory;
    private int oldStock;
    private int quantity;

    void GenerarDatos(){

        ///////////////////////////////////////////////
        productCategory = new ProductCategory();
        productCategory.setProductCategoryName("Category");
        productCategory.setProductCategoryDescription("test");
        categoryService.createProduct_Category(productCategory);
        /////////////////////////////////////////////////
        product = new Product();
        product.setProductName("Product");
        product.setCategory(productCategory);
        product.setStock(20);
        String[] ingredients = {"Ingredient1", "Ingredient2"};
        product.setIngredients(ingredients);
        product.setProductPrice(30);
        product.setImageUrl("test");
        productService.createProduct(product);
        //////////////////////////////////////////////////
        detail = new OrderDetail();
        byte quantity = 4;
        detail.setQuantity(quantity);
        detail.setProduct(product);

        ///////////////////////////////////////////////
        customerCategory = new CustomerCategory();
        customerCategory.setCustomerCategoryName("Test");
        customerCategory.setCustomerCategoryDescription("Test");
        customerCategoryService.createCustomerCategory(customerCategory);
        ////////////////////////////////////////////
        role = new Role();
        role.setRoleName("Admin");
        role.setRoleDescription("Admin");
        roleService.createRole(role);
        role.setRoleName("User");
        role.setRoleDescription("User");
        roleService.createRole(role);

        /////////////////////////////////////////
        customer = new Customer();
        byte age = 20;
        customer.setCustomerAge(age);
        customer.setCustomerName("TestName");
        customer.setCustomerCategory(customerCategory);
        customer.setUsername("asername@upc.edu.pe");
        customer.setPassword("ptestr41241d");
        customerService.createCustomer(customer);

        //////////////////////////////////////////////
        List<OrderDetail>_orderdetail;
        _orderdetail = new Vector<OrderDetail>();
        _orderdetail.add(detail);
        order = new Order();
        order.setCostumer(customer);
        order.setOrderDetails(_orderdetail);


    }

    @Given("a user who places an order with a certain quantity of a product,")
    public void aUserWhoPlacesAnOrderWithACertainQuantityOfAProduct() {
        GenerarDatos();
        Order recipt = orderService.createOrder(order);
        OrderDetail orderDummy = order.getOrderDetails().get(0);
        this.oldStock = orderDummy.getProduct().getStock();
        this.quantity = orderDummy.getQuantity();
    }

    @When("the order is delivered,")
    public void theOrderIsDelivered() {
        if(order.getState().equals("CREATED"))
            order.setState("DELIVERED");
    }

    @Then("the stock must decrease in relation to the quantity that the user has bought")
    public void theStockMustDecreaseInRelationToTheQuantityThatTheUserHasBought() {
        orderService.DecreaseStock(order);
        assertEquals(order.getOrderDetails().get(0).getProduct().getStock(),this.oldStock-this.quantity);
    }






    @Given("an application user who wants to be able to pay through the app to avoid the checkout line,")
    public void anApplicationUserWhoWantsToBeAbleToPayThroughTheAppToAvoidTheCheckoutLine() {
    }

    @When("they press the cart icon positioned on the food they select,")
    public void theyPressTheCartIconPositionedOnTheFoodTheySelect() {
    }

    @Then("it will be added to their shopping cart")
    public void itWillBeAddedToTheirShoppingCart() {
    }
}
