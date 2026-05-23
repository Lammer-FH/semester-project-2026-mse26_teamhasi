# Hotel Hasi

## Run with Docker

```bash
docker compose up --build
```

| Service  | URL                   |
|----------|-----------------------|
| Frontend | http://localhost:3000 |
| Backend  | http://localhost:8080 |
| Database | localhost:3306        |

## Database Access

```bash
# Connect via CLI
docker exec -it $(docker compose ps -q mysql) mysql -u admin -padmin hotel

# Or connect with a GUI tool (TablePlus, DBeaver, etc.)
# Host: localhost  Port: 3306  User: admin  Password: admin  Database: hotel
```

## Local Development

### Backend
```bash
cd backend
gradlew bootRun
```
Requires a running MySQL instance on port 3306 with database `hotel`, user `admin`, password `admin`.

### Frontend
```bash
cd frontend
npm install
npm run dev
```
Available at http://localhost:5173
