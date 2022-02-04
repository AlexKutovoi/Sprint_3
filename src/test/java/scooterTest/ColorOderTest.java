package scooterTest;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import scooter.Oders;
import scooter.OrderService;
import java.util.List;
import static org.junit.Assert.assertEquals;

    @RunWith(Parameterized.class)
    public class ColorOderTest {

        private final List<String> color;
        private final int expectedStatusCode;

        public ColorOderTest(List<String> color, int expectedStatusCode) {
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
            Oders.Orders order = Oders.Orders.getRandom().setColor(color);
            ValidatableResponse response = new OrderService().create(order);
            int statusCode = response.extract().statusCode();
            assertEquals("Status code is wrong.", statusCode, expectedStatusCode);
        }

    }

