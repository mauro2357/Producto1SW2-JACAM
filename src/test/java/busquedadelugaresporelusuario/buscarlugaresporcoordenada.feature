Feature: como usuario quiero tener la posibilidad de buscar los lugares por coordenadas
	
	Scenario: el usuario consulta una coordenada y el lugar ya no existe
       Given: el usuario consulta la coordenada
        When: no se encuentra el lugar en dicha coordenada
        Then: se notifica que no existe
    Scenario: el usuario consulta una coordenada y el lugar existe
       Given: el usuario consulta la coordenada
        When: encuentra el lugar en dicha coordenada
        Then: visualiza su información 
        

		
	