package prueba.inditex.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import prueba.inditex.adapters.repositories.PriceRepository;
import prueba.inditex.domain.model.Price;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class PriceServiceImplTest {

    @InjectMocks
    private PriceServiceImpl priceService;
    @Mock
    private PriceRepository repository;

    @Test
    void getResponseFromRepository() {
        LocalDateTime dateTime = LocalDateTime.now();
        Mockito.when(repository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                1L, 35455L, dateTime, dateTime)).thenReturn(Price.builder().build());

        var response = priceService.getApplicablePrice(1L, 35455L, dateTime);

        Assertions.assertTrue(response.isPresent());
    }

    @Test
    void getNullResponseFromRepository() {
        LocalDateTime dateTime = LocalDateTime.now();
        Mockito.when(repository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                1L, 35455L, dateTime, dateTime)).thenReturn(null);

        var response = priceService.getApplicablePrice(1L, 35455L, dateTime);

        Assertions.assertTrue(response.get().getPrice() == null);
    }
}
