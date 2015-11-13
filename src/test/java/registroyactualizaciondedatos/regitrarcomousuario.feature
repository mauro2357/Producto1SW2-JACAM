Feature: como persona deseo poder registrarme
	Scenario: la persona desea registrarse como usuario en la aplicación
		Given la persona desea registrarse
		When el persona crea un perfil con sus datos
		Then el administrador valida los datos y procede a guardarlos en la base de datos
		
	Scenario: la persona desea registrarse como usuario en la aplicación pero éste ya existe
		Given la persona desea registrarse 
		When la persona ya existe como usuario
		Then se notifica a la persona que su usuario ya está creado
		
	Scenario: la persona desea poder ingresar a la aplicación luego de registrarse
		Given la persona se registra
		When se validan los datos
		Then el nuevo usuario puede ingresar a la aplicación
		