Feature: Como usuario quiero tener la opcion que al precionar un boton active o desactive la ubicacion de mi posicion
		 
	Scenario: El GPS del telefono esta activado
		Given Presionar el boton para activar localizacion
		When GPS del telefono activado
		Then Mostrar ubicacion en la app.

	Scenario: El GPS del telefono esta desactivado
		Given Presiona el boton para activar localizacion
		When GPS del telefono desactivado
		Then Mostrar aviso indicando que el GPS esta desactivado.

