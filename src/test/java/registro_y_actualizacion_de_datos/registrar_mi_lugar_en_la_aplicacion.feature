Feature: como cliente deseo poder registrar mi local en la aplicación
	Scenario: el cliente desea registrar su local en la aplicación
		Given el cliente desea registrarse
		When el cliente crea un perfil con sus datos y el de su negocio
		Then el administrador valida los datos y procede a guardarlos en la base de datos