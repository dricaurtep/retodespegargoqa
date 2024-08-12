package com.ilanalab.acceptancetests;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(plugin = {
        "pretty" }, features = "src/test/resources/features", glue = "com.ilanalab", 
        snippets = SnippetType.CAMELCASE , 
        tags = ("@Validacion_servicio_de_alojamiento"))

public class RunnerDespegarTest {
    
}
