package scooter;

public class CredentialsCourier {

    private final String login;
    private final String password;

    public CredentialsCourier (String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static CredentialsCourier from(CreateCourier courier) {
        return new CredentialsCourier(courier.getLogin(), courier.getPassword());
    }
}
