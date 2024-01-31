package com.textscraper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Configure ChromeOptions to run in headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--disable-gpu"); // Disable GPU acceleration

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the website
        String url = "https://www.independent.co.uk/news/oscar-pistorius-ap-reeva-steenkamp-south-africa-pretoria-b2473429.html";
        driver.get(url);

        // Extract text content
        String textContent = driver.findElement(By.tagName("body")).getText();

        // Create file that web-text will be sent to
        File file = new File("webPageText.txt");
        try {
            file.createNewFile();
            
            FileWriter fileWriter = new FileWriter("webPageText.txt");

            // Send the structured text to the file
            fileWriter.write(textContent);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(textContent);

        // Clean up resources
        driver.quit();
    }
}

