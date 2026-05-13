package at.teamhasi.hotel.config;

import at.teamhasi.hotel.entities.RoomEntity;
import at.teamhasi.hotel.entities.RoomTypeEntity;
import at.teamhasi.hotel.repositories.RoomRepository;
import at.teamhasi.hotel.repositories.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoomTypeRepository roomTypeRepository;
    private final RoomRepository roomRepository;

    @Override
    public void run(String @NonNull ... args) {
        if (roomTypeRepository.count() > 0) return;

        RoomTypeEntity standard = roomTypeRepository.save(RoomTypeEntity.builder()
                .name("Standard")
                .description("Cozy standard room with all essential amenities.")
                .capacity(2)
                .pricePerNight(89.99f)
                .build());

        RoomTypeEntity deluxe = roomTypeRepository.save(RoomTypeEntity.builder()
                .name("Deluxe")
                .description("Spacious deluxe room with premium furnishings and city view.")
                .capacity(2)
                .pricePerNight(129.99f)
                .build());

        RoomTypeEntity juniorSuite = roomTypeRepository.save(RoomTypeEntity.builder()
                .name("Junior Suite")
                .description("Elegant junior suite with a separate living area.")
                .capacity(3)
                .pricePerNight(199.99f)
                .build());

        RoomTypeEntity suite = roomTypeRepository.save(RoomTypeEntity.builder()
                .name("Suite")
                .description("Luxurious suite with panoramic views and premium amenities.")
                .capacity(4)
                .pricePerNight(299.99f)
                .build());

        roomRepository.saveAll(List.of(
                RoomEntity.builder().floor(1).roomNumber("101").roomType(standard).build(),
                RoomEntity.builder().floor(1).roomNumber("102").roomType(standard).build(),
                RoomEntity.builder().floor(1).roomNumber("103").roomType(standard).build(),
                RoomEntity.builder().floor(1).roomNumber("104").roomType(deluxe).build(),
                RoomEntity.builder().floor(1).roomNumber("105").roomType(deluxe).build(),
                RoomEntity.builder().floor(2).roomNumber("201").roomType(standard).build(),
                RoomEntity.builder().floor(2).roomNumber("202").roomType(standard).build(),
                RoomEntity.builder().floor(2).roomNumber("203").roomType(deluxe).build(),
                RoomEntity.builder().floor(2).roomNumber("204").roomType(deluxe).build(),
                RoomEntity.builder().floor(3).roomNumber("301").roomType(juniorSuite).build(),
                RoomEntity.builder().floor(3).roomNumber("302").roomType(juniorSuite).build(),
                RoomEntity.builder().floor(3).roomNumber("303").roomType(suite).build()
        ));
    }
}
