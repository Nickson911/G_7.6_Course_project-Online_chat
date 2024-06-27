package server;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import static org.testng.AssertJUnit.assertEquals;

public class ServerTest {
    public static final String SETTINGS_FILENAME = "settings.txt";
    private static final Logger log = Logger.getInstance();
    String path;
    String host;
    int port;

    @Test
    void main() {
        try (FileReader reader = new FileReader(SETTINGS_FILENAME)) {
            Properties props = new Properties();
            props.load(reader);
            port = Integer.parseInt(props.getProperty("SERVER_PORT"));
            host = props.getProperty("SERVER_HOST");
            path = props.getProperty("SERVER_LOG");
        } catch (IOException e) {
            log.log(e.getMessage(), path);
            System.out.println(e.getMessage());
        }
        assertEquals(12345, port);
        assertEquals("127.0.0.1", host);
        assertEquals("server.log", path);
    }
}