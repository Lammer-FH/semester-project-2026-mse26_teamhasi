package at.teamhasi.hotel.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomAvailableResponseDto {
    private boolean available;
}