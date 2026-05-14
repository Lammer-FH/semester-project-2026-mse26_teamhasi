-- -------------------------------------------------------
-- Room Types (15)
-- -------------------------------------------------------
INSERT IGNORE INTO room_type (room_type_id, name, description, capacity, price_per_night) VALUES
(1,  'Standard Single',   'Comfortable single room with all essential amenities.',                                        1, 79.99),
(2,  'Standard Double',   'Cozy double room perfect for couples or business travelers.',                                  2, 99.99),
(3,  'Standard Twin',     'Bright twin room with two separate beds.',                                                     2, 99.99),
(4,  'Superior Single',   'Upgraded single room with enhanced furnishings and city views.',                               1, 109.99),
(5,  'Superior Double',   'Spacious superior double with premium bedding and panoramic views.',                           2, 129.99),
(6,  'Superior Twin',     'Refined superior twin with two queen beds and elegant décor.',                                 2, 129.99),
(7,  'Deluxe Single',     'Stylish deluxe single with designer touches and premium amenities.',                           1, 149.99),
(8,  'Deluxe Double',     'Spacious deluxe double with king-size bed and floor-to-ceiling city view.',                    2, 169.99),
(9,  'Deluxe Twin',       'Elegant deluxe twin with two full beds and premium furnishings.',                              2, 169.99),
(10, 'Junior Suite',      'Elegant junior suite with a separate living area and premium amenities.',                      3, 219.99),
(11, 'Executive Suite',   'Sophisticated executive suite with panoramic city views and a dedicated work area.',           3, 279.99),
(12, 'Family Room',       'Spacious family room designed for up to four guests with bunk beds.',                         4, 189.99),
(13, 'Family Suite',      'Generous family suite with two bedrooms and a shared living space.',                          5, 269.99),
(14, 'Penthouse Suite',   'Exclusive penthouse with 360-degree panoramic views and top-tier amenities.',                  4, 449.99),
(15, 'Accessible Room',   'Barrier-free room thoughtfully designed for guests with mobility needs.',                     2, 109.99);

-- -------------------------------------------------------
-- Room Extras (8)
-- -------------------------------------------------------
INSERT IGNORE INTO room_extra (room_extra_id, name, description, icon_key) VALUES
(1, 'Free WiFi',      'High-speed wireless internet access throughout the room.',   'wifi'),
(2, 'Mini Bar',       'Stocked mini bar with beverages and snacks.',                'minibar'),
(3, 'In-Room Safe',   'Electronic safe large enough for a laptop.',                 'safe'),
(4, 'Balcony',        'Private balcony with outdoor seating and scenic views.',     'balcony'),
(5, 'Bathtub',        'Deep-soak bathtub with premium bath products.',              'bathtub'),
(6, 'Sea View',       'Unobstructed sea views from your room.',                     'seaview'),
(7, 'Mountain View',  'Breathtaking mountain scenery visible from every window.',   'mountain'),
(8, 'City View',      'Panoramic city skyline views day and night.',                'cityview');

-- -------------------------------------------------------
-- Media (8)
-- -------------------------------------------------------
INSERT IGNORE INTO media (media_id, path, title, description, alt_text, sort_helper) VALUES
(1, '/images/rooms/standard.jpg',          'Standard Room',          'Modern furnishings and a comfortable bed.',            'Standard room with double bed',            1),
(2, '/images/rooms/superior.jpg',          'Superior Room',          'Elegant superior room with premium décor.',            'Superior room with queen bed',             1),
(3, '/images/rooms/deluxe.jpg',            'Deluxe Room',            'Spacious deluxe room with floor-to-ceiling windows.',  'Deluxe room with city view window',        1),
(4, '/images/rooms/suite-living.jpg',      'Suite Living Area',      'Separate living area with sofa and entertainment.',    'Suite living room with sofa and TV',       1),
(5, '/images/rooms/bathroom-premium.jpg',  'Premium Bathroom',       'Marble bathroom with soaking tub and rain shower.',    'Luxury bathroom with bathtub',             2),
(6, '/images/rooms/city-view.jpg',         'City Panorama',          'Floor-to-ceiling windows with stunning city views.',   'Panoramic city view from window',          1),
(7, '/images/rooms/family-room.jpg',       'Family Room',            'Spacious layout with multiple sleeping areas.',        'Family room with bunk beds',               1),
(8, '/images/rooms/penthouse.jpg',         'Penthouse Terrace',      '360-degree rooftop terrace with skyline views.',       'Penthouse outdoor terrace',                1);

