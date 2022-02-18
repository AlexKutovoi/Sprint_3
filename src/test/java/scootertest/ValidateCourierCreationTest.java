package scootertest;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import scooter.CreateCourier;
import scooter.ServiceCourier;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ValidateCourierCreationTest {

    private final CreateCourier courier;
    private final int expectedStatusCode;
    private final String expectedErrorMessage;

    public ValidateCourierCreationTest(CreateCourier courier, int expectedStatusCode, String expectedErrorMessage) {
        this.courier = courier;
        this.expectedStatusCode = expectedStatusCode;
        this.expectedErrorMessage = expectedErrorMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {CreateCourier.getLoginOnly(), 400, "Недостаточно данных для создания учетной записи"},
                {CreateCourier.getPasswordOnly(), 400, "Недостаточно данных для создания учетной записи"},
                {CreateCourier.getLoginAndPassword(), 201, null}
        };
    }

    @Test
    public void invalidRequestTest() {
        ValidatableResponse response = new ServiceCourier().create(courier);
        int statusCode = response.extract().statusCode();
        String errorMessage = response.extract().path("message");
        assertEquals("Status code is wrong.", statusCode, expectedStatusCode);
        assertEquals("Message is wrong.", errorMessage, expectedErrorMessage);
    }

}

