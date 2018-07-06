package com.api.campeonatofutebol.controller;

import com.api.campeonatofutebol.model.Partida;
import com.api.campeonatofutebol.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/api/partidas")
public class PartidaController {

    private final PartidaService partidaService;

    @Autowired
    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping("/{id}")
    public Partida buscarPor(@PathVariable Integer id) {
        return partidaService.buscaPor(id);
    }

    @PostMapping
    public ResponseEntity<?> cria(@Validated @RequestBody Partida partida) {

        Partida partidaSalva = this.partidaService.salva(partida);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(partidaSalva.getId())
                .toUri();

        return ResponseEntity.created(uri).body(partidaSalva);
    }


    @GetMapping ("/listatodos")
    public List<Partida> listaDePartidas() {
        return partidaService.todos();
    }


    @DeleteMapping ("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public @ResponseBody void excluir(@PathVariable Integer id) {
        partidaService.excluir(id);
    }


    @PutMapping ("/{id}")
    public ResponseEntity<Partida> atualiza(@PathVariable Integer id,
                                            @Validated @RequestBody Partida partida) {
        Partida partidaManager = partidaService.atualiza(id, partida);

        return ResponseEntity.ok(partidaManager);
    }

}
