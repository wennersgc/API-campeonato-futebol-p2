package com.api.campeonatofutebol.controller;

import com.api.campeonatofutebol.model.Campeonato;
import com.api.campeonatofutebol.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/api/campeonatos")
public class CampeonatoController {

    private final CampeonatoService campeonatoService;

    @Autowired
    public CampeonatoController(CampeonatoService campeonatoService) {
        this.campeonatoService = campeonatoService;
    }

    @GetMapping("/{id}")
    public Campeonato buscarPor(@PathVariable Integer id) {
        return campeonatoService.buscaPor(id);
    }

    @PostMapping
    public ResponseEntity<?> cria(@Validated @RequestBody Campeonato campeonato) {

        Campeonato campeonatoSalva = this.campeonatoService.salva(campeonato);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(campeonatoSalva.getId())
                .toUri();

        return ResponseEntity.created(uri).body(campeonatoSalva);
    }

    @GetMapping ("/buscapornome")
    public Campeonato buscaPeloNome(@RequestParam String nome) {
        return campeonatoService.buscarPor(nome);
    }

    @GetMapping ("/listatodos")
    public List<Campeonato> listaDeCampeonatos() {
        return campeonatoService.todos();
    }


    @DeleteMapping ("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public @ResponseBody void excluir(@PathVariable Integer id) {
        campeonatoService.excluir(id);
    }


    @PutMapping ("/{id}")
    public ResponseEntity<Campeonato> atualiza(@PathVariable Integer id,
                                            @Validated @RequestBody Campeonato campeonato) {
        Campeonato campeonatoManager = campeonatoService.atualiza(id, campeonato);

        return ResponseEntity.ok(campeonatoManager);
    }


    @PutMapping ("/{id}/ativo")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void atualizarAtributoAtivo (@PathVariable Integer id, @RequestBody boolean ativo) {
        campeonatoService.atualizarAtributoAtivo(id, ativo);
    }

}
