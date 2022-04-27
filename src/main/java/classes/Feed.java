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

    public void sortGossips() {
        Collections.sort(gossips, new Comparator<Gossip>() {
            @Override
            public int compare(Gossip gossip1, Gossip gossip2) {
                if (gossip1.isPinned() && !gossip2.isPinned())
                    return -1;

                if (!gossip1.isPinned() && gossip2.isPinned())
                    return 1;

                if (gossip1.getPostTime().isBefore(gossip2.getPostTime()))
                    return -1;

                return 1;
            }
        });
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
