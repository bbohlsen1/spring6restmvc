package demo.springframework.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;



@Data //Combines - @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
@Builder //Implements builder pattern for object creation eg. Person.builder().name("Adam Savage").build()
public class BeerDTO {
    private UUID id;
    private Integer version;
    private String beerName;
    private BeerStyle beerStyle;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
