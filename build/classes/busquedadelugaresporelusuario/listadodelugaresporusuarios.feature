Feature: Como usuario quiero tener un listado de las caracteristicas del lugar que quiero visitar
	
	Scenario: el usuario consulta los lugares pero no se encuentra ninguno en la aplicaci�n
		Given: el usuario va a consultar los lugares
		When: los lugares no existen
		Then: se notifica que no hay lugares

	Scenario: el usuario consulta los lugares y encuentra sus caracter�sticas
		Given: el usuario va a consultar los lugares
		When: encuentra los lugares
		Then: visualiza sus caracter�sticascas
     


	


