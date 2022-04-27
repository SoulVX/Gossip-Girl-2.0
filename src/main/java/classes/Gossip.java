package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Gossip {
    private final String text;
    private final LocalDateTime postTime;
    private boolean pinned;

    public Gossip(final String text, final LocalDateTime postTime) {
        this.text = text;
        this.postTime = postTime;

        pinned = false;
    }

    public void pin() {
        pinned = true;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }
    public boolean isPinned() {
        return pinned;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");

        return text + "\n" + postTime.format(formatter);
    }
}
