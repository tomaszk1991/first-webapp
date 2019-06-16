package pl.sda.kubik.servlet.dao;

import org.apache.commons.codec.digest.DigestUtils;
import pl.sda.kubik.servlet.domain.User;
import pl.sda.kubik.servlet.domain.UsersRole;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static pl.sda.kubik.servlet.domain.UsersRole.ADMIN;
import static pl.sda.kubik.servlet.domain.UsersRole.USER;

public class UserDb {


    private static UserDb instance = null;
    private final List<User> users;

    private UserDb() {


        this.users = new LinkedList<>();
        final String pass = DigestUtils.sha256Hex("pass");
        this.users.add(new User("admin", pass, "admin@admin.com", ADMIN, USER));
    }

    public static UserDb getInstance() {
        if (UserDb.instance == null) {
            UserDb.instance = new UserDb();
        }


        return UserDb.instance;
    }


    public List<User> getAllUsers() {
        return this.users;

    }

    public void createUser(final String login, final String password, final String email, final UsersRole... role) {

        final String sha256hex = DigestUtils.sha256Hex(password);
        this.users.add(new User(login, sha256hex, email, role));


    }

    public void createUser(final String login, final String password, final String email, final List<UsersRole> role) {

        final String sha256hex = DigestUtils.sha256Hex(password);
        this.users.add(new User(login, sha256hex, email, role));


    }

    public Optional<User> findByLogin(final String login) {
        for (final User user : this.users) {

            if (user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();

    }

    public Optional<User> findByEmail(final String email) {
        for (final User user : this.users) {

            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();

    }


    public Optional<User> checkLogin(final String login, final String password) {

        final String hashedPass = DigestUtils.sha256Hex(password);

        final Optional<User> user = this.findByLogin(login);
        if (user.isPresent()) {

            if (hashedPass.equals(user.get().getPassword())) {
                return user;
            }

        }


        return Optional.empty();
    }
}
