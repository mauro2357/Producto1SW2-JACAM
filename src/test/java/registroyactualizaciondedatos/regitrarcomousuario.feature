Feature: como persona deseo poder registrarme
	Scenario: la persona desea registrarse como usuario en la aplicaci�n
		Given la persona desea registrarse
		When el persona crea un perfil con sus datos
		Then el administrador valida los datos y procede a guardarlos en la base de datos
		
	Scenario: la persona desea registrarse como usuario en la aplicaci�n pero �ste ya existe
		Given la persona desea registrarse 
		When la persona ya existe como usuario
		Then se notifica a la persona que su usuario ya est� creado
		
	Scenario: la persona desea poder ingresar a la aplicaci�n luego de registrarse
		Given la persona se registra
		When se validan los datos
		Then el nuevo usuario puede ingresar a la aplicaci�n
		