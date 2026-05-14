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
    private List<RoomExtraDto> possibleExtras;

    public static RoomTypeDto fromEntity(RoomTypeEntity roomTypeEntity) {
        return RoomTypeDto.builder()
                .name(roomTypeEntity.getName())
                .description(roomTypeEntity.getDescription())
                .capacity(roomTypeEntity.getCapacity())
                .pricePerNight(roomTypeEntity.getPricePerNight())
                .media(roomTypeEntity.getMedia().stream().map(MediaDto::fromEntity).toList())
                .possibleExtras(roomTypeEntity.getPossibleExtras().stream().map(RoomExtraDto::fromEntity).toList())
                .build();
    }
}
