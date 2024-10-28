package org.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@RunWith(SerenityRunner.class)
public class tests {

    private String url = "https://www.floristeriamundoflor.com/";
    WebDriver driver;

    @BeforeTest
    public void setBaseUrl (){

        System.setProperty("webdriver.chrome.driver","C:\\Automatización\\chromedriver-win64\\chromedriver.exe");
        //Inicializar la variable
        driver = new ChromeDriver();

        //Maximizar la pagina
        driver.manage().window().maximize();

    }

    @Test (priority = 1)
    public void test_01_Select_Love_Products() throws InterruptedException{

        //Abrir pagina
        driver.get(url);

        //Buscar la categoria
        WebElement category = driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[3]/a"));
        category.click();

        //Buscar el producto 1
        WebElement product = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[1]/div/div[1]/figure/div/div[1]/a"));

        //Click a la opción añadir carrito
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
        Thread.sleep(2000);

        //Retornar - Seguir comprando
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div/div/div/div[1]/div/a")).click();

        //Buscar el producto 2
        WebElement product2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/figure/div/div[1]/a"));

        //Click a la opción producto
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product2);
        Thread.sleep(2000);
    }

    @Test (priority = 2)

    public void test_02_Select_Birthday_products() throws InterruptedException{

        //Abrir pagina
        driver.get(url);

        //Buscar la categoria
        WebElement birthday_category = driver.findElement(By.xpath("//*[@id=\"menu-item-2799\"]/a"));
        birthday_category.click();

        //Buscar el producto de cumpleaños
        WebElement product = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[3]/div/div[1]/figure/div/div[1]/a"));

        //Click a la opción añadir carrito
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
        Thread.sleep(2000);

        //Eliminar producto
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div/div/div/div[2]/form/div/table/tbody/tr[1]/td[6]/a/i")).click();

    }

    @AfterTest
    public void exit_url () {

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
