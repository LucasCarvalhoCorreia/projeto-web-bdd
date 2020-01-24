package br.com.rsinet.hub_bdd.testRunner;


import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;





@RunWith(Cucumber.class)
@CucumberOptions(
 features = "Feature",
 glue = {"br.com.rsinet.hub_bdd.stepDefinitions"},
 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
 monochrome = true
 )

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("configs/extension-config.xml"));
	}

}

