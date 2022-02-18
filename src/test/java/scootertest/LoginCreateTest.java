package scootertest;

import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scooter.CreateCourier;
import scooter.CredentialsCourier;
import scooter.ServiceCourier;

import static org.junit.Assert.*;

public class LoginCreateTest {

    private CreateCourier courier;
    private ServiceCourier courierService;
    private int courierId;

    @Before
    public void setUp() {
        courierService = new ServiceCourier();
        courier = CreateCourier.getRandomCredentials();
        courierService.create(courier);
        courierId = courierService.login(CredentialsCourier.from(courier)).extract().path("id");
    }

    @Test
    public void loginRequestReturnsSuccessAndReturnsIdTest() {
        ValidatableResponse response = courierService.login(CredentialsCourier.from(courier));
        int statusCode = response.extract().statusCode();
        assertEquals("Status code is wrong.", 200, statusCode);

    }

    @Test
    public void loginRequestReturnsIdTest() {
        ValidatableResponse response = courierService.login(CredentialsCourier.from(courier));
        int statusCode = response.extract().statusCode();
        int id = response.extract().path("id");
        assertNotEquals("Id is not returned.", 0, id);

    }

    @Test
    public void errorOnWrongLoginTest() {
        courier.setLogin(RandomStringUtils.randomAlphabetic(10));
        ValidatableResponse response = courierService.login(CredentialsCourier.from(courier));
        int statusCode = response.extract().statusCode();
        assertEquals("Status code is wrong.", 404, statusCode);
    }

    @Test
    public void errorOnWrongPasswordTest() {
        courier.setPassword(RandomStringUtils.randomAlphabetic(10));
        ValidatableResponse response = courierService.login(CredentialsCourier.from(courier));
        int statusCode = response.extract().statusCode();
        assertEquals("Status code is wrong.", 404, statusCode);
    }

    @After
    public void tearDown() {
        courierService.delete(courierId);
    }
}

