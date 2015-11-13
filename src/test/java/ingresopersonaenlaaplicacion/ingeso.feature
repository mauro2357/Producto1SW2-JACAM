Feature: como persona quiero poder ingresar a la aplicación
	
	Scenario: la persona ingresa a la aplicación
       Given: el usuario o propietario ingresa
       When: se encuentra en la base de datos
       Then: ingresa como usuario o propietario y visualiza su información
    Scenario:la persona no se encuentra registrada
       Given: la persona desea ingresar a la aplicación
       When: no se encuentra en la base de datos
       Then: se sugiere a la persona que se registre
    

		
	