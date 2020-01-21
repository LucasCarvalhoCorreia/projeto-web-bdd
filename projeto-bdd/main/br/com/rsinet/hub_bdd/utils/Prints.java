package br.com.rsinet.hub_bdd.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Prints {

	/* Atribui data e hora ao nomear o arquivo de print. */
	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	/*
	 * Cria um arquivo de imagem e atribui um nome a ele especificado na declaração
	 * do método.
	 */
	public static void tirarPrintsDeSucesso(String nomeDaImagem, WebDriver driver) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		/* Especifica o endereço onde a print será armazenada. */
		String imageFileDir = "C:\\Users\\Lucas\\git\\projeto-bdd\\projeto-bdd\\target\\sucessos";
//		String imageFileDir = "C:\\Users\\lucas.correia\\git\\jee\\projeto-bdd\\projeto-bdd\\target\\sucessos";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDaImagem + timestamp() + ".png"));
	}
	
	public static void tirarPrintsDeFalha(String nomeDaImagem, WebDriver driver) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		/* Especifica o endereço onde a print será armazenada. */
		String imageFileDir = "C:\\Users\\Lucas\\git\\projeto-bdd\\projeto-bdd\\target\\falhas";
//		String imageFileDir = "C:\\Users\\lucas.correia\\git\\jee\\projeto-bdd\\projeto-bdd\\target\\falhas";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDaImagem + timestamp() + ".png"));
	}
}
