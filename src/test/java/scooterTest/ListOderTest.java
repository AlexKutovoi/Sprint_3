package scooterTest;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import scooter.OrderService;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class ListOderTest {

    public static class OrderListTest {

        private OrderService orderService = new OrderService();

        @Test
        public void orderListTest() {
            ValidatableResponse response = orderService.getOrderList();
            response.assertThat().body("orders.size()", is(not(0)));
        }

    }
}
