package at.teamhasi.hotel.services;

import at.teamhasi.hotel.dto.OrderDto;
import at.teamhasi.hotel.entities.OrderEntity;
import at.teamhasi.hotel.entities.RoomEntity;
import at.teamhasi.hotel.entities.UserEntity;
import at.teamhasi.hotel.enums.EOrderStatus;
import at.teamhasi.hotel.repositories.OrderRepository;
import at.teamhasi.hotel.repositories.RoomRepository;
import at.teamhasi.hotel.services.exceptions.RoomNotAvailableException;
import at.teamhasi.hotel.services.exceptions.RoomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final RoomRepository roomRepository;
    private final UserService userService;

    public OrderEntity createOrder(OrderDto orderDto) {
        UserEntity user = userService.findOrCreate(orderDto.getUser());
        return saveOrder(orderDto, user);
    }

    private OrderEntity saveOrder(OrderDto orderDto, UserEntity user) {
        RoomEntity room = roomRepository.findById(orderDto.getRoomId())
                .orElseThrow(() -> new RoomNotFoundException(orderDto.getRoomId()));

        if (orderRepository.existsOverlappingBooking(orderDto.getRoomId(), orderDto.getBookingStart(), orderDto.getBookingEnd())) {
            throw new RoomNotAvailableException();
        }

        return orderRepository.save(OrderEntity.builder()
                .bookingStart(orderDto.getBookingStart())
                .bookingEnd(orderDto.getBookingEnd())
                .status(EOrderStatus.CONFIRMED)
                .hasBreakfast(orderDto.getHasBreakfast())
                .user(user)
                .room(room)
                .build());
    }
}