package com.ilanalab.pageObjects.despegar;

import org.openqa.selenium.By;

import com.ilanalab.utils.Utils;
import com.opencsv.CSVReader;

import net.serenitybdd.core.pages.PageObject;

public class DespegarReservarCheckoutPage extends PageObject{

    By inputNombresA = By.xpath("//*[@id='a8h4w2n6qo0sv3klrnhi8i']");
    By inputApellidosA = By.xpath("//*[@id='3520q88hjwk7iugj7bbirx']");
    By selectNacionalidadA = By.xpath("//*[@id='traveler-nationality-0']");
    By inputNombresB = By.xpath("//*[@id='079s20z2m4yie7ynm43szhn']");
    By inputApellidosB = By.xpath("//*[@id='rd7ug8z5vzeus52eblqun']");
    By selectNacionalidadB = By.xpath("//*[@id='traveler-nationality-1']");
    By inputEmailVoucher = By.xpath("//*[@id='formData.contactData.mainEmailAddress']");
    By inputConfirmarEmailVoucher = By.xpath("//*[@id='formData.contactData.repeatMainEmailAddress']");
    By inputNumeroTelefono = By.xpath("//*[@id='formData.contactData.phones[0].number']");
    By inputNumeroDetarjeta = By.xpath("//*[@id='formData.paymentData.cardPayments[0].card.number']/div/input");
    By inputTitularTarjeta = By.xpath("//*[@id='formData.paymentData.cardPayments[0].card.holderName']/div/input");
    By inputVencimientoTarjeta = By.xpath("//*[@id='formData.paymentData.cardPayments[0].card.expirationDate']/div/input");
    By inputCodigoTarjeta = By.xpath("//*[@id='formData.paymentData.cardPayments[0].card.securityCode']/div/input");
    By inputDocumentoTitularTarjeta = By.xpath("//*[@id='formData.paymentData.cardPayments[0].cardHolderIdentification.number']/div/input");

    Utils utils = new Utils();

    public void llenarFormularioCheckout(String DataReservarDespegar){
        CSVReader csvReader = utils.dataCsv(DataReservarDespegar);
        String[] list = null;
        Integer contador = 0;
        try {
            while ((list = csvReader.readNext()) != null) {
                if (contador >= 1) {
                    try {
                        getDriver().findElement(inputNombresA).sendKeys(list[0]);
                        getDriver().findElement(inputApellidosA).sendKeys(list[1]);
                        utils.seleccionarListaTextoVisible(selectNacionalidadA, list[2]);
                        //getDriver().findElement(selectNacionalidadA).sendKeys(list[2]);
                        getDriver().findElement(inputNombresB).sendKeys(list[3]);
                        getDriver().findElement(inputApellidosB).sendKeys(list[4]);
                        utils.seleccionarListaTextoVisible(selectNacionalidadB, list[5]);
                        //getDriver().findElement(selectNacionalidadB).sendKeys(list[5]);
                        getDriver().findElement(inputEmailVoucher).sendKeys(list[6]);
                        getDriver().findElement(inputConfirmarEmailVoucher).sendKeys(list[6]);
                        getDriver().findElement(inputNumeroTelefono).sendKeys(list[7]);
                        getDriver().findElement(inputNumeroDetarjeta).sendKeys(list[8]);
                        getDriver().findElement(inputTitularTarjeta).sendKeys(list[9]);
                        getDriver().findElement(inputVencimientoTarjeta).sendKeys(list[10]);
                        getDriver().findElement(inputCodigoTarjeta).sendKeys(list[11]);
                        getDriver().findElement(inputDocumentoTitularTarjeta).sendKeys(list[12]);
                        
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
    
    
}
