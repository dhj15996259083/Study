package test;

import java.io.IOException;
import java.util.Properties;

public class ResourceTest {
    public static void main(String[] args) throws IOException {
        Properties ps = new Properties();
        ps.load(ResourceTest.class.getResourceAsStream("/test.properties"));
        System.out.println(ps.getProperty("ddd"));
        ps.load(ResourceTest.class.getClassLoader().getResourceAsStream("test/test.properties"));
        System.out.println(ps.getProperty("ddd"));
    }
}
