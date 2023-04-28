package com.tiklaisgelsin.api.domain.common.usecase;

import com.tiklaisgelsin.api.domain.common.model.UseCase;

public interface UseCaseHandler<E, T extends UseCase> {
    E handle(T useCase);
}
