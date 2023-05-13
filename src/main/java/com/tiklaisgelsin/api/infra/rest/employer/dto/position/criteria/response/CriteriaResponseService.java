package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.response;

import com.tiklaisgelsin.api.domain.common.model.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@RequiredArgsConstructor
public class CriteriaResponseService {

    private final List<CriteriaResponseCreator<? extends Criteria>> creators;

    public Map<String, List<CriteriaResponse>> getCriteriaListResponse(List<Criteria> criteriaList) {
        Map<String, List<CriteriaResponse>> response = new TreeMap<>();

        for (Criteria criteria : criteriaList) {
            CriteriaResponseCreator<?> creator = creators.stream()
                    .filter(c -> c.isCriteriaMyType(criteria.getClass()))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

            CriteriaResponse r = creator.getInstance();
            r.fromModel(criteria);

            String type = r.getType();

            if (!response.containsKey(type)) {
                response.put(type, new LinkedList<>());
            }

            response.get(type).add(r);
        }

        return response;
    }
}
