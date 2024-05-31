package clarusway.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {//Driver null ise yani kullanılmıyor ise başlat.nu sayede 2.kez baslatılamaz.
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;

    }

    public static void closeDriver() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) {//driver null değilse yani kullanılıyorsa kapat...
            driver.quit();
            driver = null;//Null assing ederek getDriver methodun ile birkez daha cağırabiliriz.
        }
    }

}
