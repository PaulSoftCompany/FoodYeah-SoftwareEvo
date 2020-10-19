package com.example;

import com.example.entity.*;
import com.example.repository.CustomerRepository;
import com.example.repository.OrderRepository;
import com.example.service.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Vector;

public class StepsForAverageTime extends SpringIntegrationTest {
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
    private CardService cardService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private OrderRepository orderRepository;

    private Order order;
    private Card card;
    private OrderDetail detail;
    private Product product;
    private Customer customer;
    private CustomerCategory customerCategory;
    private ProductCategory productCategory;
    private Role role;
    private Order recipt;
    private boolean ValidCustomer;

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
        byte quantity = 2;
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

        //////////////////////////////////////////////////
        card = new Card();
        card.setCardCvi(123);
        card.setCardNumber("test");
        card.setCardExpireDate("test");
        card.setCardMoney(150);
        card.setCardType(true);
        cardService.createCard(card);


        //////////////////////////////////////////////
        List<OrderDetail> _orderdetail;
        _orderdetail = new Vector<OrderDetail>();
        _orderdetail.add(detail);
        order = new Order();
        order.setCostumer(customer);
        order.setOrderDetails(_orderdetail);


    }


    @Given("an application user")
    public void an_application_user() {
        GenerarDatos();
        if (customerService.findOneByUsername(customer.getUsername()) != null) {
            ValidCustomer = true;
        }
    }


    @When("placing an order")
    public void placingAnOrder() {
        if(ValidCustomer == true)
        recipt = orderService.createOrder(order);

    }

    @Then("the application must validate if there are previous orders before calculating the average order time")
    public void theApplicationMustValidateIfThereArePreviousOrdersBeforeCalculatingTheAverageOrderTime() {

        if (!orderRepository.findAllByCostumerId(customer.getId()).isEmpty()) {
            orderService.GetAverageTime();
        }
    }
}
