package com.example.demo.dto;

import com.example.demo.entity.Item;
import lombok.Getter;

@Getter
public class ItemResponseDto {

    private String name;

    private String description;

    private Long managerId;

    private Long ownerId;

    public ItemResponseDto(String name, String description, Long managerId, Long ownerId) {
        this.name = name;
        this.description = description;
        this.managerId = managerId;
        this.ownerId = ownerId;
    }

    public static ItemResponseDto toDto(Item item) {
        return new ItemResponseDto(item.getName(),
                item.getDescription(),
                item.getManager().getId(),
                item.getOwner().getId()
        );
    }
}
