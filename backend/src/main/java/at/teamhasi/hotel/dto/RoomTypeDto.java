package at.teamhasi.hotel.dto;

import at.teamhasi.hotel.entities.RoomTypeEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomTypeDto {
    private String name;
    private String description;
    private Integer capacity;
    private Float pricePerNight;
    private List<MediaDto> media;

    public static RoomTypeDto fromEntity(RoomTypeEntity entity) {
        List<MediaDto> media = entity.getMedia() == null ? List.of() :
                entity.getMedia().stream().map(MediaDto::fromEntity).toList();

        return RoomTypeDto.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .capacity(entity.getCapacity())
                .pricePerNight(entity.getPricePerNight())
                .media(media)
                .build();
    }
}
