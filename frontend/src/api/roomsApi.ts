import {getOpenAPIDefinition} from '@/generated/api';
import {apiClient} from './client';

const {getRooms, createOrder, getRoomAvailable} = getOpenAPIDefinition(apiClient);

export {getRooms, createOrder, getRoomAvailable};
