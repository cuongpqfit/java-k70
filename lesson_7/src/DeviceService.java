public interface DeviceService {
    void showToken();

    default String destroyToken2() {
        return "";
    }
}
