package scooter;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.List;

public class Orders {

    public static class orders {

        private String firstName;
        private String lastName;
        private String address;
        private String metroStation;
        private String phone;
        private String rentTime;
        private String deliveryDate;
        private String comment;
        private List<String> color;

        public orders(String firstName, String lastName, String address, String metroStation, String phone, String rentTime, String deliveryDate, String comment) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.metroStation = metroStation;
            this.phone = phone;
            this.rentTime = rentTime;
            this.deliveryDate = deliveryDate;
            this.comment = comment;
        }

        public static orders getRandom() {
            final String firstName = RandomStringUtils.randomAlphabetic(10);
            final String lastName = RandomStringUtils.randomAlphabetic(10);
            final String address = RandomStringUtils.randomAlphabetic(10);
            final String metroStation = RandomStringUtils.randomAlphabetic(10);
            final String phone = RandomStringUtils.randomNumeric(11);
            final String rentTime = RandomStringUtils.randomNumeric(1);
            final String deliveryDate = "2022-02-15";
            final String comment = RandomStringUtils.randomAlphabetic(10);
            return new orders(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment);
        }

        public orders setColor(List<String> color) {
            getRandom();
            this.color = color;
            return this;
        }

    }

}
