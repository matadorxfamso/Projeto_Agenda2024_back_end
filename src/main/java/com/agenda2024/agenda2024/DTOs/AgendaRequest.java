package com.agenda2024.agenda2024.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgendaRequest( 
@NotNull(message = "Nome não pode ser nulo")
String nome,
@NotBlank(message = "Compromisso não pode ser nulo")
String compromisso,
@NotBlank(message = "Dia não pode ser nulo")
String dia,
@NotBlank(message = "Horario não pode ser nulo")
String horario,
@NotBlank(message = "Localizacao não pode ser nulo")
String localizacao
) {
    
}
