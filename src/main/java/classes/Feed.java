package classes;

import java.util.*;

public class Feed {
    private List<Gossip> gossips;

    public Feed() {
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
