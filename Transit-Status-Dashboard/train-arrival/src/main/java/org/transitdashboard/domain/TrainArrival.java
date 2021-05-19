package org.transitdashboard.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TrainArrival {

    @NotNull
    private int station_id;
    @NotNull
    private int train_id;
    @NotBlank
    private String direction;
    @NotBlank
    private String line;
    @NotBlank
    private String train_status;
    @NotNull
    private int prev_station_id;
    @NotBlank
    private String prev_direction;
}
