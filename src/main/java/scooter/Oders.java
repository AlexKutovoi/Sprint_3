package scooter;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.List;

public class Oders {

    public static class Orders {

        public String firstName;
        public String lastName;
        public String address;
        public String metroStation;
        public String phone;
        public String rentTime;
        public String deliveryDate;
        public String comment;
        public List<String> color;

        public Orders(String firstName, String lastName, String address, String metroStation, String phone, String rentTime, String deliveryDate, String comment) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.metroStation = metroStation;
            this.phone = phone;
            this.rentTime = rentTime;
            this.deliveryDate = deliveryDate;
            this.comment = comment;
        }

        public static Orders getRandom() {
            final String firstName = RandomStringUtils.randomAlphabetic(10);
            final String lastName = RandomStringUtils.randomAlphabetic(10);
            final String address = RandomStringUtils.randomAlphabetic(10);
            final String metroStation = RandomStringUtils.randomAlphabetic(10);
            final String phone = RandomStringUtils.randomNumeric(11);
            final String rentTime = RandomStringUtils.randomNumeric(1);
            final String deliveryDate = "2022-02-05";
            final String comment = RandomStringUtils.randomAlphabetic(10);
            return new Orders(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment);
        }

        public Orders setColor(List<String> color) {
            getRandom();
            this.color = color;
            return this;
        }

    }

}
