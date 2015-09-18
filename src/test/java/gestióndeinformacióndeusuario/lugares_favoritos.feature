Feature: como usuario quiero que mis lugares favoritos se almacenen en un botón
	Scenario: el usuario consulta un lugar y este se almacena en su lista
		Given el usuario consulta un lugar
		When encuentra el lugar y se almacena en su lista de favoritos
		Then visualiza con mayor facilidad la información
	Scenario: el usuario consulta un lugar y éste ya se encuentra almacenado en su lista de favoritos
		Given el usuario consulta un lugar
		When encuentra el lugar y ya pertenece a su lista 
		Then visualiza la información del lugar específico	