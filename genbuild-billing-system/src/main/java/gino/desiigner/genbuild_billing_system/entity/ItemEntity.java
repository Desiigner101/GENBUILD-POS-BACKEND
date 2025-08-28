package gino.desiigner.genbuild_billing_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "tbl_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemEntity {
    private Long id;
    private String itemId;
    private String name;
    private BigDecimal price;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private String imgUrl;
    private CategoryEntity category;
}
