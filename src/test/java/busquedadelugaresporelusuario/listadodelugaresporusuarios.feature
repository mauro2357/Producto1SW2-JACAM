Feature: Como usuario quiero tener un listado de las caracteristicas del lugar que quiero visitaro
	
	Scenario: El usuario consulta un lugar especifico y ya no existe
		Given El usuario va a consultar el lugar
		When El lugar ya no existe
		Then Se notifica que este lugar ya no existe
	Scenario: El usuario consulta un lugar especifico y encuentra sus caracteristicas
		Given El usuario va a consultar el lugar
		When Encuentra el lugar
		Then Visualiza sus caracteristicas
	Scenario: el usuario consulta un lugar que este cercano a el  
	    Given El usuario va a consultar el lugar
	    When Se ubican todos los lugares cercanos a el
	    Then Se notifica un listado de los lugares encontrados