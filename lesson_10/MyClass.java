import java.io.Serializable;

public class MyClass implements Serializable {
    private String message;
    private int number;

    public MyClass(String message, int number) {
        this.message = message;
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "message='" + message + '\'' +
                ", number=" + number +
                '}';
    }
}
