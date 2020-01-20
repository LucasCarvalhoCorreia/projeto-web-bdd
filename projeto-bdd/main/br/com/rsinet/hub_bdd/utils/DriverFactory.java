package br.com.rsinet.hub_bdd.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public static WebDriver driver;

	/* Método onde inicia o browzer especificado. */
	/* Maximiza a janela. */
	/* E entra no site especificado. */
	public static WebDriver iniciaBrowser() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://advantageonlineshopping.com/#/");

		return driver;
	}

	/* Método responsavel por fechar o browzer. */
	public static void fechaBrowser(WebDriver driver) {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}

	}
}
