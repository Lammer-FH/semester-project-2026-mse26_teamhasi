package at.teamhasi.hotel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationDto {
    private int limit;
    private int offset;
    private Integer nextOffset;
    private Long totalCount;
}
