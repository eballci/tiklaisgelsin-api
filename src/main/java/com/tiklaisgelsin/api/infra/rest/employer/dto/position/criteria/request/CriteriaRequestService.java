package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.request;

import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CriteriaRequestService {

    private final List<CriteriaUseCaseCreator<? extends CreateCriteria>> useCaseCreators;

    public List<CreateCriteria> getCreateCriteriaUseCaseList(List<CriteriaRequest> criteriaRequests) {
        List<CreateCriteria> createCriteriaUseCaseList = new LinkedList<>();

        for (CriteriaRequest request : criteriaRequests) {
            CriteriaUseCaseCreator<?> creator = useCaseCreators.stream()
                    .filter(c -> c.isUseCaseMyType(request))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

            createCriteriaUseCaseList.add(creator.getUseCaseInstance(request));
        }

        return createCriteriaUseCaseList;
    }

}
