package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Gossip {
    private final UUID uuid;
    private final String text;
    private final LocalDateTime postTime;
    private boolean pinned;

    public Gossip(final String text) {
        this(text, LocalDateTime.now());
    }

    public Gossip(final String text, final LocalDateTime postTime) {
        this(UUID.randomUUID(), text, postTime);
    }

    public Gossip(final UUID uuid, final String text, final LocalDateTime postTime) {
        this.uuid = uuid; this.text = text; this.postTime = postTime;

        pinned = false;
    }

    public static void sort(List<Gossip> gossips) {
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

    public void pin() {
        pinned = true;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }
    public boolean isPinned() {
        return pinned;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");

        return "UUID: " + uuid + "\n" +
               "Date and time: " + postTime.format(formatter) + "\n" +
               "Text: " + text;
    }
}
