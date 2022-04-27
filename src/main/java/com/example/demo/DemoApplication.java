package com.example.demo;

import classes.Feed;
import classes.Gossip;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
		//SpringApplication.run(DemoApplication.class, args);
		Feed feed = new Feed();

		for (int i = 0; i < 15; i++) {
			Thread.sleep(100);
			feed.getGossips().add(new Gossip("frumoasa cu numarul " + Integer.toString(i), LocalDateTime.now()));
		}

		for (int i = 0; i < 15; i++)
			if (i % 2 == 0)
				feed.getGossips().get(i).pin();

		feed.sortGossips();

		System.out.println(feed);
	}

}
