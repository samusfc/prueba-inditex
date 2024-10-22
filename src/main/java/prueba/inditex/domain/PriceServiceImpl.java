package prueba.inditex.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.inditex.adapters.repositories.PriceRepository;
import prueba.inditex.domain.model.Price;
import prueba.inditex.ports.PriceService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        List<Price> prices = priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                brandId, productId, applicationDate);

        return prices.isEmpty() ? Optional.empty() : Optional.of(prices.get(0));
    }

}
