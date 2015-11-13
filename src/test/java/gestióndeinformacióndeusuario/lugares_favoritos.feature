Feature: Como usuario deseo poder administrar mis lugares favoritos

	Scenario: el usuario consulta un lugar y este se almacena en su lista
		Given el usuario consulta un lugar
		When encuentra el lugar y se almacena en su lista de favoritos
		Then visualiza con mayor facilidad la información
		
	Scenario: el usuario desea eliminar un lugar de su lista de favoritos
		Given: el usuario desea eliminar el lugar
		When: elige el lugar a eliminar 
		Then: el lugar se elimina
