package br.com.rsinet.hub_bdd.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
 features = "Feature",
 glue = {"br.com.rsinet.hub_bdd.stepDefinitions"},
 plugin = {"html:target/cucumber-reports"},
 monochrome = true
 )

public class TestRunner {

}

