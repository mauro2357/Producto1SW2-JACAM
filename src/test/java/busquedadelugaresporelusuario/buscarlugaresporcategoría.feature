Feature: como usuario quiero tener la posibilidad de buscar los lugares por categor�a
		 
	Scenario: el usuario consulta una categor�a y a esta no tiene lugares registrados
       Given: el usuario consulta la categor�a
        When: encuentra la categor�a pero no lugares en ella
        Then: se invalida la acci�n


	Scenario: el usuario consulta una categor�a y encuentra los lugares
       Given: el usuario consulta la categor�a
        When: encuentra la categor�a con sus lugares respectivos
        Then: visualiza la informaci�n
    
