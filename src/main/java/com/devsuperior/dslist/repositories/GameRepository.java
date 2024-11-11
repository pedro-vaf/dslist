package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long>
/* É necessário colocar entre <> tipo da entidade idade e o tipo do ID da entidade */ {


}
