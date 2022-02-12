package scooter;

import org.apache.commons.lang3.RandomStringUtils;


        public class CreateCourier {

            public String login;
            public String password;

            private String firstName;

            public CreateCourier() {}

            public CreateCourier(String login, String password, String firstName) {
                this.login = login;
                this.password = password;
                this.firstName = firstName;
            }

            public static CreateCourier getRandomCredentials() {
                final String login = RandomStringUtils.randomAlphabetic(10);
                final String password = RandomStringUtils.randomAlphabetic(10);
                final String firstName = RandomStringUtils.randomAlphabetic(10);
                return new CreateCourier(login, password, firstName);
            }

            public CreateCourier setLogin(String login) {
                login = RandomStringUtils.randomAlphabetic(10);
                this.login = login;
                return this;
            }

            public CreateCourier setPassword(String password) {
                password = RandomStringUtils.randomAlphabetic(10);
                this.password = password;
                return this;
            }

            public static CreateCourier getLoginOnly() {
                final String login = RandomStringUtils.randomAlphabetic(10);
                return new CreateCourier().setLogin(login);
            }

            public static CreateCourier getPasswordOnly() {
                final String password = RandomStringUtils.randomAlphabetic(10);
                return new CreateCourier().setPassword(password);
            }

            public static CreateCourier getLoginAndPassword() {
                final String login = RandomStringUtils.randomAlphabetic(10);
                final String password = RandomStringUtils.randomAlphabetic(10);
                return new CreateCourier().setLogin(login).setPassword(password);
            }
        }


