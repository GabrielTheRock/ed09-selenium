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

public class Emprestimo {

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
    public void rEQ06CT01RealizarEmprestimoComSucesso() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1054, 808));
        driver.findElement(By.linkText("Empréstimo")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("9788");
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.id("ra")).sendKeys("8998");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    }

    @Test
    public void rEQ07CT01DevolverLivroComSucesso() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1054, 808));
        driver.findElement(By.linkText("Empréstimo")).click();
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
        vars.put("win9868", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9868").toString());
        driver.findElement(By.linkText("Devolver")).click();
        driver.findElement(By.linkText("Devolver")).click();
    }
}
