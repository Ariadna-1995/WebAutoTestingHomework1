package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriverExample {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }
}
