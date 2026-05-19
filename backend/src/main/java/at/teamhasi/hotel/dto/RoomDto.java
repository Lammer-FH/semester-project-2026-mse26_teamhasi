package at.teamhasi.hotel.dto;

import at.teamhasi.hotel.entities.RoomEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDto {
    private int id;
    private Integer floor;
    private String roomNumber;
    private RoomTypeDto roomType;
    private List<RoomExtraDto> extras;

    public static RoomDto fromEntity(RoomEntity roomEntity) {
        List<RoomExtraDto> extras = roomEntity.getExtras() == null ? List.of() :
                roomEntity.getExtras().stream().map(RoomExtraDto::fromEntity).toList();

        return RoomDto.builder()
                .id(roomEntity.getId())
                .floor(roomEntity.getFloor())
                .roomNumber(roomEntity.getRoomNumber())
                .roomType(RoomTypeDto.fromEntity(roomEntity.getRoomType()))
                .extras(extras)
                .build();
    }
}
