package com.stefanp.springboot.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "gossips")
public class Gossip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "content", length = 500)
    private String content;

    @Column(name = "flag_status")
    private int flagStatus = 0;

    @Column(name = "is_hidden")
    private Boolean isHidden = false;

    @Column(name = "is_pinned")
    private Boolean isPinned = false;

    @Column(name = "is_hidden_inbox")
    private Boolean isHiddenInbox = false;
}
