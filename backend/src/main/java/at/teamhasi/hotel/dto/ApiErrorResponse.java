package at.teamhasi.hotel.dto;

import at.teamhasi.hotel.enums.ApiErrorCode;

public record ApiErrorResponse(String code, String message) {

    public static ApiErrorResponse of(ApiErrorCode errorCode, String message) {
        return new ApiErrorResponse(errorCode.name(), message);
    }
}
