Meta:

Narrative:
Como usuario de bancolombia
deseo poder visualizar las direcciones cercanas
a una ubicacion ingresada

Scenario: Busqueda de oficinas por ubicacion
Given dado que estoy en la pagina web de bancolombia
When cuando filtre por <direccion>
Then deberia poder visualizar las oficinas cercanas a dicha ubicacion

Examples:
|direccion|
|Mayorca Mega Plaza, Sabaneta - Antioquia, Colombia|