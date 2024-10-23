package prueba.inditex.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prueba.inditex.adapters.dto.PriceRSDTO;
import prueba.inditex.adapters.mapper.PriceMapper;
import prueba.inditex.ports.PriceService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;
    private final PriceMapper mapper;

    public PriceController(PriceService priceService, PriceMapper mapper) {
        this.priceService = priceService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<PriceRSDTO> getPrice(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {

        return priceService.getApplicablePrice(brandId, productId, date)
                .map(price -> ResponseEntity.ok(mapper.mapPriceToPriceRSDTO(price)))
                .orElse(ResponseEntity.notFound().build());
    }
}

