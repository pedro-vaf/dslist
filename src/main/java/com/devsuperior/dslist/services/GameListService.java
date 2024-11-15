package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List <GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    @Transactional /* Garante que será executado */
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        /* Remove um elemento da lista na posição de origem */
        GameMinProjection obj = list.remove(sourceIndex);

        /* Adciona o elemento removido na posição de destino */
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        /* Se a posição de origem for menor do que a posição de destino, o valor
        minímo será a posição de origem, caso contrário o valor mínimo será a posição
        de destino - condicional ternária */

        int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;
        /* Se a posição de origem for maior do que a posição de destino, o valor
        máximo será a posição de origem, caso contrário o valor máximo será a posição
        de destino - condicional ternária */

        for (int icont = min; icont <= max; icont = icont + 1){
            gameListRepository.updateBelongingPosition(listId, list.get(icont).getId(), icont);
        }
    }
}
