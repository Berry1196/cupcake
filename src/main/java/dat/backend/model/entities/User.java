package dat.backend.model.entities;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import java.util.Objects;

public class User
{
    private String username;
    private String password;
    private String role;
    private int balance;
    private ShoppingCart shoppingCart;
     ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    public User(String username, String password, String role, int balance)
    {
        this.username = username;
        this.password = password;
        this.role = role;
        this.shoppingCart = shoppingCart;
        this.balance = balance;
    }

    public User(String username, String password, String role)
    {
        this.username = username;
        this.password = password;
        this.role = role;
        this.shoppingCart = shoppingCart;

    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()) &&
                getRole().equals(user.getRole());
    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
         this.balance = balance;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUsername(), getPassword(), getRole());
    }

    @Override
    public String toString()
    {
        return "User{" +
                "brugerNavn='" + username + '\'' +
                ", kodeord='" + password + '\'' +
                ", rolle='" + role + '\'' +
                '}';
    }
}
