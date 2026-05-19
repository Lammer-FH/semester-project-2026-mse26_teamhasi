package at.teamhasi.hotel.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomsResponseDto {
    private PaginationDto pagination;
    private List<RoomDto> data;
}
