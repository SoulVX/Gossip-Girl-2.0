package classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID uuid;
    private Credentials credentials;
    private List<Gossip> sentGossips;

    public User(final UUID uuid, final Credentials credentials) {
        this.uuid = uuid; this.credentials = credentials;

        sentGossips = new ArrayList<>();
    }

    public String toString() {
        return "UUID: " + uuid.toString() + "\n" +
                credentials.toString();
    }
}
