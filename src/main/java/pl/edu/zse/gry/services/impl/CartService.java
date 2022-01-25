package pl.edu.zse.gry.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.zse.gry.dao.IGameDAO;
import pl.edu.zse.gry.model.Game;
import pl.edu.zse.gry.services.ICartService;
import pl.edu.zse.gry.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    IGameDAO gameDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void addGameByIdToCart(int gameId) {
        Optional<Game> gameBox = this.gameDAO.getGameById(gameId);
        if(gameBox.isPresent()) {
            this.sessionObject.getCart().add(gameBox.get());
        }
    }
}
