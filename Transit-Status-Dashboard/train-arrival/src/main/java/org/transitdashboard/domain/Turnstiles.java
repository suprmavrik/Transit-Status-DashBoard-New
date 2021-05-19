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
public class Turnstiles {

    @NotNull
    private int station_id;
    @NotBlank
    private String station_name;
    @NotBlank
    private String line;
}
