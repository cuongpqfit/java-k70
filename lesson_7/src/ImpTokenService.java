public class ImpTokenService implements TokenService, DeviceService{
    @Override
    public void createToken() {
        System.out.println("new token");
    }

    @Override
    public void showToken() {
        System.out.println("show token");
    }
}
