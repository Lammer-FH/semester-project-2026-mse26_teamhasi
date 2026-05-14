package at.teamhasi.hotel.services;

import at.teamhasi.hotel.dto.PaginationDto;
import at.teamhasi.hotel.dto.RoomTypeDto;
import at.teamhasi.hotel.dto.RoomsResponseDto;
import at.teamhasi.hotel.repositories.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomTypeRepository roomTypeRepository;

    @Transactional(readOnly = true)
    public RoomsResponseDto getRooms(int limit, int offset) {
        int page = limit > 0 ? offset / limit : 0;

        List<RoomTypeDto> data = roomTypeRepository
                .findAllWithPagination(PageRequest.of(page, limit))
                .stream()
                .map(RoomTypeDto::fromEntity)
                .toList();

        long total = roomTypeRepository.count();
        int nextOffset = offset + limit;

        PaginationDto pagination = PaginationDto.builder()
                .limit(limit)
                .offset(offset)
                .totalCount(total)
                .nextOffset(nextOffset < total ? nextOffset : null)
                .build();

        return RoomsResponseDto.builder()
                .pagination(pagination)
                .data(data)
                .build();
    }
}
