package scooter;

public class CredentialsCourier {

   public final String login;
    public final String password;

    public CredentialsCourier(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static CredentialsCourier from (CreateCourier courier) {
        return new CredentialsCourier(courier.login, courier.password);
    }
}
