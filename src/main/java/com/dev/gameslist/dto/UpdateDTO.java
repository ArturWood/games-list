package com.dev.gameslist.dto;

import jakarta.validation.constraints.NotNull;

public class UpdateDTO {
    @NotNull(message = "Obrigatorio um numero de origem")
    private Integer sourceIndex;
    @NotNull(message = "Obrigatorio um numero de destino")
    private Integer destinationIndex;

    public Integer getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public Integer getDestinationIndex() {
        return destinationIndex;
    }

    public void setDestinationIndex(Integer destinationIndex) {
        this.destinationIndex = destinationIndex;
    }
}
