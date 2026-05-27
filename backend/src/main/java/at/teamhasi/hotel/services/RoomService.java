package at.teamhasi.hotel.services;

import at.teamhasi.hotel.dto.PaginationDto;
import at.teamhasi.hotel.dto.RoomAvailabilityDto;
import at.teamhasi.hotel.dto.RoomListDto;
import at.teamhasi.hotel.dto.RoomsResponseDto;
import at.teamhasi.hotel.entities.RoomTypeEntity;
import at.teamhasi.hotel.repositories.RoomRepository;
import at.teamhasi.hotel.repositories.RoomTypeRepository;
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
    private final RoomTypeRepository roomTypeRepository;

    @Transactional(readOnly = true)
    public RoomsResponseDto getRooms(int limit, int offset, LocalDate checkIn, LocalDate checkOut) {
        int page = limit > 0 ? offset / limit : 0;

        List<RoomListDto> data;
        long total;

        if (checkIn != null && checkOut != null) {
            data = roomTypeRepository
                    .findAvailableWithPagination(checkIn, checkOut, PageRequest.of(page, limit))
                    .stream()
                    .map(RoomListDto::fromEntity)
                    .toList();
            total = roomTypeRepository.countAvailable(checkIn, checkOut);
        } else {
            data = roomTypeRepository
                    .findAllWithPagination(PageRequest.of(page, limit))
                    .stream()
                    .map(RoomListDto::fromEntity)
                    .toList();
            total = roomTypeRepository.count();
        }

        long nextOffset = offset + limit;

        PaginationDto pagination = PaginationDto.builder()
                .limit(limit)
                .offset(offset)
                .totalCount(total)
                .nextOffset(nextOffset < total ? (int) nextOffset : null)
                .build();

        return RoomsResponseDto.builder()
                .pagination(pagination)
                .data(data)
                .build();
    }

    @Transactional(readOnly = true)
    public RoomAvailabilityDto checkAvailability(Integer roomTypeId, LocalDate checkIn, LocalDate checkOut) {
        RoomTypeEntity roomType = roomTypeRepository.findById(roomTypeId)
                .orElseThrow(() -> new RoomNotFoundException(roomTypeId));

        if (checkIn == null && checkOut == null) {
            return RoomAvailabilityDto.builder()
                    .roomId(roomType.getId())
                    .available(true)
                    .unavailableDates(List.of())
                    .build();
        }

        boolean available = roomRepository.existsAvailableRoomForType(roomTypeId, checkIn, checkOut);

        return RoomAvailabilityDto.builder()
                .roomId(roomType.getId())
                .available(available)
                .checkIn(checkIn)
                .checkOut(checkOut)
                .unavailableDates(List.of())
                .build();
    }
}