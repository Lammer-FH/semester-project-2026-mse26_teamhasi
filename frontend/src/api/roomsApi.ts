import { getOpenAPIDefinition } from '@/generated/api';
import { apiClient } from './client';

const { getRooms, createOrder } = getOpenAPIDefinition(apiClient);

export { getRooms, createOrder };
