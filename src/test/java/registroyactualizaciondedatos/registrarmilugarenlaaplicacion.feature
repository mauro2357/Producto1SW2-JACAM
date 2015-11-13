Feature: como propietario deseo poder registrar mi local en la aplicación
	Scenario: el propietario desea registrar su local en la aplicación
		Given el propietario desea registrarse
		When el cliente crea un perfil con sus datos y el de su negocio
		Then el administrador valida los datos y procede a guardarlos en la base de datos