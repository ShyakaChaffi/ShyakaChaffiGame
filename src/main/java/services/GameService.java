package services;

import domain.Game;
import repositories.JDBC.GameJDBCRepository;
import repositories.JPA.GameJPARepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class GameService {

    //    private GameJDBCRepository gameJDBCRepository = GameJDBCRepository.getInstance();
    @Inject
    private GameJPARepository gameJPARepository;

    public Game findGameById(int id){
//        return gameJDBCRepository.getGame(id);
        return gameJPARepository.findGameById(id);
    }

    public Game findGameByName(String gameName) {
//        return gameJDBCRepository.getGameByName(gameName);
        return gameJPARepository.findGameByName(gameName);
    }

    public List<Game> findAllGames() {
//        return gameJDBCRepository.getAllGames();
        return gameJPARepository.findAllGames();
    }
}

