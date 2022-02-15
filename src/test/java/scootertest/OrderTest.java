package scootertest;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scooter.Orders;
import scooter.OrderService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OrderTest {

    private Orders order;
    private OrderService orderService;
    private int orderTrack;

    @Before
    public void setUp() {
        orderService = new OrderService();
        order = Orders.getRandom();
    }

    @Test
    public void createRequestReturnsSuccessCodeAndIdTest() {
        ValidatableResponse response = orderService.create(order);
        int statusCode = response.extract().statusCode();
        orderTrack = response.extract().path("track");
        assertEquals("Status code is wrong.", 201, statusCode);
        assertNotEquals("Id is not returned.", 0, orderTrack);
    }


    @After
    public void tearDown() {
        orderService.cancel(orderTrack);
    }

}

