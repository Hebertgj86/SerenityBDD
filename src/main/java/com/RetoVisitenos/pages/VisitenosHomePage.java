package com.RetoVisitenos.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@DefaultUrl("https://www.grupobancolombia.com/wps/portal/personas")
public class VisitenosHomePage extends PageObject {

    //region WebElements
    @FindBy(xpath = "//*[@id='footer-content']/div[1]/div/div/div[4]/h3")
    private WebElementFacade lblVisitanos;

    @FindBy(xpath = ".//*[@id='footer-content']/div[1]/div/div/div[4]/div/a/img")
    //@FindBy(xpath = "//*[@id='footer-content']/div[1]/div/div/div[4]/div/a/img")
    private WebElementFacade btnVisitanos;

    @FindBy(xpath = ".//*[@id='footer-content']/div[1]/div/div/div[4]/p")
    private WebElementFacade lblBuscaNuestroProximoSitio;

    @FindBy(xpath = ".//*[@id='srch-term']")
    private WebElementFacade txtBuscarDireccion;

    @FindBy(xpath = ".//*[@id='tab1']/div[1]/div[6]/div[1]/div/div[2]/p")
    private WebElementFacade txtNumerodireccion;

    @FindBy(id = "buscar-button")
    private WebElementFacade searchButton;

    public VisitenosHomePage(WebDriver driver) {
        super(driver);
    }
    //endregion

    @WhenPageOpens
    public void waitUntilMainElementsAppears() {
        getDriver().manage().window().maximize();
    }

    public void fillSearchFields(String direccion) {
        txtBuscarDireccion.typeAndEnter(direccion);
    }

    public void irVisitanos() {
        waitFor(btnVisitanos).shouldBePresent();
        obtenerFoco(lblVisitanos);
        waitABit(1600);
        btnVisitanos.click();
        waitFor(lblVisitanos).shouldContainText("Visítanos");
    }

    public void validarOficinas() throws IOException {
        txtNumerodireccion.shouldBePresent();
        obtenerFoco(txtNumerodireccion);
        waitABit(1600);
        txtNumerodireccion.click();
        waitFor(txtNumerodireccion).shouldContainText("CALLE 51 SUR # 48 - 57");
        escribeFichero(txtNumerodireccion.getText());
    }


    public void obtenerFoco(WebElementFacade elemento){
        new Actions(getDriver()).moveToElement(elemento).perform();

        //new Actions(driver).moveToElement(elemento).perform();
    }

    public static void escribeFichero(String direccion) throws IOException {
        String content = direccion;
        String path = "C:\\Users\\hergutie\\Downloads\\direccion.txt";
        Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE);
    }
}
