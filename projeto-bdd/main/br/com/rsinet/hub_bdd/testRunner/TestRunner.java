package br.com.rsinet.hub_bdd.testRunner;


import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.managers.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
 features = "classpath:feature",
 glue = {"br.com.rsinet.hub_bdd.stepDefinitions"},
 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/resultados.html"},
 snippets = SnippetType.CAMELCASE,
 monochrome = true,
 dryRun = false,
 tags = {"@TesteDeSucesso, @TesteDeFalha"}
 )

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}

}

