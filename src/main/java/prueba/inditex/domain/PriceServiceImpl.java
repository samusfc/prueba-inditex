package prueba.inditex.domain;

import org.springframework.stereotype.Service;
import prueba.inditex.adapters.repositories.PriceRepository;
import prueba.inditex.domain.model.Price;
import prueba.inditex.ports.PriceService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        Price price = priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                brandId, productId, applicationDate, applicationDate);

        return price != null ? Optional.of(price) : Optional.of(Price.builder().build());
    }

}
