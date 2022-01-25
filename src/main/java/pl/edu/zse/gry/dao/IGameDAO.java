package pl.edu.zse.gry.dao;

import pl.edu.zse.gry.model.Game;

import java.util.List;
import java.util.Optional;

public interface IGameDAO {
    List<Game> getAllConsoles();
    List<Game> getGamesByConsole(Game.Console console);
    void persistGame(Game game);
    Optional<Game> getGameById(int id);
}
