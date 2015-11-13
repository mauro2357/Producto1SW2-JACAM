Feature: como usuario quiero tener la posibilidad de buscar los lugares por su respectivo nombre
	
	Scenario: el usuario consulta el lugar por su nombre y esta no existe
       Given: el usuario consulta el lugar
        When: no se encuentra el lugar
        Then: se notifica ya no existe
    Scenario: el usuario consulta el lugar por su nombre y este existe
       Given: el usuario consulta el lugar
        When: encuentra el lugar
        Then: visualiza su información 
        

		
	