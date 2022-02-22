package com.gerenciador.controller;

import com.gerenciador.dtos.FreteDTO;
import com.gerenciador.entities.Frete;
import com.gerenciador.services.FreteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.gerenciador.responses.Response;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fretes")
public class GerenciadorFreteController {

    @Autowired
    private FreteServices freteService;

    @PostMapping(path = "/novo")
    public ResponseEntity<Response<Frete>> cadastrar (@Valid @RequestBody FreteDTO freteDTO, BindingResult result){

      Response <Frete> response = new Response<Frete>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Frete freteSalvo = this.freteService.salvar(freteDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(freteDTO.getId())
                .toUri();
        response.setData(freteSalvo);
        return ResponseEntity.created(location).body(response);


    }

    @GetMapping
    public ResponseEntity<List<Frete>> listar(){
        List<Frete> fretes = freteService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(fretes);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response<Frete>> buscar(@PathVariable("id") Long id) throws Exception {
        Frete frete = freteService.buscar(id);
        Response<Frete> response= new Response<Frete>();
        response.setData(frete);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
