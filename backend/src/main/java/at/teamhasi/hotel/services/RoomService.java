package at.teamhasi.hotel.services;

import at.teamhasi.hotel.dto.PaginationDto;
import at.teamhasi.hotel.dto.RoomDto;
import at.teamhasi.hotel.dto.RoomsResponseDto;
import at.teamhasi.hotel.repositories.RoomRepository;
import at.teamhasi.hotel.services.exceptions.RoomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public RoomsResponseDto getRooms(int limit, int offset, LocalDate startDate, LocalDate endDate) {
        int page = limit > 0 ? offset / limit : 0;

        List<RoomDto> data;
        long total;

        if (startDate != null && endDate != null) {
            data = roomRepository
                    .findAvailableWithPagination(startDate, endDate, PageRequest.of(page, limit))
                    .stream()
                    .map(RoomDto::fromEntity)
                    .toList();
            total = roomRepository.countAvailable(startDate, endDate);
        } else {
            data = roomRepository
                    .findAllWithPagination(PageRequest.of(page, limit))
                    .stream()
                    .map(RoomDto::fromEntity)
                    .toList();
            total = roomRepository.count();
        }

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


    @Transactional(readOnly = true)
    public boolean isRoomAvailable(Integer roomId, LocalDate startDate, LocalDate endDate) {
        if (!roomRepository.existsById(roomId)) {
            throw new RoomNotFoundException(roomId);
        }
        return roomRepository.countAvailableById(roomId, startDate, endDate) > 0;
    }
}
