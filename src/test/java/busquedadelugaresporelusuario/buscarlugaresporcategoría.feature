Feature: como usuario quiero tener la posibilidad de buscar los lugares por categoría
		 
	Scenario: el usuario consulta una categoría y a esta no tiene lugares registrados
       Given: el usuario consulta la categoría
        When: encuentra la categoría pero no lugares en ella
        Then: se invalida la acción


	Scenario: el usuario consulta una categoría y encuentra los lugares
       Given: el usuario consulta la categoría
        When: encuentra la categoría con sus lugares respectivos
        Then: visualiza la información
    
