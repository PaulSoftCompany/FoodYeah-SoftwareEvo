package com.example;

import com.example.entity.Order;
import com.example.entity.OrderDetail;
import com.example.entity.Product;
import com.example.repository.CardRepository;
import com.example.repository.OrderDetailRepository;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepsForVirtualPayment {

    //
    @Mock
    public OrderRepository orderRepository;
    @Mock
    private OrderDetailRepository orderDetailRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private CardRepository cardRepository;

    public OrderService orderService = new OrderServiceImpl(orderRepository,orderDetailRepository,
            productRepository, cardRepository);

    Product product = Product.builder().productName("awa").stock(30).build();
    List<OrderDetail> orderDetails;
    Order order = Order.builder().id(1L).state("CREATED").orderDetails(orderDetails).build();
    private int oldStock;
    private int quantity;

    //FALTA CREAR EL DETAIL Y AGREGARLO EN EL ORDER PARA METERLE AL SERVICE Y PROBAR_TODO LO DE ABAJO GA

    @Given("a user who places an order with a certain quantity of a product,")
    public void aUserWhoPlacesAnOrderWithACertainQuantityOfAProduct() {
        orderService.createOrder(order);
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
