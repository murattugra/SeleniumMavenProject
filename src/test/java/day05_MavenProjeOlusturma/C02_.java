package day05_MavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1. http://zero.webappsecurity.com sayfasina gidin

        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login alanine  “username” yazdirin
         WebElement loginBox=driver.findElement(By.xpath("//input[@id='user_login']"));
         loginBox.sendKeys("username");

        //4. Password alanine “password” yazdirin
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");

        //5. Sign in buttonuna tiklayin
       WebElement signInBox= driver.findElement(By.xpath("//input[@name='submit']"));
        signInBox.click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountBox=driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amountBox.sendKeys("1");
        //8. tarih kismina “2020-09-10” yazdirin
        WebElement dateBox=driver.findElement(By.xpath("//input[@id='sp_date']"));
        dateBox.sendKeys("2020-09-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin

        WebElement text=driver.findElement(By.xpath("//span[@title='$ 1 payed to payee sprint']"));
        String actualText=text.getText();
        String expectedResult="The payment was successfully submitted.";
        if (actualText.equals(expectedResult)){
            System.out.println("text Test PASS");
        }else {
            System.out.println("text Test FAILED");
        }














    }

}
