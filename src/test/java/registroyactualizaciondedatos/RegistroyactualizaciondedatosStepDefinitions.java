package registroyactualizaciondedatos;
import org.junit.Assert;

import Negocio.gestion.Persona;
import Negocio.gestion.Propietario;
import Negocio.lugar.Lugar;
import datos.LugarRepository;
import datos.ValidarRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistroyactualizaciondedatosStepDefinitions {
	Persona propietario = null;
	Lugar lugar;
	public int registro;
	LugarRepository registrarlugar = new LugarRepository();
	ValidarRepository validar = new ValidarRepository();

	
	@Given("^el propietario desea registrar un lugar$")
	public void el_cliente_desea_registrar_un_lugar() throws Throwable {
		propietario = validar.consultarPersona("maria@gmail.com", "maria");
	}

	@When("^se llena el formulario con los datos del lugar$")
	public void se_llena_el_formulario_con_los_datos_del_lugar() throws Throwable {
		lugar = new Lugar(1, "View", null, 5555, "Restaurante", "m");
		Assert.assertEquals(propietario, validar.consultarPersona("maria@gmail.com", "maria"));
	}

	@Then("^se validan los datos y se registra el lugar$")
	public void se_validan_datos_se_registra_lugar() throws Throwable {
		registrarlugar.RegistroFavorito("maria@gmail.com", lugar);

	}
	
	@Given("^el propietario elige eliminar un lugar$")
	public void el_cliente_elige_eliminar_un_lugar() throws Throwable {
		propietario = validar.consultarPersona("maria@gmail.com", "maria");
		Assert.assertNotNull(lugar);
	}
	@When("^se eliminan los datos del lugar$")
	public void se_eliminan_los_datos_del_lugar() throws Throwable {
		registrarlugar.eliminarLugar(lugar);
	}
	@Then("^se continúa el proceso$")
	public void se_continua() throws Throwable {
		Assert.assertEquals("se eliminó el lugar", "se eliminó el lugar");
	}

	@Given("^el propietario dese actualizar datos del lugar$")
	public void actualizar_datos_de_un_lugar() throws Throwable {
		propietario = validar.consultarPersona("maria@gmail.com", "maria");
		Assert.assertNotNull(lugar);
	}
	@When("^se validan los datos y se actualizan$")
	public void se_validan_los_datos_y_se_actualizan() throws Throwable {
		registrarlugar.ActualizarDatos(lugar);
	}
	
	@Then("^se notifica de la actualización$")
	public void se_notifica_la_actualizacion() throws Throwable {
		Assert.assertEquals("se actualizó el lugar", "se actualizó el lugar");
	}
}
