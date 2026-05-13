package at.teamhasi.hotel.services;

import at.teamhasi.hotel.entities.RoomEntity;
import at.teamhasi.hotel.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<RoomEntity> getAllRooms() {
        return roomRepository.findAll();
    }
}
