package gino.desiigner.genbuild_billing_system.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemRequest {

    //private String itemId;
    private String name;
    private BigDecimal price;
    private String categoryId;
    private String description;

}
