package org.transitdashboard.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Station {
    
    @CsvBindByName
    private int stop_id;

    @CsvBindByName
    private String direction_id;

    @CsvBindByName
    private String stop_name;

    @CsvBindByName
    private String station_name;

    @CsvBindByName
    private String station_descriptive_name;

    @CsvBindByName
    private int station_id;

    @CsvBindByName
    private int order;

    @CsvBindByName
    private Boolean red;

    @CsvBindByName
    private Boolean blue;

    @CsvBindByName
    private Boolean green;
}
