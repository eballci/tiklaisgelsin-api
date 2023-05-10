package com.tiklaisgelsin.api.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "seeker_avatar")
public class SeekerAvatarEntity extends AbstractEntity {

    @Column(nullable = false)
    private String file;

    @OneToOne
    @JoinColumn(name = "seeker_id")
    private SeekerEntity seeker;
}
