Feature: Como usuario quiero tener un listado de las caracteristicas del lugar que quiero visitar
	
	Scenario: El usuario consulta un lugar especifico y ya no existe
		Given El usuario va a consultar el lugar
		When El lugar ya no existe
		Then Se notifica que este lugar ya no existe
	Scenario: El usuario consulta un lugar especifico y encuentra sus caracteristicas
		Given El usuario va a consultar el lugar
		When Encuentra el lugar
		Then Visualiza sus caracteristicas
	Scenario: el usuario consulta un lugar y este ha cambiado su ubicaci�n
		Given: el usuario consulta el lugar
		When: encuentra el lugar pero este cambio su ubicaci�n
		Then: se notifica la nueva ubicaci�n y se visualizan sus caracter�sticas
	


