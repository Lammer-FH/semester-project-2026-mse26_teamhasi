package at.teamhasi.hotel.services.exceptions;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Integer roomId) {
        super("Room with id " + roomId + " not found");
    }
}
