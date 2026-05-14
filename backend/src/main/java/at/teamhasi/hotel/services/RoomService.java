package at.teamhasi.hotel.services;

import at.teamhasi.hotel.dto.PaginationDto;
import at.teamhasi.hotel.dto.RoomTypeDto;
import at.teamhasi.hotel.dto.RoomsResponseDto;
import at.teamhasi.hotel.entities.RoomTypeEntity;
import at.teamhasi.hotel.repositories.RoomRepository;
import at.teamhasi.hotel.repositories.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;

    public RoomsResponseDto getRooms(int limit, int offset) {
        List<RoomTypeEntity> rooms = roomTypeRepository.findAll();
        int total = rooms.size();

        PaginationDto paginationDto = PaginationDto.builder()
                .offset(offset)
                .limit(limit)
                .totalCount(total)
                .build();


        return RoomsResponseDto.builder()
                .pagination(paginationDto)
                .data(rooms.stream().map(RoomTypeDto::fromEntity).toList())
                .build();
    }

/*    private RoomTypeDto toRoomTypeDetailDto(RoomTypeEntity rt) {
        List<MediaDto> media = rt.getMedia() == null ? List.of() :
                rt.getMedia().stream().map(this::toMediaDto).toList();

        Map<Integer, RoomExtraEntity> extrasMap = new LinkedHashMap<>();
        if (rt.getRooms() != null) {
            rt.getRooms().forEach(room -> {
                if (room.getExtras() != null) {
                    room.getExtras().forEach(e -> extrasMap.put(e.getId(), e));
                }
            });
        }
        List<RoomExtraDto> extras = extrasMap.values().stream()
                .map(this::toRoomExtraDto)
                .toList();

        return RoomTypeDetailDto.builder()
                .id(rt.getId())
                .name(rt.getName())
                .description(rt.getDescription())
                .capacity(rt.getCapacity())
                .pricePerNight(rt.getPricePerNight())
                .media(media)
                .extras(extras)
                .build();
    }*/

/*    public RoomsResponseDto getAllRooms_(int limit, int offset) {
        List<RoomTypeEntity> all = roomTypeRepository.findAll();
        int totalCount = all.size();

        List<RoomTypeDetailDto> data = all.stream()
                .skip(offset)
                .limit(limit)
                .map(this::toRoomTypeDetailDto)
                .toList();

        int nextOffset = offset + limit;
        PaginationDto pagination = PaginationDto.builder()
                .totalCount(totalCount)
                .limit(limit)
                .offset(offset)
                .nextOffset(nextOffset < totalCount ? nextOffset : 0)
                .build();

        return RoomsResponseDto.builder()
                .pagination(pagination)
                .data(data)
                .build();
    }

    private RoomTypeDetailDto toRoomTypeDetailDto(RoomTypeEntity rt) {
        List<MediaDto> media = rt.getMedia() == null ? List.of() :
                rt.getMedia().stream().map(this::toMediaDto).toList();

        Map<Integer, RoomExtraEntity> extrasMap = new LinkedHashMap<>();
        if (rt.getRooms() != null) {
            rt.getRooms().forEach(room -> {
                if (room.getExtras() != null) {
                    room.getExtras().forEach(e -> extrasMap.put(e.getId(), e));
                }
            });
        }
        List<RoomExtraDto> extras = extrasMap.values().stream()
                .map(this::toRoomExtraDto)
                .toList();

        return RoomTypeDetailDto.builder()
                .id(rt.getId())
                .name(rt.getName())
                .description(rt.getDescription())
                .capacity(rt.getCapacity())
                .pricePerNight(rt.getPricePerNight())
                .media(media)
                .extras(extras)
                .build();
    }

    private MediaDto toMediaDto(MediaEntity m) {
        return MediaDto.builder()
                .id(m.getId())
                .path(m.getPath())
                .title(m.getTitle())
                .description(m.getDescription())
                .altText(m.getAltText())
                .sortHelper(m.getSortHelper())
                .build();
    }

    private RoomExtraDto toRoomExtraDto(RoomExtraEntity e) {
        return RoomExtraDto.builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .iconKey(e.getIconKey())
                .build();
    }*/
}
