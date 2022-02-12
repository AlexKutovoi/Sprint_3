package scootertest;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import scooter.CreateCourier;
import scooter.CredentialsCourier;
import scooter.ServiceCourier;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ValidateCourierLoginTest {

    private final CreateCourier courier;
    private final int expectedStatusCode;
    private final String expectedErrorMessage;

    public ValidateCourierLoginTest(CreateCourier courier, int expectedStatusCode, String expectedErrorMessage) {
        this.courier = courier;
        this.expectedStatusCode = expectedStatusCode;
        this.expectedErrorMessage = expectedErrorMessage;

    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {CreateCourier.getRandomCredentials().getLoginOnly(), 400, "Недостаточно данных для входа"},
                {CreateCourier.getRandomCredentials().getLoginAndPassword(), 404, "Учетная запись не найдена"}
        };
    }

    @Test
    public void invalidRequestTest() {
        ValidatableResponse response = new ServiceCourier().login(CredentialsCourier.from(courier));
        int statusCode = response.extract().statusCode();
        String errorMessage = response.extract().path("message");
        assertEquals("Status code is wrong.", statusCode, expectedStatusCode);
        assertEquals("Error message is wrong.", errorMessage, expectedErrorMessage);
    }

}