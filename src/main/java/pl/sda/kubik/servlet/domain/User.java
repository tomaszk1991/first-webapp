package pl.sda.kubik.servlet.domain;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class User {
    private String login;
    private String email;
    private String password;
    private List<UsersRole> roles;

    public User(final String login, final String password, final String email, final List<UsersRole> roles) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(final String login, final String password, final String email, final UsersRole... roles) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.roles = Arrays.asList(roles);
    }


    public String getLogin() {
        return this.login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public List<UsersRole> getRoles() {
        return this.roles;
    }

    public void setRoles(final List<UsersRole> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final User user = (User) o;
        return Objects.equals(this.login, user.login) &&
                Objects.equals(this.email, user.email) &&
                Objects.equals(this.password, user.password) &&
                Objects.equals(this.roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.login, this.email, this.password, this.roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + this.login + '\'' +
                ", email='" + this.email + '\'' +
                ", password='" + this.password + '\'' +
                ", roles=" + this.roles.toString() +
                '}';
    }

    //
//    Stworz klase User
//    Klasa powinna miec emial, password, login i liste rol
//    Stworzyc DB dla userow z takimi samymi metodatmi jak produkty
//    Dla chetnych hashowanie hasla i walidacja emaila
}
