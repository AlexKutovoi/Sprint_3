package scooter;

import org.apache.commons.lang3.RandomStringUtils;

public class CreateCourier {

    public String login;
    public String password;
    public String firstName;

    public CreateCourier() {
    }

    public CreateCourier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public static CreateCourier getRandomString() {
        final String login = RandomStringUtils.randomAlphabetic(10);
        final String password = RandomStringUtils.randomAlphabetic(10);
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return new CreateCourier(login, password, firstName);
    }

        public static CreateCourier getLogin() {
            final String login = RandomStringUtils.randomAlphabetic(10);
            return new CreateCourier().setLogin(login);
        }

    public CreateCourier setLogin (String login){
            this.login = login;
            return this;
        }

        public static CreateCourier getPassword () {
            final String password = RandomStringUtils.randomAlphabetic(10);
            return new CreateCourier().setPassword(password);
        }
        public CreateCourier setPassword (String password){
            this.password = password;
            return this;
        }

        public static CreateCourier getLoginAndPassword(){
            final String login = RandomStringUtils.randomAlphabetic(10);
            final String password = RandomStringUtils.randomAlphabetic(10);
            return new CreateCourier().setLogin(login).setPassword(password);
        }
    }
