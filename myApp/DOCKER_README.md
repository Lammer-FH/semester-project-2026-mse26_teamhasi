# Docker Setup Guide

This application is now containerized with Docker and uses MySQL as the database.

## Prerequisites

- Docker Engine (version 20.10+)
- Docker Compose (version 2.0+)

## Quick Start

### Build and Run the Application

```bash
# Navigate to the myApp directory
cd myApp

# Build and start all services
docker-compose up -d

# View logs
docker-compose logs -f

# Stop services
docker-compose down

# Stop services and remove volumes
docker-compose down -v
```

### Services

- **web**: Node.js/Vue application running on `http://localhost:3000`
- **db**: MySQL 8.0 database running on `localhost:3306`

## Database Access

### From Container
```bash
docker exec -it myapp_db mysql -u appuser -papppass mydb
# Password: apppass
```

### From Host Machine
```bash
mysql -h 127.0.0.1 -P 3306 -u appuser -p
# Password: apppass
```

### Database Credentials
- **Database**: mydb
- **User**: appuser
- **Password**: apppass
- **Root Password**: rootpass

## Useful Commands

### Docker & Services
```bash
# View all containers
docker ps

# View logs for specific service
docker-compose logs web
docker-compose logs db

# Rebuild the web image
docker-compose build web

# Run a one-off command in the web container
docker exec -it myapp_web npm test

# Stop but keep containers (useful for debugging)
docker-compose stop

# Resume stopped containers
docker-compose start
```

### Database Interaction Commands

```bash
# List all databases
SHOW DATABASES;

# Use the mydb database
USE mydb;

# Show all tables in mydb
SHOW TABLES;

# Show table structure/schema
DESCRIBE table_name;

# View all columns in a table
SHOW COLUMNS FROM table_name;

# Execute a SELECT query
SELECT * FROM table_name LIMIT 10;

Enclose the table name in `backticks` if it does not work
```

## Troubleshooting

### Web service won't start
Check the logs: `docker-compose logs web`

### Database connection issues
Verify the database is healthy: `docker-compose logs db`
Wait for health check to pass before the web service starts.

### Port conflicts
If ports 3000 or 3306 are already in use, modify in `docker-compose.yml`:
```yaml
ports:
  - "YOUR_PORT:3000"  # For web
  - "YOUR_PORT:3306"  # For MySQL
```

### Rebuild everything from scratch
```bash
docker-compose down -v
docker-compose build --no-cache
docker-compose up -d
```

## Development Workflow

For development, you can still run the app locally:
```bash
npm install
npm run dev
```

The Docker setup is useful for:
- Production deployments
- Testing with MySQL backend
- Ensuring consistency across team members
- CI/CD pipelines
