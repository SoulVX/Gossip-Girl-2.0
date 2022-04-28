package classes;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

public class Admin extends Entity {
    private Hashtable<Gossip, Integer> reportedGossips;
    private List<User> users, bannedUsers;

    public Admin(final Credentials credentials) {
        this(UUID.randomUUID(), credentials);

        users = new ArrayList<>();
        bannedUsers = new ArrayList<>();
    }

    public Admin(final UUID uuid, final Credentials credentials) {
        super(uuid, credentials);
    }

    public boolean shouldBeRemoved(final Gossip gossip) {
        Integer oldVal = reportedGossips.get(gossip);

        if (oldVal == null)
            reportedGossips.put(gossip, 1);
        else
            reportedGossips.put(gossip, oldVal + 1);

        return reportedGossips.get(gossip) >= 10;
    }

    public boolean banUser(final UUID uuid) {
        for (int i = 0; i < users.size(); i++)
            if (users.get(i).getUUID() == uuid) {
                bannedUsers.add(users.get(i));
                users.remove(i);
                return true;
            }

        return false;
    }

    public boolean banUser(final User user) {
        return banUser(user.getUUID());
    }
}
