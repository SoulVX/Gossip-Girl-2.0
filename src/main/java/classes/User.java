package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User extends Entity {
    private List<Gossip> sentGossips;

    public User(final Credentials credentials) {
        this(UUID.randomUUID(), credentials);
    }

    public User(final UUID uuid, final Credentials credentials) {
        super(uuid, credentials);

        sentGossips = new ArrayList<>();
    }

    public String toString() {
        return "UUID: " + getUUID().toString() + "\n" +
                getCredentials().toString();
    }
}
