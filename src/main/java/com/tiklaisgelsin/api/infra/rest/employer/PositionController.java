package com.tiklaisgelsin.api.infra.rest.employer;

import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.domain.common.usecase.UseCaseHandler;
import com.tiklaisgelsin.api.domain.common.usecase.VoidUseCaseHandler;
import com.tiklaisgelsin.api.domain.employer.usecase.position.CreatePosition;
import com.tiklaisgelsin.api.domain.employer.usecase.position.DeletePosition;
import com.tiklaisgelsin.api.domain.employer.usecase.position.GetPosition;
import com.tiklaisgelsin.api.domain.employer.usecase.position.UpdatePosition;
import com.tiklaisgelsin.api.infra.rest.employer.dto.position.PositionCreateRequest;
import com.tiklaisgelsin.api.infra.rest.employer.dto.position.PositionResponse;
import com.tiklaisgelsin.api.infra.rest.employer.dto.position.PositionUpdateRequest;
import com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.request.CriteriaRequestService;
import com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response.CriteriaResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position/")
public class PositionController {

    private final UseCaseHandler<Position, GetPosition> getHandler;
    private final UseCaseHandler<Position, CreatePosition> createHandler;
    private final VoidUseCaseHandler<UpdatePosition> updateHandler;
    private final VoidUseCaseHandler<DeletePosition> deleteHandler;
    private final CriteriaResponseService criteriaResponseService;
    private final CriteriaRequestService criteriaRequestService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PositionResponse getPosition(@PathVariable Long id) {
        return PositionResponse.fromModel(
                criteriaResponseService,
                getHandler.handle(
                        GetPosition.builder()
                                .positionId(id)
                                .build()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PositionResponse createPosition(@Validated @RequestBody PositionCreateRequest request) {
        return PositionResponse.fromModel(
                criteriaResponseService, createHandler.handle(request.toUseCase(criteriaRequestService)));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updatePosition(@Validated @RequestBody PositionUpdateRequest request) {
        updateHandler.handle(request.toUseCase(criteriaRequestService));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePosition(@PathVariable Long id) {
        deleteHandler.handle(
                DeletePosition.builder()
                        .positionId(id)
                        .build());
    }
}
