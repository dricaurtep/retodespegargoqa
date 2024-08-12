package com.ilanalab.definitions.despegar;

import com.ilanalab.steps.despegar.ValidacionServicioAlojamientoSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidacionServicioAlojamientoDefinitions {

    ValidacionServicioAlojamientoSteps validacionServicioAlojamientoSteps = new ValidacionServicioAlojamientoSteps();


    @Given("Ingreso a la pagina de despegar")
    public void ingresoALaPaginaDeDespegar() {
        validacionServicioAlojamientoSteps.ingresoALaPaginaDeDespegar();
    }

    @When("Ingreso al modulo de alojamiento y realizo la busqueda de un destino")
    public void ingresoAlModuloDeAlojamientoYRealizoLaBusquedaDeUnDestino() {
        validacionServicioAlojamientoSteps.ingresoAlModuloDeAlojamientoYRealizoLaBusquedaDeUnDestino();
    }

    @And("Valido si el hotel que busco se encuentra dentro del presupuesto y lo elijo si no lo esta selecciono uno que este dentro del presupuesto")
    public void validoSiElHotelQueBuscoSeEncuentraDentroDelPresupuestoYLoElijoSiNoLoEstaSeleccionoUnoQueEsteDentroDelPresupuesto() {
        validacionServicioAlojamientoSteps.validoSiElHotelQueBuscoSeEncuentraDentroDelPresupuestoYLoElijoSiNoLoEstaSeleccionoUnoQueEsteDentroDelPresupuesto();
    }

    @And("Ingreso a los detalles del hotel seleccionado y reservo la habitacion")
    public void ingresoALosDetallesDelHotelSeleccionadoYReservoLaHabitacion() {
        validacionServicioAlojamientoSteps.ingresoALosDetallesDelHotelSeleccionadoYReservoLaHabitacion();
    }

    @Then("Realizo el proceso de checkout")
    public void realizoElProcesoDeCheckout() {
        validacionServicioAlojamientoSteps.realizoElProcesoDeCheckout();
    }

}
