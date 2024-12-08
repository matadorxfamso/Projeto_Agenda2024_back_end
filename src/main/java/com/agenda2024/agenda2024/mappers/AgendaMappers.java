package com.agenda2024.agenda2024.mappers;

import com.agenda2024.agenda2024.DTOs.AgendaRequest;
import com.agenda2024.agenda2024.DTOs.AgendaResponse;
import com.agenda2024.agenda2024.entities.Agenda;

public class AgendaMappers {public static Agenda toEntity(AgendaRequest request) {
    Agenda agenda = new Agenda();
     agenda.setNome(request.nome());
     agenda.setCompromisso(request.compromisso());
     agenda.setDia(request.dia());
     agenda.setHorario(request.horario());
     agenda.setLocalizacao(request.localizacao());
     return agenda;
     }
     public static AgendaResponse toDTO(Agenda agenda) {
     return new AgendaResponse(agenda.getId(), 
    agenda.getNome(),
     agenda.getCompromisso(),
      agenda.getDia(),
      agenda.getHorario(),
      agenda.getLocalizacao());
     }
     }