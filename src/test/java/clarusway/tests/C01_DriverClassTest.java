package clarusway.tests;

import clarusway.utilities.Driver;
import org.testng.annotations.Test;

public class C01_DriverClassTest {

    @Test
    void driverClassTest() {
        //go to google
        Driver.getDriver().get("https://google.com");
        String title=Driver.getDriver().getTitle();
        System.out.println("title = " + title);

        Driver.closeDriver();
    }
}
