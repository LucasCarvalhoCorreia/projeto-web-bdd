package br.com.rsinet.hub_bdd.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
 features = "Feature/Cadastro.feature",
 glue = {"br.com.rsinet.hub_bdd.stepDefinitions"},
 plugin = {"html:target/cucumber-reports"},
 monochrome = true
 )

public class Cadastro_TestRunner {

}

