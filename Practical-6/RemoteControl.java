interface Device { void turnOn(); void turnOff(); }
class Television implements Device {
    public void turnOn() { System.out.println("TV is ON"); }
    public void turnOff() { System.out.println("TV is OFF"); }
}
public class RemoteControl {
    public static void main(String[] args) {
        Device device = new Television();
        device.turnOn();
        device.turnOff();
    }
}
