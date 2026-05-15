package at.teamhasi.hotel.dto;

import at.teamhasi.hotel.entities.RoomEntity;
import lombok.*;

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

    public static RoomDto fromEntity(RoomEntity roomEntity) {
        return RoomDto.builder()
                .id(roomEntity.getId())
                .floor(roomEntity.getFloor())
                .roomNumber(roomEntity.getRoomNumber())
                .roomType(RoomTypeDto.fromEntity(roomEntity.getRoomType()))
                .build();
    }
}
