package com.gabriel.ed09;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Login {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chrome_driver/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }

    @Test
    public void rEQ08CT01LoginInvalido() {
        driver.get("https://ts-scel.herokuapp.com/login");
        driver.manage().window().setSize(new Dimension(1054, 808));
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("1");
        driver.findElement(By.cssSelector(".form")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("1");
        driver.findElement(By.cssSelector("button")).click();
    }

    @Test
    public void rEQ09CT01ValidaPermissaoJose() {
        driver.get("https://ts-scel.herokuapp.com/login");
        driver.manage().window().setSize(new Dimension(1054, 808));
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("jose");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button")).click();
        driver.findElement(By.linkText("Alunos")).click();
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.id("ra")).sendKeys("1234");
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("jose");
        driver.findElement(By.id("email")).sendKeys("jose@gmail.com");
        driver.findElement(By.id("cep")).sendKeys("08030590");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.linkText("Voltar")).click();
        driver.findElement(By.linkText("Empréstimo")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("1111");
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.id("ra")).sendKeys("8998");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.linkText("Voltar")).click();
        driver.findElement(By.linkText("Alunos")).click();
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.cssSelector("form > .row:nth-child(2)")).click();
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
        vars.put("win5710", waitForWindow(2000));
        driver.switchTo().window(vars.get("win5710").toString());
    }

    @Test
    public void rEQ10CT01ValidaPermissaoMaria() {
        driver.get("https://ts-scel.herokuapp.com/login");
        driver.manage().window().setSize(new Dimension(1054, 808));
        driver.findElement(By.linkText("Alunos")).click();
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.id("ra")).sendKeys("2345");
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("maria");
        driver.findElement(By.id("email")).sendKeys("maria@gmail.com");
        driver.findElement(By.id("cep")).sendKeys("08030590");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.linkText("Voltar")).click();
        driver.findElement(By.linkText("Alunos")).click();
        driver.findElement(By.linkText("Voltar")).click();
        driver.findElement(By.linkText("Livros")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("2345");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("maria");
        driver.findElement(By.id("titulo")).sendKeys("eu sou maria");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.linkText("Voltar")).click();
        driver.findElement(By.linkText("Empréstimo")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("2345");
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.id("ra")).sendKeys("2345");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.name("username")).sendKeys("maria");
        driver.findElement(By.name("password")).sendKeys("456");
        driver.findElement(By.cssSelector("button")).click();
    }

}
