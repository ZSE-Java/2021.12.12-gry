package pl.edu.zse.gry.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.zse.gry.model.Game;
import pl.edu.zse.gry.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class SessionObject {
    private User user = null;
    private List<Game> cart = new ArrayList<>();

    public boolean isLogged() {
        return user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Game> getCart() {
        return cart;
    }

    public void setCart(List<Game> cart) {
        this.cart = cart;
    }
}
