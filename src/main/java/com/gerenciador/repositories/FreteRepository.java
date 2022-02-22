package com.gerenciador.repositories;

import com.gerenciador.entities.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {

    Frete findByLocalDeEntrega(String localDeEntrega);
}
