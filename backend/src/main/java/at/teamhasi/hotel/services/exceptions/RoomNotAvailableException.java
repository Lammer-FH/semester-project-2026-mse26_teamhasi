package at.teamhasi.hotel.services.exceptions;

public class RoomNotAvailableException extends RuntimeException {
    public RoomNotAvailableException() {
        super("The requested room is not available for the selected dates");
    }
}
