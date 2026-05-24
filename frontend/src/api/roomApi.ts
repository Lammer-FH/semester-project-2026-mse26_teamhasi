import axios from 'axios';

const api = axios.create({ baseURL: 'http://localhost:8080' });

export interface RoomExtra {
    name: string;
    description?: string;
    icon_key: string;
}

export interface Media {
    path: string;
    title: string;
    description?: string;
    alt_text: string;
    sort_helper: number;
}

export interface Room {
    id: number;
    name: string;
    description: string;
    capacity: number;
    price_per_night: number;
    media: Media[];
    extras: RoomExtra[];
}

export interface Pagination {
    limit: number;
    offset: number;
    total_count: number;
    next_offset?: number | null;
}

export interface RoomsResponse {
    data: Room[];
    pagination: Pagination;
}

export interface RoomAvailability {
    room_id: number;
    available: boolean;
    check_in?: string;
    check_out?: string;
    unavailable_dates?: string[];
}

export const getRooms = (params: {
    limit?: number;
    offset?: number;
    check_in?: string;
    check_out?: string;
}) => api.get<RoomsResponse>('/rooms', { params });

export const checkRoomAvailability = (id: number, checkIn: string, checkOut: string) =>
    api.get<RoomAvailability>(`/rooms/${id}/available`, {
        params: { check_in: checkIn, check_out: checkOut },
    });