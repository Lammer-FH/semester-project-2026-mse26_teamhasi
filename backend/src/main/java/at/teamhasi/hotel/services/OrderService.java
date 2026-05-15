package at.teamhasi.hotel.services;

import at.teamhasi.hotel.dto.OrderDto;
import at.teamhasi.hotel.dto.OrderResponseDto;
import at.teamhasi.hotel.dto.RoomDto;
import at.teamhasi.hotel.dto.UserDto;
import at.teamhasi.hotel.entities.OrderEntity;
import at.teamhasi.hotel.entities.RoomEntity;
import at.teamhasi.hotel.entities.UserEntity;
import at.teamhasi.hotel.enums.EOrderStatus;
import at.teamhasi.hotel.repositories.OrderRepository;
import at.teamhasi.hotel.repositories.RoomRepository;
import at.teamhasi.hotel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public OrderResponseDto createOrder(OrderDto orderDto) {

        Boolean doesUserExist = doesUserExist(orderDto.getUser().getUsername());
        if (!doesUserExist) {
            this.createUser(orderDto.getUser());
        }

        OrderEntity orderEntity = this.saveOrder(orderDto);

        int nights = (int) ChronoUnit.DAYS.between(orderEntity.getBookingStart(), orderEntity.getBookingEnd());
        return OrderResponseDto.builder()
                .id(orderEntity.getId())
                .status(orderEntity.getStatus())
                .bookingStart(orderEntity.getBookingStart())
                .bookingEnd(orderEntity.getBookingEnd())
                .nights(nights)
                .hasBreakfast(orderEntity.getHasBreakfast())
                .user(UserDto.fromEntity(orderEntity.getUser()))
                .room(RoomDto.fromEntity(orderEntity.getRoom()))
                .build()
                ;
    }


    private Boolean doesUserExist(String username) {
        return findUserByUsername(username) != null;
    }

    private UserEntity findUserByUsername(String username) {
        List<UserEntity> users = this.userRepository.findUserEntityByUsername(username);
        if (users.isEmpty()) return null;
        return users.getFirst();
    }

    private void createUser(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();

        this.userRepository.save(userEntity);
    }

    private OrderEntity saveOrder(OrderDto orderDto) throws NoSuchElementException {
        RoomEntity roomEntity = roomRepository.findById(orderDto.getRoomId()).orElseThrow();
        UserEntity userEntity = this.findUserByUsername(orderDto.getUser().getUsername());

        OrderEntity orderEntity = OrderEntity.builder()
                .bookingStart(orderDto.getBookingStart())
                .bookingEnd(orderDto.getBookingEnd())
                .status(EOrderStatus.CONFIRMED)
                .hasBreakfast(orderDto.getHasBreakfast())
                .user(userEntity)
                .room(roomEntity)
                .build();

        return this.orderRepository.save(orderEntity);
    }
}
