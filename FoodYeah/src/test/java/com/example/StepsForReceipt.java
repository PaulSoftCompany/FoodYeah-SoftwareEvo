package com.example;

import com.example.entity.*;
import com.example.service.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepsForReceipt extends SpringIntegrationTest{

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

    private Order order;
    private Card card;
    private OrderDetail detail;
    private Product product;
    private Customer customer;
    private CustomerCategory customerCategory;
    private ProductCategory productCategory;
    private Role role;

    private float oldmoney;
    private float actualmoney;

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
        card.setCustomer(customer);
        card.setCardOwnerName(customer.getCustomerName());
        cardService.createCard(card);
        this.oldmoney = card.getCardMoney();


        //////////////////////////////////////////////
        List<OrderDetail> _orderdetail;
        _orderdetail = new Vector<OrderDetail>();
        _orderdetail.add(detail);
        order = new Order();
        order.setCostumer(customer);
        order.setOrderDetails(_orderdetail);


    }


    @Given("a user making a transaction")
    public void aUserMakingATransaction() {
        GenerarDatos();
        Order recipt = orderService.createOrder(order);
    }

    @When("he successfully bought his plate")
    public void heSuccessfullyBoughtHisPlate() {

        if ((card.getCardMoney() - order.getTotalPrice()) >= 0) {
            card.setCardMoney(card.getCardMoney() - order.getTotalPrice());
        }
        this.actualmoney = card.getCardMoney();
        System.out.println(oldmoney);
        System.out.println(actualmoney);


    }

    @Then("the application must send the recepit to his educational email, wich is afiliated with the university")
    public void theApplicationMustSendTheRecepitToHisEducationalEmailWichIsAfiliatedWithTheUniversity() {
        assertEquals(this.actualmoney,this.oldmoney - (order.getTotalPrice()));

    }
}
