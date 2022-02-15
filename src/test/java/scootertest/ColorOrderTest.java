package scootertest;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import scooter.Orders;
import scooter.OrderService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class ColorOrderTest {

    private final List<String> color;
    private final int expectedStatusCode;

    public ColorOrderTest(List<String> color, int expectedStatusCode) {
        this.color = color;
        this.expectedStatusCode = expectedStatusCode;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {List.of("BLACK"), 201},
                {List.of("GREY"), 201},
                {List.of("BLACK", "GREY"), 201}
        };
    }

    @Test
    public void colorTest() {
        Orders order;
        order = Orders.getRandom().setColor(color);
        ValidatableResponse response = new OrderService().create(order);
        int orderTrack = response.extract().path("track");
        int statusCode = response.extract().statusCode();
        assertEquals("Status code is wrong.", statusCode, expectedStatusCode);
        assertNotEquals("track is not returned.", 0, orderTrack);
    }
}

