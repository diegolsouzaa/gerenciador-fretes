package com.gerenciador.services;

import com.gerenciador.dtos.FreteDTO;
import com.gerenciador.entities.Frete;
import com.gerenciador.repositories.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class FreteServices {

    @Autowired
    private FreteRepository freteRepository;

    public List<Frete> listar(){
        return freteRepository.findAll();
    }

    public Frete salvar(FreteDTO freteDTO) {
        Frete frete = new Frete();

        frete.setLocalDeEntrega(freteDTO.getLocalDeEntrega());
        frete.setQuantidade(freteDTO.getQuantidade());
        frete.setTransportadora(freteDTO.getTranspordora());
        frete.setProduto(freteDTO.getProduto());
        return freteRepository.save(frete);
    }

    public Frete buscar (Long id) throws Exception {
        Frete frete = freteRepository.findOne(id);
        if(frete==null){
            throw new Exception("Não existe esta viagem cadastrada");
        }

        return frete;
    }



}
