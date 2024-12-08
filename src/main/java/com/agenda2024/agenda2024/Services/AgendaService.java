package com.agenda2024.agenda2024.Services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda2024.agenda2024.DTOs.AgendaRequest;
import com.agenda2024.agenda2024.DTOs.AgendaResponse;
import com.agenda2024.agenda2024.entities.Agenda;
import com.agenda2024.agenda2024.mappers.AgendaMappers;
import com.agenda2024.agenda2024.repositories.AgendaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;
    public List<AgendaResponse>getAgendas(){
        List<Agenda> Agenda = agendaRepository.findAll();
        return Agenda.stream()
                      .map(a -> AgendaMappers.toDTO(a))
                      .collect(Collectors.toList());
    }
    public AgendaResponse getAgendaById(long id) {
        Agenda agenda = agendaRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException("Aluno não cadastrado")
        );
        return AgendaMappers.toDTO(agenda);
    }
    public void deleteAgendaById(long id) {
        if (this.agendaRepository.existsById(id)) {
        this.agendaRepository.deleteById(id);
        }
        else {
        throw new EntityNotFoundException("pessoa não registrada");
        }
        }
        public AgendaResponse saveAgenda(AgendaRequest request) {
        Agenda agenda = AgendaMappers.toEntity(request);
        return 
       AgendaMappers.toDTO(this.agendaRepository.save(agenda));
        }
        public void updateAgenda(long id, AgendaRequest request) {
        try {
        Agenda aux = agendaRepository.getReferenceById(id);
        aux.setNome(request.nome());
        aux.setCompromisso(request.compromisso());
        aux.setDia(request.dia());
        aux.setHorario(request.horario());
        aux.setLocalizacao(request.localizacao());
        this.agendaRepository.save(aux);
        } catch (EntityNotFoundException e) {
        throw new EntityNotFoundException("pessoa não registrada");
        }
        }
    }