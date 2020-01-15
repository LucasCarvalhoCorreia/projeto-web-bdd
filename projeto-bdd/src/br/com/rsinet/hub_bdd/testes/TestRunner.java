package br.com.rsinet.hub_bdd.testes;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "Feature"
 ,glue={"stepDefinition"}
 )

public class TestRunner {

}
