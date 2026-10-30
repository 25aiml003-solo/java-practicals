public class Thermostat {
    private static final int MIN_TEMPERATURE = 16;
    private static final int MAX_TEMPERATURE = 30;
    private static final int DEFAULT_TEMPERATURE = 22;
    private static int activeCount;
    private final String location;
    private int temperature;

    public Thermostat(String location) { this(location, DEFAULT_TEMPERATURE); }
    public Thermostat(String location, int temperature) {
        this.location = location;
        this.temperature = temperature >= MIN_TEMPERATURE && temperature <= MAX_TEMPERATURE
                ? temperature : DEFAULT_TEMPERATURE;
        activeCount++;
    }
    public void raise() { if (temperature < MAX_TEMPERATURE) temperature++; }
    public void lower() { if (temperature > MIN_TEMPERATURE) temperature--; }
    public int getTemperature() { return temperature; }
    public static int getActiveCount() { return activeCount; }
    public String toString() { return location + ": " + temperature + " C"; }

    public static void main(String[] args) {
        Thermostat livingRoom = new Thermostat("Living Room");
        Thermostat bedroom = new Thermostat("Bedroom", 25);
        livingRoom.raise();
        bedroom.lower();
        System.out.println(livingRoom);
        System.out.println(bedroom);
        System.out.println("Active thermostats: " + getActiveCount());
    }
}