-- -------------------------------------------------------
-- Rooms
-- -------------------------------------------------------
INSERT IGNORE INTO room (room_id, floor, room_type_id, room_number) VALUES
-- Standard Single (type 1)
(1,  1, 1,  '101'), (2,  1, 1,  '102'),
-- Standard Double (type 2)
(3,  1, 2,  '103'), (4,  1, 2,  '104'), (5,  1, 2,  '105'),
-- Standard Twin (type 3)
(6,  1, 3,  '106'), (7,  1, 3,  '107'), (8,  1, 3,  '108'),
-- Superior Single (type 4)
(9,  2, 4,  '201'), (10, 2, 4,  '202'),
-- Superior Double (type 5)
(11, 2, 5,  '203'), (12, 2, 5,  '204'), (13, 2, 5,  '205'),
-- Superior Twin (type 6)
(14, 2, 6,  '206'), (15, 2, 6,  '207'), (16, 2, 6,  '208'),
-- Deluxe Single (type 7)
(17, 2, 7,  '209'), (18, 2, 7,  '210'),
-- Deluxe Double (type 8)
(19, 3, 8,  '301'), (20, 3, 8,  '302'), (21, 3, 8,  '303'),
-- Deluxe Twin (type 9)
(22, 3, 9,  '304'), (23, 3, 9,  '305'), (24, 3, 9,  '306'),
-- Junior Suite (type 10)
(25, 3, 10, '307'), (26, 3, 10, '308'),
-- Executive Suite (type 11)
(27, 3, 11, '309'), (28, 3, 11, '310'),
-- Family Room (type 12)
(29, 4, 12, '401'), (30, 4, 12, '402'),
-- Family Suite (type 13)
(31, 4, 13, '403'),
-- Penthouse Suite (type 14)
(32, 4, 14, '404'),
-- Accessible Room (type 15)
(33, 1, 15, '109'), (34, 1, 15, '110');

-- -------------------------------------------------------
-- Room Type <-> Media
-- -------------------------------------------------------
INSERT IGNORE INTO room_type_has_media (room_type_id, media_id) VALUES
-- Standard types
(1, 1), (2, 1), (3, 1),
-- Superior types
(4, 2), (4, 6), (5, 2), (5, 6), (6, 2), (6, 6),
-- Deluxe types
(7, 3), (7, 6), (8, 3), (8, 5), (8, 6), (9, 3), (9, 5), (9, 6),
-- Junior Suite
(10, 3), (10, 4), (10, 5), (10, 6),
-- Executive Suite
(11, 3), (11, 4), (11, 5), (11, 6),
-- Family types
(12, 7), (13, 7),
-- Penthouse
(14, 4), (14, 5), (14, 8),
-- Accessible
(15, 1);

-- -------------------------------------------------------
-- Room Type <-> Extras
-- -------------------------------------------------------
INSERT IGNORE INTO room_type_has_extras (room_type_id, room_extra_id) VALUES
-- Standard Single: WiFi, Safe
(1,1),(1,3),
-- Standard Double: WiFi, Mini Bar, Safe
(2,1),(2,2),(2,3),
-- Standard Twin: WiFi, Mini Bar, Safe
(3,1),(3,2),(3,3),
-- Superior Single: WiFi, Mini Bar, Safe, City View
(4,1),(4,2),(4,3),(4,8),
-- Superior Double: WiFi, Mini Bar, Safe, City View
(5,1),(5,2),(5,3),(5,8),
-- Superior Twin: WiFi, Mini Bar, Safe, City View
(6,1),(6,2),(6,3),(6,8),
-- Deluxe Single: WiFi, Mini Bar, Safe, Bathtub, Mountain View
(7,1),(7,2),(7,3),(7,5),(7,7),
-- Deluxe Double: WiFi, Mini Bar, Safe, Bathtub, City View
(8,1),(8,2),(8,3),(8,5),(8,8),
-- Deluxe Twin: WiFi, Mini Bar, Safe, Bathtub, Mountain View
(9,1),(9,2),(9,3),(9,5),(9,7),
-- Junior Suite: WiFi, Mini Bar, Safe, Balcony, Bathtub, City View
(10,1),(10,2),(10,3),(10,4),(10,5),(10,8),
-- Executive Suite: WiFi, Mini Bar, Safe, Balcony, Bathtub, City View
(11,1),(11,2),(11,3),(11,4),(11,5),(11,8),
-- Family Room: WiFi, Mini Bar, Safe, City View
(12,1),(12,2),(12,3),(12,8),
-- Family Suite: WiFi, Mini Bar, Safe, Balcony, City View
(13,1),(13,2),(13,3),(13,4),(13,8),
-- Penthouse Suite: WiFi, Mini Bar, Safe, Balcony, Bathtub, Sea View
(14,1),(14,2),(14,3),(14,4),(14,5),(14,6),
-- Accessible Room: WiFi, Safe
(15,1),(15,3);
