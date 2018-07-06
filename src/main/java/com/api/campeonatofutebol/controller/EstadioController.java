package com.api.campeonatofutebol.controller;

import com.api.campeonatofutebol.model.Estadio;
import com.api.campeonatofutebol.service.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (("/api/estadios"))
public class EstadioController {

    private final EstadioService estadioService;

    @Autowired
    public EstadioController(EstadioService estadioService) {
        this.estadioService = estadioService;
    }

    @GetMapping("/{id}")
    public Estadio buscarPor(@PathVariable Integer id) {
        return estadioService.buscaPor(id);
    }

    @PostMapping
    public ResponseEntity<?> cria(@Validated @RequestBody Estadio estadio) {

        Estadio estadioSalva = this.estadioService.salva(estadio);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(estadioSalva.getId())
                .toUri();

        return ResponseEntity.created(uri).body(estadioSalva);
    }

    @GetMapping ("/buscapornome")
    public Estadio buscaPeloNome(@RequestParam String nome) {
        return estadioService.buscarPor(nome);
    }

    @GetMapping ("/listapornome")
    public List<Estadio> buscarPeloNome(@RequestParam String nome) {
        return estadioService.listarPor(nome);
    }

    @GetMapping ("/listatodos")
    public List<Estadio> listaDeEstadios() {
        return estadioService.todos();
    }


    @DeleteMapping ("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public @ResponseBody void excluir(@PathVariable Integer id) {
        estadioService.excluir(id);
    }


    @PutMapping ("/{id}")
    public ResponseEntity<Estadio> atualiza(@PathVariable Integer id,
                                            @Validated @RequestBody Estadio estadio) {
        Estadio estadioManager = estadioService.atualiza(id, estadio);

        return ResponseEntity.ok(estadioManager);
    }


    @PutMapping ("/{id}/ativo")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void atualizarAtributoAtivo (@PathVariable Integer id, @RequestBody boolean ativo) {
        estadioService.atualizarAtributoAtivo(id, ativo);
    }

}
