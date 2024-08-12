package com.ilanalab.pageObjects.despegar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.ilanalab.utils.Utils;
import com.opencsv.CSVReader;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class DespegarBusquedaPage extends PageObject {

    Utils utils = new Utils();

    public void resultadoBusquedaAlojamiento(String dataDespegar) {
        CSVReader csvReader = utils.dataCsv(dataDespegar);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        utils.cambioDePestaña(1);
                        scrollPagina();
                        for (int i = 1; i <= 25; i++) {
                            WebElement nombreHotel = getDriver().findElement(By.xpath(
                                    "/html/body/aloha-app-root/aloha-results/div[2]/div/div/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div['"
                                            + i
                                            + "']//aloha-cluster-container-accommodation-info-container/div[1]/div/p"));
                            int elementoEsVisible = utils.busquedaDeElementoWE(nombreHotel);
                            if (elementoEsVisible == 1) {
                                String nombreHotelSTG = nombreHotel.getText();
                                WebElement precioHotel = getDriver().findElement(By.xpath(
                                        "/html/body/aloha-app-root/aloha-results/div[2]/div/div/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div['"
                                                + i
                                                + "']/aloha-cluster-container/div/div[3]/aloha-cluster-pricebox-container/div//div[1]/aloha-price-container/aloha-summary-price//span[2]"));
                                String precioHotelSTG = precioHotel.getText();
                                precioHotelSTG.replace(".", "");
                                int precioHotelINT = Integer.parseInt(precioHotelSTG);
                                int presupuestoHotel = Integer.parseInt(list[6]);
                                if (nombreHotelSTG.equals(list[5]) && precioHotelINT <= presupuestoHotel) {
                                    WebElement btnVerDetalle = getDriver().findElement(By.xpath(
                                            "/html/body/aloha-app-root/aloha-results/div[2]/div/div/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div['"
                                                    + i
                                                    + "']/aloha-cluster-container/div/div[3]/aloha-cluster-pricebox-container/div//div[2]/div/aloha-button/button"));
                                    Serenity.takeScreenshot();
                                    btnVerDetalle.click();
                                    break;
                                }
                            }
                        }
                        WebElement contenedorBusqueda = getDriver().findElement(By.xpath(
                                "/html/body/aloha-app-root/aloha-results/div[2]/div/div/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div[1]/aloha-cluster-container/div"));
                        int contenedorEsVisible = utils.busquedaDeElementoWE(contenedorBusqueda);
                        if (contenedorEsVisible == 1) {
                            for (int i = 1; i <= 25; i++) {
                                WebElement precioHotel = getDriver().findElement(By.xpath(
                                        "/html/body/aloha-app-root/aloha-results/div[2]/div/div/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div['"
                                                + i
                                                + "']/aloha-cluster-container/div/div[3]/aloha-cluster-pricebox-container/div//div[1]/aloha-price-container/aloha-summary-price//span[2]"));
                                int elementoEsVisible = utils.busquedaDeElementoWE(precioHotel);
                                if (elementoEsVisible == 1) {
                                    String precioHotelSTG = precioHotel.getText();
                                    int precioHotelINT = Integer.parseInt(precioHotelSTG);
                                    int presupuestoHotel = Integer.parseInt(list[6]);
                                    if (precioHotelINT <= presupuestoHotel) {
                                        WebElement btnVerDetalle = getDriver().findElement(By.xpath(
                                                "/html/body/aloha-app-root/aloha-results/div[2]/div/div/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div['"
                                                        + i
                                                        + "']/aloha-cluster-container/div/div[3]/aloha-cluster-pricebox-container/div//div[2]/div/aloha-button/button/em"));
                                        btnVerDetalle.click();
                                        Serenity.takeScreenshot();
                                        break;
                                    }

                                }
                            }
                        }

                    } catch (Exception e) {
                        System.out.println(
                                "No se encontraron hoteles acorde al presupuesto ***\n" + e);
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

    public void scrollPagina() {
        utils.scrollPagina("800");
    }

}
