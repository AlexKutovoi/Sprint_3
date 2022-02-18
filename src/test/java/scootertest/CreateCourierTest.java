package scootertest;

import org.junit.Test;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import scooter.CreateCourier;
import scooter.CredentialsCourier;
import scooter.ServiceCourier;

import static org.junit.Assert.*;

public class CreateCourierTest {

    private CreateCourier courier;
    private ServiceCourier courierService;
    private int courierId;

    @Before
    public void setUp() {
        courierService = new ServiceCourier();
        courier = CreateCourier.getRandomCredentials();
    }

    @Test
    public void createRequestReturnsSuccessMessageTest() {
        ValidatableResponse response = courierService.create(courier);
        boolean isCreated = response.extract().path("ok");
        assertTrue("Courier is not created.", isCreated);
        courierId = courierService.login(CredentialsCourier.from(courier)).extract().path("id");
    }

    @Test
    public void createRequestReturnsSuccessCodeTest() {
        ValidatableResponse response = courierService.create(courier);
        int statusCode = response.extract().statusCode();
        courierId = courierService.login(CredentialsCourier.from(courier)).extract().path("id");
        assertEquals("Status code is wrong.", 201, statusCode);

    }

    @Test
    public void sameCourierCannotBeCreatedTwiceTest() {
        courierService.create(courier);
        ValidatableResponse response = courierService.create(courier);
        int statusCode = response.extract().statusCode();
        String errorMessage = response.extract().path("message");
        courierId = courierService.login(CredentialsCourier.from(courier)).extract().path("id");
        assertEquals("Status code is wrong.", 409, statusCode);
        assertEquals("Error message is wrong.", "Этот логин уже используется. Попробуйте другой.", errorMessage);
    }

    @After
    public void tearDown() {
        courierService.delete(courierId);
    }
}






