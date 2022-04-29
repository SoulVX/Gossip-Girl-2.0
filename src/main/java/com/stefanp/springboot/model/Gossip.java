package com.stefanp.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gossips")
public class Gossip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "content", length = 500)
    private String content;

    @Column(name = "flag_status")
    private int flagStatus = 0;

    @Column(name = "is_hidden")
    private Boolean isHidden = false;

    @Column(name = "is_pinned")
    private Boolean isPinned = false;
}
