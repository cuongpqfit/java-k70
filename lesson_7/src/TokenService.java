public interface TokenService {
    String defaultTolken = "123456";

    void createToken();

    default String destroyToken() {
        return "";
    }
}
