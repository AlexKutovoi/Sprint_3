package scooter;

import org.apache.commons.lang3.RandomStringUtils;

public class CreateCourier {

    private String login;
    private String password;
    private String firstName;

    public CreateCourier() {}

    public CreateCourier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public static CreateCourier setRandomCredentials() {
        final String login = RandomStringUtils.randomAlphabetic(10);
        final String password = RandomStringUtils.randomAlphabetic(10);
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return new CreateCourier(login, password, firstName);
    }

    public String getLogin() {
        return login;
    }
    public static String setRandomLogin() {
        final String login = RandomStringUtils.randomAlphabetic(10);
        return login;
    }
    public CreateCourier setLogin(String login) {
        this.login = login;
        return this;
    }


    public String getPassword() {
        return password;
    }
    public static String setRandomPassword() {
        final String password = RandomStringUtils.randomAlphabetic(10);
        return password;
    }
    public CreateCourier setPassword(String password) {
        this.password = password;
        return this;
    }


    public String getFirstName() {
        return firstName;
    }
    public CreateCourier setRandomFirstName() {
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return setFirstName(firstName);
    }
    public CreateCourier setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}