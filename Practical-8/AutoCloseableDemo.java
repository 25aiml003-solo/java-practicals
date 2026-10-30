class Resource implements AutoCloseable {
    public void use() { System.out.println("Using resource"); }
    public void close() { System.out.println("Resource closed automatically"); }
}
public class AutoCloseableDemo {
    public static void main(String[] args) {
        try (Resource resource = new Resource()) { resource.use(); }
    }
}
