package com.tiklaisgelsin.api.domain.employer.port;

import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.domain.employer.usecase.position.CreatePosition;
import com.tiklaisgelsin.api.domain.employer.usecase.position.DeletePosition;
import com.tiklaisgelsin.api.domain.employer.usecase.position.UpdatePosition;

import java.util.List;

public interface PositionPort {
    Position getPosition(Long id);

    Position createPosition(CreatePosition createPosition);

    void updatePosition(UpdatePosition updatePosition);

    void removePosition(DeletePosition deletePosition);

    List<Position> getAllPositions();

    boolean checkIfPositionExists(Long id);
}
