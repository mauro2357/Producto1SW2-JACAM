package registroyactualizaciondedatos;
import org.junit.Assert;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Negocio.registro_y_actualizacion_de_datos.Administrador;
import Negocio.registro_y_actualizacion_de_datos.Propietario;

public class RegistrarMiLugarEnLaAplicacionStepDefinitions {
	Propietario propietario;
	Administrador admin;
	@Given("^el cliente desea registrarse$")
	public void el_cliente_desea_registrarse() throws Throwable {
		propietario=new Propietario();

	}

	@When("^el cliente crea un perfil con sus datos y el de su negocio$")
	public void el_cliente_crea_un_perfil_con_sus_datos_y_el_de_su_negocio() throws Throwable {
		propietario.crearPerfil();
	    
	}

	@Then("^el administrador valida los datos y procede a guardarlos en la base de datos$")
	public void el_administrador_valida_los_datos_y_procede_a_guardarlos_en_la_base_de_datos() throws Throwable {
		admin=new Administrador();
		Assert.assertEquals("Cliente registrado", admin.registrar_clientes(propietario));
		
	}

}
