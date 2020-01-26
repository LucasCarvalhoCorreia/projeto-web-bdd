package br.com.rsinet.hub_bdd.testRunner;


import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




/* Esta classe roda todos os cenarios descritos nas features e gera um relatorio.*/

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "Feature",/* Caminho referente as features.*/
 glue = {"br.com.rsinet.hub_bdd.stepDefinitions"}, /* Caminho referente as classes que executam os codigos 
 														para simular os cenarios descritos*/
 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Reports.html"}, /* Caminho onde o report sera salvo.*/
 monochrome = true
 )

public class TestRunner {
	
	/* Executa as configuracoes do extend report.*/
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("configs/extension-config.xml"));
	}

}

