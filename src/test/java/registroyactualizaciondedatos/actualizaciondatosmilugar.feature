Feature: como propietario deseo actualizar los datos de mis lugares
	Scenario: El propietario desea atualizar los datos del lugar
		Given el propietario desea actualizar datos
		When el propietario llena el nuevo formulario
		Then se validan los datos y se actualizan en la base de datos
		
	Scenario: el propietario desea eliminar un lugar de la aplicacion
		Given el propietario desea eliminar un lugar 
		When el propietario proporciona los datos del lugar a eliminar
		Then se validan los datos y se elmina el lugar especificado
		
	