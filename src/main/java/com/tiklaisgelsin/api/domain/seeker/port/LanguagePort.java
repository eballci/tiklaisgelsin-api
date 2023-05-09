package com.tiklaisgelsin.api.domain.seeker.port;

import com.tiklaisgelsin.api.domain.common.model.Language;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.AddSeekerLanguage;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.RemoveSeekerLanguage;
import com.tiklaisgelsin.api.domain.seeker.usecase.language.UpdateSeekerLanguage;

public interface LanguagePort {
    Language addLanguage(AddSeekerLanguage addSeekerLanguage);

    void updateLanguage(UpdateSeekerLanguage updateSeekerLanguage);

    void removeLanguage(RemoveSeekerLanguage removeSeekerLanguage);
}
