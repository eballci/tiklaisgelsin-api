package com.tiklaisgelsin.api.domain.common.usecase;

import com.tiklaisgelsin.api.domain.common.model.UseCase;

public interface VoidUseCaseHandler<T extends UseCase> {
    void handle(T useCase);
}
