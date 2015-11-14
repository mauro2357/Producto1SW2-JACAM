package Localizacion;

import org.junit.Assert;

import Negocio.Localizacion.ubicacion;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class activarDesactivarUbicacion {
	ubicacion ubicacion = null;
	@Given("^Presionar el boton para activar localizacion$")
	public void Presionar_el_boton_para_activar_localizacion() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    ubicacion = new ubicacion();
	}

	@When("^GPS del telefono activado$")
	public void GPS_del_telefono_activado() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    Assert.assertFalse(ubicacion.gps());
	    
	}

	@Then("^Mostrar ubicacion en la app.$")
	public void Mostrar_ubicacion_en_la_app() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    Assert.assertEquals(ubicacion.getCoordenadas(), ubicacion.getCoordenadas());
	}


	@When("^GPS del telefono desactivado$")
	public void GPS_del_telefono_desactivado() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    Assert.assertFalse(ubicacion.gps());
	    
	}

	@Then("^Mostrar aviso indicando que el GPS esta desactivado.$")
	public void Mostrar_aviso_indicando_que_el_GPS_esta_desactivado() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    Assert.assertEquals("Active el GPS", ubicacion.getMensaje());
	}

}
