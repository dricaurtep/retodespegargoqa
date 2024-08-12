package com.ilanalab.pageObjects.despegar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.ilanalab.utils.Utils;
import com.opencsv.CSVReader;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class DespegarAlojamientoPage extends PageObject {

    public By inputDestino = By.xpath("//*[@id='searchbox-v2']//div[3]/div[1]/div/div/div/input");
    public By inputFechaSalidaRangoA = By
            .xpath("//*[@id='searchbox-v2']/div/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div");
    public By datePicker = By.xpath("//*[@id='component-modals']/div[1]/div[1]");
    public By monthPicker = By.xpath("//*[@id='component-modals']/div[1]/div[1]/div/div[1]/div[3]");
    public By calendarFooter = By.xpath("//*[@id='component-modals']/div[1]/div[2]");
    public By btnAplicarCalendar = By.xpath("//*[@id='component-modals']/div[1]/div[2]/div[1]/button/em");
    public By btnBuscar = By.xpath("//*[@id='searchbox-v2']/div/div/div/div/div/div[3]/button");

    Utils utils = new Utils();

    public void buscarAlojamiento(String dataDespegar) {
        CSVReader csvReader = utils.dataCsv(dataDespegar);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        utils.esperaMilis(2000);
                        ingresarDestino(list[2]);
                        utils.esperaMilis(2000);
                        seleccionarFecha(list[3], list[4]);
                        Serenity.takeScreenshot();
                        buscarAlojamiento();
                    } catch (Exception e) {
                        System.out.println(
                                "Error al realizar busqueda de alojamiento***\n" + e);
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

    public void ingresarDestino(String destino) {
        getDriver().findElement(inputDestino).click();
        getDriver().findElement(inputDestino).sendKeys(destino);
        WebElement autocompletarBusqueda = getDriver().findElement(By.xpath("/html/body/div[10]/div/div/ul/div[1]/div[2]/div[1]"));
        autocompletarBusqueda.click();
    }

    public void seleccionarFecha(String fechaSalidaA, String fechaSalidaB) {
        getDriver().findElement(inputFechaSalidaRangoA).click();
        utils.esperaMilis(2000);
        WebElement pickDayA = getDriver()
                .findElement(By.xpath("//div[@data-month = '2024-08']//div[contains(text(), '" + fechaSalidaA + "')]"));
        pickDayA.click();
        WebElement pickDayB = getDriver()
                .findElement(By.xpath("//div[@data-month = '2024-08']//div[contains(text(), '" + fechaSalidaB + "')]"));
        pickDayB.click();
        getDriver().findElement(calendarFooter).click();
        getDriver().findElement(btnAplicarCalendar).click();

    }

    public void buscarAlojamiento() {
        getDriver().findElement(btnBuscar).click();
    }

}
