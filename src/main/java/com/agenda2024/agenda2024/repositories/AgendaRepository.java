package com.agenda2024.agenda2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda2024.agenda2024.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda,Long>{
    
}
