package classes;

import java.util.UUID;

public abstract class Entity {
    private final UUID uuid;
    private Credentials credentials;

    public Entity(final Credentials credentials) {
        this(UUID.randomUUID(), credentials);
    }

    public Entity(final UUID uuid, final Credentials credentials) {
        this.uuid = uuid; this.credentials = credentials;
    }

    public UUID getUUID() {
        return uuid;
    }

    public Credentials getCredentials() {
        return credentials;
    }
}
