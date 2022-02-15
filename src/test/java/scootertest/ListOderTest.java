package scootertest;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import scooter.OrderService;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

public class ListOderTest {

    public static class OrderListTest {

        private OrderService orderService = new OrderService();

        @Test
        public void orderListTest() {
            ValidatableResponse response = orderService.getOrderList();
            response.assertThat().body("orders.size()", is(not(0)));
            int statusCode = response.extract().statusCode();
            assertEquals("Status code is wrong.", 200, statusCode);
        }

    }
}
