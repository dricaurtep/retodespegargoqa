Feature: Validar las funcionalidades de la pagina Despegar
    Como [PO] quiero validar la funcionalidad de la pagina despegar

    Background:
        Given Ingreso a la pagina de despegar

    @Validacion_servicio_de_alojamiento
    Scenario: Validar el servicio de alojamiento
        When Ingreso al modulo de alojamiento y realizo la busqueda de un destino
        And Valido si el hotel que busco se encuentra dentro del presupuesto y lo elijo si no lo esta selecciono uno que este dentro del presupuesto
        And Ingreso a los detalles del hotel seleccionado y reservo la habitacion
        Then Realizo el proceso de checkout 
    
    @Validacion_servicio_de_vuelos
    Scenario: Validar el servicio de vuelos
        When Ingreso al modulo de vuelos y realizo la busqueda de un vuelo
        And Valido si el vuelo que busco se encuentra dentro del presupuesto y lo elijo si no lo esta selecciono uno que este dentro del presupuesto
        And Veo los detalles del vuelo seleccionado y reservo el vuelo
        Then Realizo el proceso de checkout 

    