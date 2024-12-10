package com.agenda2024.agenda2024.Services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agenda2024.agenda2024.DTOs.AgendaRequest;
import com.agenda2024.agenda2024.DTOs.AgendaResponse;

@RestController
@RequestMapping("agenda")
@CrossOrigin(origins = "http://localhost:4200")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

@GetMapping
public ResponseEntity<List<AgendaResponse>> getAgendas(){
    return ResponseEntity.ok(agendaService.getAgendas());
}

 @GetMapping("{id}")
 public ResponseEntity<AgendaResponse> getAgendaById(@PathVariable int id) {
 return ResponseEntity.ok(agendaService.getAgendaById(id));
 }

  @DeleteMapping("{id}")
 public ResponseEntity<Void> deleteAgendaById(@PathVariable int id) {
 this.agendaService.deleteAgendaById(id);

 return ResponseEntity.noContent().build();
 }

  @PostMapping
 public ResponseEntity<AgendaResponse> saveAgenda(@Validated @RequestBody AgendaRequest
agenda) {
    AgendaResponse newAgenda =this.agendaService.saveAgenda(agenda);
    URI location= ServletUriComponentsBuilder
                  .fromCurrentRequest()
                  .path("/{id}")
                  .buildAndExpand(newAgenda.Id())
                  .toUri();

        return ResponseEntity.created(location).body(newAgenda);
}

 @PutMapping("{id}")
 public ResponseEntity<Void> updateAgenda(@Validated @PathVariable int id, @RequestBody 
AgendaRequest agenda) {
 this.agendaService.updateAgenda(id, agenda);
    return ResponseEntity.ok().build();
}
}