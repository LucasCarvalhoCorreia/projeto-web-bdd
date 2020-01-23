package br.com.rsinet.hub_bdd.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static WebDriver driver;

	/* Método onde inicia o browzer especificado. */
	/* Maximiza a janela. */
	/* E entra no site especificado. */
	public enum DriverType {
		Chrome, FireFox, InternetExplorer;
	}

	public static WebDriver iniciaBrowser(DriverType tipo, String url) throws Exception {
		switch (tipo) {
		case InternetExplorer:
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case FireFox:
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		default:
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;

		}

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
