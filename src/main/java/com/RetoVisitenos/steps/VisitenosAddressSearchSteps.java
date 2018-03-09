package com.RetoVisitenos.steps;

import com.RetoVisitenos.pages.VisitenosHomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;

import java.io.IOException;

public class VisitenosAddressSearchSteps extends ScenarioSteps{

    @Page
    private VisitenosHomePage visitenosHomePage;

    @Step
    public void openPage(){
        visitenosHomePage.open();
    }

    @Step
    public void filter(String direccion){
        visitenosHomePage.fillSearchFields(direccion);
    }

    @Step
    public void irVisitanos() {
        visitenosHomePage.irVisitanos();
    }


    public void validarOficinas() throws IOException {
        visitenosHomePage.validarOficinas();
    }
}
