Feature: Como usuario quiero tener un listado de las caracteristicas del lugar que quiero visitaro
	
	Scenario: El usuario consulta un lugar especifico y ya no existe
		Given El usuario va a consultar el lugar
		When El lugar ya no existe
		Then Se notifica que este lugar ya no existe
	Scenario: El usuario consulta un lugar especifico y encuentra sus caracteristicas
		Given El usuario va a consultar el lugar
		When Encuentra el lugar
		Then Visualiza sus caracteristicas
	Scenario: El usuario consulta un lugar y este ha cambiado su ubicacion	
	    Given El usuario consulta el lugar
	    When Encuentra el lugar pero este cambio su ubicacion
		Then Se notifica la nueva ubicacion y se visualizan sus caracteristicas
	Scenario: El usuario consulta un lugar especifico pero este no esta registrado en la aplicacion
	    Given El usuario consulta el lugar
	    When El lugar no esta registrado en la aplicacion
	    Then Se notifica que este lugar no ha sido registrado aun en la aplicacion
	Scenario: el usuario consulta un lugar que este cercano a el  
	    Given El usuario va a consultar el lugar
	    When Se ubican todos los lugares cercanos a el
	    Then Se notifica un listado de los lugares encontrados