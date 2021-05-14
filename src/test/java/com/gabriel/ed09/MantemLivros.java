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

public class MantemLivros {

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
    public void rEQ01CT01CadastroLivroComSucesso() {
        driver.get("https://ts-scel.herokuapp.com//");
        driver.findElement(By.linkText("Livros")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("9788");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.cssSelector(".my-5")).click();
        driver.findElement(By.id("autor")).sendKeys("Gabriel");
        driver.findElement(By.id("titulo")).sendKeys("O selenium");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.linkText("Livros")).click();
        driver.findElement(By.linkText("Lista de Livros")).click();
    }

    @Test
    public void rEQ01CT02ConsultaLivroComSucesso() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1536, 824));
        driver.findElement(By.linkText("Livros")).click();
        driver.findElement(By.linkText("Lista de Livros")).click();
    }

    @Test
    public void rEQ01CT03EdicaoLivroComSucesso() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1051, 806));
        driver.findElement(By.linkText("Livros")).click();
        driver.findElement(By.linkText("Lista de Livros")).click();
        driver.findElement(By.linkText("Editar")).click();
        driver.findElement(By.cssSelector("html")).click();
        driver.findElement(By.id("titulo")).sendKeys("o java");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.findElement(By.cssSelector("html")).click();
    }

    @Test
    public void rEQ01CT04ExclusaoLivroComSucesso() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1051, 806));
        driver.findElement(By.linkText("Livros")).click();
        driver.findElement(By.linkText("Lista de Livros")).click();
        driver.findElement(By.linkText("Excluir")).click();
    }

    @Test
    public void rEQ02CT01CadastroLivroComISBNInvalido() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1053, 807));
        driver.findElement(By.linkText("Livros")).click();
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("9780267401383");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Gabriel");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("O Java");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    }

    @Test
    public void rEQ02CT02CadastroLivroComAutorInvalido() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1054, 808));
        driver.findElement(By.linkText("Livros")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("9788");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.cssSelector(".row:nth-child(3) > .form-group")).click();
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("O Java");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    }
}
