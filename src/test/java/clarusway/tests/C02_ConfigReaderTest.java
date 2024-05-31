package clarusway.tests;

import clarusway.utilities.ConfigReader;
import org.testng.annotations.Test;

public class C02_ConfigReaderTest {

    @Test
    void configReaderTest() {
        String claruswayUrl= ConfigReader.getProperty("clarusway_url");

    }
}
