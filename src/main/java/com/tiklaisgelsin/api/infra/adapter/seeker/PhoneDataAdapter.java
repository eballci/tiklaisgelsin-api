package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.common.model.Phone;
import com.tiklaisgelsin.api.domain.seeker.port.PhonePort;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.AddSeekerPhone;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.RemoveSeekerPhone;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.UpdateSeekerPhone;
import com.tiklaisgelsin.api.infra.jpa.entity.PhoneEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.SeekerEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.PhoneJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.SeekerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhoneDataAdapter implements PhonePort {

    private final SeekerJpaRepository seekerJpaRepository;
    private final PhoneJpaRepository phoneJpaRepository;

    @Override
    public Phone addPhone(AddSeekerPhone addSeekerPhone) {
        Optional<SeekerEntity> seeker = seekerJpaRepository
                .findById(addSeekerPhone.getSeekerId());

        if (seeker.isEmpty()) return null;

        PhoneEntity phone = new PhoneEntity();
        phone.setPrefix(addSeekerPhone.getPrefix());
        phone.setNumber(addSeekerPhone.getNumber());
        phone.setSeeker(seeker.get());
        return phoneJpaRepository.save(phone).toModel();
    }

    @Override
    public void updatePhone(UpdateSeekerPhone updateSeekerPhone) {
        Optional<PhoneEntity> phone = phoneJpaRepository
                .findById(updateSeekerPhone.getPhoneId());

        if (phone.isEmpty()) return;

        phone.get().setPrefix(updateSeekerPhone.getPrefix());
        phone.get().setNumber(updateSeekerPhone.getNumber());
        phoneJpaRepository.save(phone.get());
    }

    @Override
    public void removePhone(RemoveSeekerPhone removeSeekerPhone) {
        phoneJpaRepository.deleteById(removeSeekerPhone.getPhoneId());
    }
}
