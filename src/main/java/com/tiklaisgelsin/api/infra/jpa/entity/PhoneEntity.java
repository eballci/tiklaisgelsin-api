package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.Phone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phone")
public class PhoneEntity extends AbstractEntity {

    @Column(nullable = false)
    private String prefix;

    @Column(nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerEntity seeker;

    public Phone toModel() {
        return Phone.builder()
                .id(getId())
                .prefix(prefix)
                .number(number)
                .build();
    }
}
