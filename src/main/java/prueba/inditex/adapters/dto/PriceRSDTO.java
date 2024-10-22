package prueba.inditex.adapters.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceRSDTO {

    private Long id;

    private Long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    private Long productId;

    private Integer priority;

    private Double price;

    private String currency;
}
