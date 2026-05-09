# Boutique Hotel Technikum - Booking Application

A modern, mobile-first hotel booking application for the Boutique Hotel Technikum built with Vue.js 3, Ionic, and Spring Boot.

## About the Project

This is a fullstack web application that allows guests to browse hotel rooms, check availability, and make bookings for the Boutique Hotel Technikum. The application is designed to handle up to 100 visitors per day and is optimized for both mobile devices and desktop browsers.

### Key Features

- **Hotel Presentation**: Static pages showcasing the hotel (landing page, about, imprint)
- **Room Selection**: Browse available hotel rooms with detailed information and images
- **Availability Check**: Check room availability for specific dates
- **Booking System**: Complete booking flow with form validation and confirmation
- **Responsive Design**: Mobile-first interface using Ionic framework
- **State Management**: Pinia for predictable state management
- **Type Safety**: TypeScript throughout the application

### Technology Stack

**Frontend:**
- Vue.js 3
- Ionic 8
- Vite (Build tool)
- Pinia (State management)
- Axios (HTTP client)
- TypeScript
- Capacitor (Optional native platform support)

**Backend:**
- Spring Boot (Java, v3+)
- MySQL Database

**Development Tools:**
- GitHub / Git
- ESLint (Code linting)
- Vitest (Unit testing)
- Cypress (E2E testing)

## Prerequisites

- Node.js (v16+ recommended, v18+ for optimal compatibility)
- npm or yarn
- Backend server running on `http://localhost:8080` (Spring Boot)
- For native builds: Capacitor CLI, Android Studio (Android) or Xcode (iOS)

## Quick Start

### Option 1: Using Docker (Recommended)

The easiest way to get the application and MySQL database running:

```bash
# Clone the repository
git clone https://github.com/Lammer-FH/semester-project-2026-mse26_teamhasi.git
cd semester-project-2026-mse26_teamhasi/myApp

# Build and start all services (web app + MySQL)
docker-compose up -d

# Verify services are running
docker-compose ps
```

Access the application at `http://localhost:3000`

For detailed Docker instructions, database commands, and troubleshooting, see [DOCKER_README.md](myApp/DOCKER_README.md).

### Option 2: Local Development

For development without Docker:

```bash
# Clone the repository
git clone https://github.com/Lammer-FH/semester-project-2026-mse26_teamhasi.git
cd semester-project-2026-mse26_teamhasi
```

#### Install Dependencies

```bash
cd myApp
npm install
```

#### Start Development Server

```bash
npm run dev
```

The application will be available at `http://localhost:5173` (or the port shown in terminal output).

## Available Commands

### Development & Building

- `npm run dev` - Start development server with hot reload
- `npm run build` - Create production build
- `npm run preview` - Preview production build locally

### Testing & Linting

- `npm run test:unit` - Run unit tests with Vitest
- `npm run test:e2e` - Run end-to-end tests with Cypress
- `npm run lint` - Check code quality with ESLint

## Project Structure

```
semester-project-2026-mse26_teamhasi/
├── myApp/                               # Frontend application
│   ├── src/
│   │   ├── components/                  # Vue components (Atomic Design)
│   │   ├── views/                       # Page components
│   │   ├── stores/                      # Pinia state management
│   │   ├── services/                    # API integration (Axios)
│   │   ├── router/                      # Vue Router configuration
│   │   ├── App.vue                      # Root component
│   │   └── main.ts                      # Application entry point
│   ├── public/                          # Static assets
│   ├── package.json                     # Dependencies and scripts
│   ├── ionic.config.json                # Ionic configuration
│   └── vite.config.ts                   # Vite build configuration
├── docs/                                # Project documentation
│   ├── project-assignment2026.txt       # Project requirements & guidelines
│   └── ProjektSpezifikation2026.txt     # Detailed user story specifications
├── deliverables/                        # Milestone deliverables
│   └── ms1/                             # Milestone 1 deliverables
└── README.md                            # This file
```

## User Stories

This application implements the following user stories from the project specification:

1. **U1 - Hotel Website**: Browse hotel information (landing, about, imprint)
2. **U2 - Room Selection**: View available rooms with details and pagination
3. **U3 - Check Availability**: Check room availability for desired dates
4. **U4 - Book a Room**: Complete booking form with validation and confirmation
5. **U5 - Booking Confirmation**: Enhanced confirmation and booking management

For detailed specifications, see `docs/ProjektSpezifikation2026.txt`.

## Development Guidelines

### Code Quality

This project follows these practices:
- **Clean Code** principles
- **Clean Architecture** patterns (as per R. Martin)
- **Atomic Design** for component structure
- **TypeScript** for type safety
- **Richardson Maturity Model** (Level 2) for REST API design

## Useful Resources

- [Ionic Vue Documentation](https://ionicframework.com/docs/vue/overview)
- [Vue 3 Guide](https://vuejs.org/)
- [Pinia Store Documentation](https://pinia.vuejs.org/)
- [Axios HTTP Client](https://axios-http.com/)
- [Vite Build Tool](https://vitejs.dev/)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)