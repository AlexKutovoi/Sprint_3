package scooter;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

    public class OrderService extends RestAssuresService {

        private static final String ORDER_PATH = "/api/v1/orders/";

        @Step("Создание заказа")
        public ValidatableResponse create(Orders.orders order) {
            return given()
                    .spec(getBaseSpec())
                    .body(order)
                    .when()
                    .post(ORDER_PATH)
                    .then();
        }

        @Step("список заказов")
        public ValidatableResponse getOrderList() {
            return given()
                    .spec(getBaseSpec())
                    .when()
                    .get(ORDER_PATH)
                    .then();
        }

        public void cancel(int orderTrack) {
            given()
                    .spec(getBaseSpec())
                    .when()
                    .put(ORDER_PATH + "cancel/?track=" + orderTrack)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract()
                    .path("ok");
        }
    }

