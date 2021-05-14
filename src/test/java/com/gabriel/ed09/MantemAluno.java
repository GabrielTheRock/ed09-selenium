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

public class MantemAluno {

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

    @Test
    public void rEQ03CT01CadastroAlunoComSucesso() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1054, 808));
        driver.findElement(By.linkText("Alunos")).click();
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.id("ra")).sendKeys("8998");
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("Gabriel da Rocha Souza");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("gabriel@gmail.com");
        driver.findElement(By.id("cep")).sendKeys("08030590");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    }

    @Test
    public void rEQ04CT01CadastroAlunoComRaInvalido() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1054, 808));
        driver.findElement(By.linkText("Alunos")).click();
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.id("ra")).sendKeys("0000000000");
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("gabriel");
        driver.findElement(By.id("email")).sendKeys("gabriel@gmail.com");
        driver.findElement(By.id("cep")).sendKeys("85599893");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    }

    @Test
    public void rEQ05CT01ValidarCep() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1056, 808));
        driver.findElement(By.linkText("Alunos")).click();
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.id("ra")).sendKeys("8998");
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("gabriel");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("gabriel@gmail.com");
        driver.findElement(By.id("cep")).click();
        driver.findElement(By.id("cep")).sendKeys("08030590");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    }

}
