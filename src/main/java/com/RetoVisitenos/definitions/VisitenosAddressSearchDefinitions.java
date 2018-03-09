package com.RetoVisitenos.definitions;

import com.RetoVisitenos.steps.VisitenosAddressSearchSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;

public class VisitenosAddressSearchDefinitions {

    @Steps
    private VisitenosAddressSearchSteps visitenosAddressSearchSteps;

    @Given("dado que estoy en la pagina web de bancolombia")
    public void givenDadoQueEstoyEnLaPaginaWebDeBancolombia() {
        visitenosAddressSearchSteps.openPage();
    }

    @When("cuando filtre por <direccion>")
    public void whenCuandoFiltrePordireccion(@Named("direccion") String direccion) {
        visitenosAddressSearchSteps.irVisitanos();
        visitenosAddressSearchSteps.filter(direccion);
    }

    @Then("deberia poder visualizar las oficinas cercanas a dicha ubicacion")
    public void thenDeberiaPoderVisualizarLasOficinasCercanasADichaHubicaciondireccionMayorcaMegaPlazaSabanetaAntioquiaColombia() throws IOException {
        visitenosAddressSearchSteps.validarOficinas();
    }


}
