package classes;

import java.util.*;

public class Feed {
    private Admin admin;
    private List<Gossip> gossips;

    public Feed(final Admin admin) {
        this.admin = admin;

        gossips = new ArrayList<>();
    }


    public void addGossip(final Gossip gossip) {
        gossips.add(gossip);
    }

    public boolean removeGossip(final UUID uuid) {
        for (int i = 0; i < gossips.size(); i++)
            if (gossips.get(i).getUUID() == uuid) {
                gossips.remove(i);
                return true;
            }

        return false;
    }

    public void reportGossip(final UUID uuid) {
        for (int i = 0; i < gossips.size(); i++)
            if (gossips.get(i).getUUID() == uuid)
                if (admin.shouldBeRemoved(gossips.get(i))) {
                    removeGossip(uuid);
                    System.out.println("Gossip was banned!");
                    return;
                }

        System.out.printf("Gossip was reported!");
    }

    public boolean removeGossip(final Gossip gossip) {
        return removeGossip(gossip.getUUID());
    }

    public List<Gossip> getGossips() {
        return gossips;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Pinned gossips:\n");

        for (var gossip : gossips)
            if (gossip.isPinned())
                stringBuilder.append(gossip.toString() + "\n\n");

        stringBuilder.append("Unpinned gossips:\n");

        for (var gossip : gossips)
            if (!gossip.isPinned())
                stringBuilder.append(gossip.toString() + "\n\n");

        return stringBuilder.toString();
    }
}
