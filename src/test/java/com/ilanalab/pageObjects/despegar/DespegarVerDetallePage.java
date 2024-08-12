package com.ilanalab.pageObjects.despegar;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;

public class DespegarVerDetallePage extends PageObject{

    By btnVerHabitaciones = By.xpath("/html/body/aloha-app-root/aloha-detail/div[1]/div[3]/div[2]/div/aloha-infobox-container/aloha-infobox-wrapper-container/div/div[2]/div/div/div[2]/aloha-button/button/em");
    By btnReservarAhora = By.xpath("//*[@id='roompacks-container-wrapper']/aloha-roompacks-container/aloha-roompacks-grid-container/div/div/aloha-roompacks-group-container[1]/div[2]/aloha-roompack-container[1]//div[3]/aloha-roompack-next-step-container/aloha-next-step-button/div/aloha-button/button/em[contains(text(), 'Reservar ahora')]");
    
    public void verHabitaciones(){
        getDriver().findElement(btnVerHabitaciones).click();

    }

    public void reserverAhora(){
        getDriver().findElement(btnReservarAhora).click();
        
    }


}
