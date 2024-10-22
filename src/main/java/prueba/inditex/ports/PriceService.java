package prueba.inditex.ports;

import prueba.inditex.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {

    Optional<Price> getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate);
}
