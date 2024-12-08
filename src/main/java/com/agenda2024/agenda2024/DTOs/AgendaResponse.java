package com.agenda2024.agenda2024.DTOs;

public record AgendaResponse(
     Long Id,
     String nome,
	 String compromisso,
	 String dia,
     String horario,
     String localizacao
) {
    
}
