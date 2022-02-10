package scooter;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.ArrayList;
import static io.restassured.RestAssured.*;

    public class ServiceCourier extends RestAssuresService {

        private static final String COURIER_PATH = "api/v1/courier/";

        @Step("Создание курьера")
        public ValidatableResponse create(CreateCourier courier) {
            return given()
                    .spec(getBaseSpec())
                    .body(courier)
                    .when()
                    .post(COURIER_PATH)
                    .then();
        }

        @Step("создание логина")
        public ValidatableResponse login(CredentialsCourier credentials) {
            return given()
                    .spec(getBaseSpec())
                    .body(credentials)
                    .when()
                    .post(COURIER_PATH + "login/")
                    .then();
        }

      @Step("удаление курьера")
        public void delete(int courierId) {
            given()
                    .spec(getBaseSpec())
                    .when()
                    .delete(COURIER_PATH + courierId)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract()
                    .path("ok");
        }

        public ArrayList<String> registerNewCourierAndReturnLoginPassword() {

            String courierLogin = RandomStringUtils.randomAlphabetic(10);
            String courierPassword = RandomStringUtils.randomAlphabetic(10);
            String courierFirstName = RandomStringUtils.randomAlphabetic(10);

            ArrayList<String> loginPass = new ArrayList<>();

            String registerRequestBody = "{\"login\":\"" + courierLogin + "\","
                    + "\"password\":\"" + courierPassword + "\","
                    + "\"firstName\":\"" + courierFirstName + "\"}";

            Response response =  given()
                    .header("Content-type", "application/json")
                    .and()
                    .body(registerRequestBody)
                    .when()
                    .post("https://qa-scooter.praktikum-services.ru/api/v1/courier");

            if (response.statusCode() == 201) {
                loginPass.add(courierLogin);
                loginPass.add(courierPassword);
            }

            return loginPass;

        }

    }

