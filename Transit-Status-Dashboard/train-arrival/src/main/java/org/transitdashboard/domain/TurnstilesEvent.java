package org.transitdashboard.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class TurnstilesEvent {

    private int turnstilesEventId;

    @NotNull
    @Valid
    private Turnstiles turnstiles;

}
