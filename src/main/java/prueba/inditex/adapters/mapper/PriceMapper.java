package prueba.inditex.adapters.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import prueba.inditex.adapters.dto.PriceRSDTO;
import prueba.inditex.domain.model.Price;

@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapper {

    PriceRSDTO mapPriceToPriceRSDTO(Price price);
}
