package clarusway.tests;

import clarusway.pages.HBBilgisayarlar;
import clarusway.utilities.ConfigReader;
import clarusway.utilities.Driver;
import clarusway.utilities.JavascriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class C00_Homework30 {
   /*
    Given
        Go to https://www.hepsiburada.com/bilgisayarlar-c-2147483646
    When
        Click all marks and print their names
        (Soldaki markaların hepsine tıklayıp adlarını yazdırınız)
*/

    @Test
    void homework_30() throws InterruptedException {

        HBBilgisayarlar hbHomepage = new HBBilgisayarlar();

        Driver.getDriver().get(ConfigReader.getProperty("hbbilgisayarlar_url"));
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();//tüm cerezleri kabul butonu sağ alt
       // Driver.getDriver().findElement(By.xpath("//button[@aria-label='Consent']")).click();

        List<WebElement> markalar = hbHomepage.markaElements;

        for (int i = 0; i < markalar.size(); i++) {

            Thread.sleep(1000); // olmadan StaleElementReferenceException hatasi veriyor wait kullanilabilir.
           // JavascriptUtils.scrollIntoViewJS(markalar.get(i));
            /*
            37. satirdaki kod yani JS scrollIntoViewJS() methodu kullanilirsa ne kadar marka varsa tek tek gorunur hale gelinceye kadar bekliyor sonrasinda click islemi yapiyor.
            web sayfasinda kac tane marka varsa tek tek hepsini bulup click yapiyor ben 100 markaya kadar yazdirip durdurdum.
            37. satir kapatilirsa ilk anda algiladigi 20 markayi alip click yapip yazdiriyor
            */
            JavascriptUtils.clickElementByJS(markalar.get(i)); // JS methodu ile click islemi yapiyor.

            String marka = markalar.get(i).getAttribute("value"); // listteki herbir webelementin value degerini yani marka isimlerini bize getiriyor.
            System.out.println((i + 1) + ". marka = " + marka); // markalari yazdiriyor.
        }

        Driver.closeDriver();
    }
}