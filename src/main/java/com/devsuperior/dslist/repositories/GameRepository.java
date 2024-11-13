package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.devsuperior.dslist.projections.GameMinProjection;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long>
/* É necessário colocar entre <> tipo da entidade idade e o tipo do ID da entidade */ {

    /* Obs.: Quando se usa um nativeQuery o resultado da consulta precisa ser uma
     interface, comumente chamado de projection  */
    /* Consulta costumiza SQL */
    @Query(nativeQuery = true /* Condição para consulta SQL funcionar */, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId /* parâmetro interno */
		ORDER BY tb_belonging.position
		""")
    List<GameMinProjection> searchByList(Long listId); /* parâmetro da busca */
}
