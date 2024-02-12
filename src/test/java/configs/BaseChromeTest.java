package configs;

import org.junit.jupiter.api.BeforeEach;

public class BaseChromeTest extends BaseTest{

    @BeforeEach
    public void setUp() {
        System.out.println("****Setup - Initializing Chrome Driver");
        startChromeDriver();
    }
}
