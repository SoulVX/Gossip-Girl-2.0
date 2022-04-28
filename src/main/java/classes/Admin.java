package classes;

import java.util.UUID;

public class Admin extends Entity {
    public Admin(final Credentials credentials) {
        this(UUID.randomUUID(), credentials);
    }

    public Admin(final UUID uuid, final Credentials credentials) {
        super(uuid, credentials);
    }
}
