package com.ilanalab.pageObjects.despegar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.ilanalab.utils.Utils;
import com.opencsv.CSVReader;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class DespegarHomePage extends PageObject {

    Utils utils = new Utils();

    public void ingresoADespegar() {
        //Drivers.ChromeDriver();
        String urlDespegar = "https://www.despegar.com.co/";
        getDriver().get(urlDespegar);
        Serenity.takeScreenshot();
        //Driver.getDriver().get(urlDespegar);
    }

    public void elegirServicio(String dataDespegar) {
        CSVReader csvReader = utils.dataCsv(dataDespegar);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        utils.esperaMilis(8000);
                        WebElement tipoDeServicio = getDriver().findElement(
                                By.xpath("//li[1]/a/div/label[contains(text(), '" + list[0] + "')]"));
                        //utils.forzarClickJS(tipoDeServicio);
                        tipoDeServicio.click();
                        Serenity.takeScreenshot();
                        //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        
                    } catch (Exception e) {
                        System.out.println(
                                "Error al ingresar al modulo de alojamiento***\n" + e);
                        contador++;
                    }
                } else {
                    contador++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura del archivo CSV ***\n" + e);
        }

    }

}
