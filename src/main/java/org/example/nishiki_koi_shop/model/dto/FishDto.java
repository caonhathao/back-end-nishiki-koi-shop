package org.example.nishiki_koi_shop.model.dto;

import lombok.Builder;
import lombok.Data;
import org.example.nishiki_koi_shop.model.entity.Fish;

import java.math.BigDecimal;

@Data
@Builder
public class FishDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private long size;
    private Integer quantity;
    private long fishTypeId ;
    private long farmId;
    private String image;

    public static FishDto from(Fish fish) {
        return FishDto.builder()
                .id(fish.getFishId())
                .name(fish.getName())
                .price(fish.getPrice())
                .description(fish.getDescription())
                .image(fish.getImage())
                .size(fish.getSize())
                .quantity(fish.getQuantity())
                .fishTypeId(fish.getFishType().getFishTypeId())
                .farmId(fish.getFarm().getFarmId())
                .build();
    }
}
