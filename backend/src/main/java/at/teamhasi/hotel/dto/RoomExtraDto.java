package at.teamhasi.hotel.dto;

import at.teamhasi.hotel.entities.RoomExtraEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomExtraDto {
    private String name;
    private String description;
    private String iconKey;

    public static RoomExtraDto fromEntity(RoomExtraEntity roomExtraEntity) {
        return RoomExtraDto.builder()
                .name(roomExtraEntity.getName())
                .description(roomExtraEntity.getDescription())
                .iconKey(roomExtraEntity.getIconKey())
                .build();
    }
}
