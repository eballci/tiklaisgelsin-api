package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.common.model.Phone;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.AddSeekerPhone;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.RemoveSeekerPhone;
import com.tiklaisgelsin.api.domain.seeker.usecase.phone.UpdateSeekerPhone;

public interface PhonePort {
    Phone addPhone(AddSeekerPhone addSeekerPhone);

    void updatePhone(UpdateSeekerPhone updateSeekerPhone);

    void removePhone(RemoveSeekerPhone removeSeekerPhone);
}
