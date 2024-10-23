package prueba.inditex.adapters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import prueba.inditex.adapters.dto.PriceRSDTO;
import prueba.inditex.adapters.mapper.PriceMapper;
import prueba.inditex.domain.model.Price;
import prueba.inditex.ports.PriceService;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PriceControllerTest {

    @InjectMocks
    private PriceController priceController;
    @Mock
    private PriceService priceService;
    @Mock
    private PriceMapper priceMapper;

    @Test
    void testDay14at10() {
        LocalDateTime dateTime = LocalDateTime.of(2020, Month.JUNE, 14, 10, 0, 0);
        Price price = Price.builder().productId(35455L).brandId(1L).priceList(1)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                        .price(35.50).build();
        PriceRSDTO priceRSDTO = PriceRSDTO.builder().productId(35455L).brandId(1L).priceList(1)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                .price(35.50).build();

        Mockito.when(priceService.getApplicablePrice(1L, 35455L, dateTime))
                .thenReturn(Optional.ofNullable(price));
        Mockito.when(priceMapper.mapPriceToPriceRSDTO(price)).thenReturn(priceRSDTO);

        ResponseEntity<PriceRSDTO> response = priceController.getPrice(1L, 35455L, dateTime);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(35.50, response.getBody().getPrice());
    }

    @Test
    void testDay14at16() {
        LocalDateTime dateTime = LocalDateTime.of(2020, Month.JUNE, 14, 16, 0, 0);
        Price price = Price.builder().productId(35455L).brandId(1L).priceList(2)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 15, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.JUNE, 14, 18, 30, 59))
                .price(25.45).build();
        PriceRSDTO priceRSDTO = PriceRSDTO.builder().productId(35455L).brandId(1L).priceList(2)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 15, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.JUNE, 14, 18, 30, 59))
                .price(25.45).build();

        Mockito.when(priceService.getApplicablePrice(1L, 35455L, dateTime))
                .thenReturn(Optional.ofNullable(price));
        Mockito.when(priceMapper.mapPriceToPriceRSDTO(price)).thenReturn(priceRSDTO);

        ResponseEntity<PriceRSDTO> response = priceController.getPrice(1L, 35455L, dateTime);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(25.45, response.getBody().getPrice());
    }

    @Test
    void testDay14at21() {
        LocalDateTime dateTime = LocalDateTime.of(2020, Month.JUNE, 14, 21, 0, 0);
        Price price = Price.builder().productId(35455L).brandId(1L).priceList(1)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                .price(35.50).build();
        PriceRSDTO priceRSDTO = PriceRSDTO.builder().productId(35455L).brandId(1L).priceList(1)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                .price(35.50).build();

        Mockito.when(priceService.getApplicablePrice(1L, 35455L, dateTime))
                .thenReturn(Optional.ofNullable(price));
        Mockito.when(priceMapper.mapPriceToPriceRSDTO(price)).thenReturn(priceRSDTO);

        ResponseEntity<PriceRSDTO> response = priceController.getPrice(1L, 35455L, dateTime);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(35.50, response.getBody().getPrice());
    }

    @Test
    void testDay15at10() {
        LocalDateTime dateTime = LocalDateTime.of(2020, Month.JUNE, 15, 10, 0, 0);
        Price price = Price.builder().productId(35455L).brandId(1L).priceList(3)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 15, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.JUNE, 15, 11, 0, 0))
                .price(30.50).build();
        PriceRSDTO priceRSDTO = PriceRSDTO.builder().productId(35455L).brandId(1L).priceList(3)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 15, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.JUNE, 15, 11, 0, 0))
                .price(30.50).build();

        Mockito.when(priceService.getApplicablePrice(1L, 35455L, dateTime))
                .thenReturn(Optional.ofNullable(price));
        Mockito.when(priceMapper.mapPriceToPriceRSDTO(price)).thenReturn(priceRSDTO);

        ResponseEntity<PriceRSDTO> response = priceController.getPrice(1L, 35455L, dateTime);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(30.50, response.getBody().getPrice());
    }

    @Test
    void testDay16at21() {
        LocalDateTime dateTime = LocalDateTime.of(2020, Month.JUNE, 16, 21, 0, 0);
        Price price = Price.builder().productId(35455L).brandId(1L).priceList(4)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 15, 16, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                .price(38.95).build();
        PriceRSDTO priceRSDTO = PriceRSDTO.builder().productId(35455L).brandId(1L).priceList(4)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 15, 16, 0, 0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                .price(38.95).build();

        Mockito.when(priceService.getApplicablePrice(1L, 35455L, dateTime))
                .thenReturn(Optional.ofNullable(price));
        Mockito.when(priceMapper.mapPriceToPriceRSDTO(price)).thenReturn(priceRSDTO);

        ResponseEntity<PriceRSDTO> response = priceController.getPrice(1L, 35455L, dateTime);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(38.95, response.getBody().getPrice());
    }
}
