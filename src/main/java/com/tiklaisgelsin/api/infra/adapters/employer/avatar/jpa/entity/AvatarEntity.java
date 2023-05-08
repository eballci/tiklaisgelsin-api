package com.tiklaisgelsin.api.infra.adapters.employer.avatar.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "avatar")
public class AvatarEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long employerId;

    @Column(nullable = false)
    private String avatar;
}
