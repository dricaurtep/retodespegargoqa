package com.ilanalab.utils;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import net.serenitybdd.core.pages.PageObject;

public class Utils extends PageObject {

    public void forzarClickJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", element);
    }

    public void scrollPagina(String numScroll) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0," + numScroll + ")");
    }

    public void executeLocalizadorJS(String querySelector) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) getDriver();
        String typeKeywordJS = querySelector;
        jsExecutor.executeScript(typeKeywordJS);
    }

    public void seleccionarListaValor(By lista, String valor) {
        new Select(find(lista)).selectByValue(valor);
    }

    public void seleccionarListaTextoVisible(By lista, String valor) {
        new Select(find(lista)).selectByVisibleText(valor);
    }

    public void getAssertLocalizadorWebElement(WebElement localizador, String data) {
        String localizadorAssert = getTextLabelWebElement(localizador);
        Assert.assertEquals(localizadorAssert, data);
    }

    public void esperaMilis(Integer milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cambioDePestaña(int tab) {
        ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
        System.out.println(tabs.size());
        getDriver().switchTo().window((String) tabs.get(tab));
    }

    public void abrirNuevaPestana() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.open('');");
        esperaMilis(2000);
        cambioDePestaña(1);
    }

    public void cerrarPestana() {
        getDriver().close();
        cambioDePestaña(0);
    }

    public Integer busquedaDeElemento(By localizador) {

        try {
            WebElement dynamicElement = getDriver().findElement(localizador);
            boolean state = dynamicElement.isDisplayed();
            if (state == true) {
                System.out.println("Element present");
                return 1;
            } else {
                System.out.println("Element not present");
                return 0;
            }
        } catch (Exception e) {

            System.out.println("Error - Element not present " + e);
            return -1;
        }

    }

    public Integer busquedaDeElementoWE(WebElement localizador) {

        try {
            boolean state = localizador.isDisplayed();
            if (state == true) {
                System.out.println("Element present");
                return 1;
            } else {
                System.out.println("Element not present");
                return 0;
            }
        } catch (Exception e) {

            System.out.println("Error - Element not present " + e);
            return -1;
        }

    }

    public void scrollToElement(By localizador) {
        new Actions(getDriver()).moveToElement(find(localizador)).perform();
    }

    public String getTextLabel(By element) {
        return getDriver().findElement(element).getText();

    }

    public String getTextLabelWebElement(WebElement localizador) {
        String elemento = localizador.getText();
        return elemento;
    }

    public CSVReader dataCsv(String ruta) {
        CSVReader celdas = null;
        try {
            Reader archCSV = new FileReader(ruta);
            CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
            celdas = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
        } catch (Exception e) {
            System.out.println("Error en la lectura del archivo CSV : " + e);
        }
        return celdas;
    }

}
