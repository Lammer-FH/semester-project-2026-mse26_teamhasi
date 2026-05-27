package at.teamhasi.hotel.dto;

import at.teamhasi.hotel.entities.RoomTypeEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomListDto {
    private Integer id;
    private String name;
    private String description;
    private Integer capacity;
    private Float pricePerNight;
    private List<MediaDto> media;
    private List<RoomExtraDto> extras;

    public static RoomListDto fromEntity(RoomTypeEntity entity) {
        List<MediaDto> media = entity.getMedia() == null ? List.of() :
                entity.getMedia().stream().map(MediaDto::fromEntity).toList();

        List<RoomExtraDto> extras = (entity.getRooms() == null || entity.getRooms().isEmpty()
                || entity.getRooms().get(0).getExtras() == null) ? List.of() :
                entity.getRooms().get(0).getExtras().stream().map(RoomExtraDto::fromEntity).toList();

        return RoomListDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .capacity(entity.getCapacity())
                .pricePerNight(entity.getPricePerNight())
                .media(media)
                .extras(extras)
                .build();
    }
}
