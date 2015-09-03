package registro_y_actualizacion_de_datos;
import org.junit.Assert;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Negocio.registro_y_actualizacion_de_datos.Admin;
<<<<<<< HEAD
import Negocio.registro_y_actualizacion_de_datos.Propietario;


public class registrar_mi_lugar_en_la_aplicacionStepDefinitions {
	Propietario cliente;
	Admin admin;
	@Given("^el cliente desea registrarse$")
	public void el_cliente_desea_registrarse() throws Throwable {
		cliente=new Propietario();
=======
import Negocio.registro_y_actualizacion_de_datos.Cliente;


public class registrar_mi_lugar_en_la_aplicacionStepDefinitions {
	Cliente cliente;
	Admin admin;
	@Given("^el cliente desea registrarse$")
	public void el_cliente_desea_registrarse() throws Throwable {
		cliente=new Cliente();
>>>>>>> origin/master
	    
	}

	@When("^el cliente crea un perfil con sus datos y el de su negocio$")
	public void el_cliente_crea_un_perfil_con_sus_datos_y_el_de_su_negocio() throws Throwable {
		cliente.crearPerfil();
	    
	}

	@Then("^el administrador valida los datos y procede a guardarlos en la base de datos$")
	public void el_administrador_valida_los_datos_y_procede_a_guardarlos_en_la_base_de_datos() throws Throwable {
		admin=new Admin();
		Assert.assertEquals("Cliente registrado", admin.registrar(cliente));
		
	}

}
