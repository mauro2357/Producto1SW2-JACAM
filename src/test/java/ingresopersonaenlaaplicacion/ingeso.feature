Feature: como persona quiero poder ingresar a la aplicaci�n
	
	Scenario: la persona ingresa a la aplicaci�n
       Given: el usuario o propietario ingresa
       When: se encuentra en la base de datos
       Then: ingresa como usuario o propietario y visualiza su informaci�n
    Scenario:la persona no se encuentra registrada
       Given: la persona desea ingresar a la aplicaci�n
       When: no se encuentra en la base de datos
       Then: se sugiere a la persona que se registre
    

		
	