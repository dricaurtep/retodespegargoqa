package com.ilanalab.steps.despegar;

import com.ilanalab.pageObjects.despegar.DespegarAlojamientoPage;
import com.ilanalab.pageObjects.despegar.DespegarBusquedaPage;
import com.ilanalab.pageObjects.despegar.DespegarHomePage;
import com.ilanalab.pageObjects.despegar.DespegarReservarCheckoutPage;
import com.ilanalab.pageObjects.despegar.DespegarVerDetallePage;

public class ValidacionServicioAlojamientoSteps {

    DespegarHomePage despegarHomePage = new DespegarHomePage();
    DespegarAlojamientoPage despegarAlojamientoPage = new DespegarAlojamientoPage();
    DespegarBusquedaPage despegarBusquedaPage = new DespegarBusquedaPage();
    DespegarVerDetallePage despegarVerDetallePage = new DespegarVerDetallePage();
    DespegarReservarCheckoutPage despegarReservarCheckoutPage = new DespegarReservarCheckoutPage();

    String rutaDataAlojamientoDespegar = "data\\DataAlojamientoDespegar.csv";
    String rutaDataReservaDespegar = "data\\DataReservaDespegar.csv";

    public void ingresoALaPaginaDeDespegar() {
        despegarHomePage.ingresoADespegar();
    }

    public void ingresoAlModuloDeAlojamientoYRealizoLaBusquedaDeUnDestino() {
        despegarHomePage.elegirServicio(rutaDataAlojamientoDespegar);
        despegarAlojamientoPage.buscarAlojamiento(rutaDataAlojamientoDespegar);
    }

    public void validoSiElHotelQueBuscoSeEncuentraDentroDelPresupuestoYLoElijoSiNoLoEstaSeleccionoUnoQueEsteDentroDelPresupuesto() {
        despegarBusquedaPage.resultadoBusquedaAlojamiento(rutaDataAlojamientoDespegar);
    }

    public void ingresoALosDetallesDelHotelSeleccionadoYReservoLaHabitacion() {
        despegarVerDetallePage.verHabitaciones();
        despegarVerDetallePage.reserverAhora();
    }

    public void realizoElProcesoDeCheckout() {
        despegarReservarCheckoutPage.llenarFormularioCheckout(rutaDataReservaDespegar);
    }


    
}
