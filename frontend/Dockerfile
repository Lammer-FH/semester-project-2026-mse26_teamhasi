# Stage 1: Build stage
FROM node:24-alpine AS builder

WORKDIR /app

# Copy package files
COPY package*.json ./

# Install dependencies from package-lock.json
RUN npm ci


# Copy source code
COPY . .

# Build the Vue app with Vite
RUN npm run orval
RUN npm run build

# Stage 2: Production stage
FROM node:24-alpine

WORKDIR /app

# Install a simple HTTP server to serve the built app
RUN npm install -g serve

# Copy built files from builder stage
COPY --from=builder /app/dist ./dist

# Expose port for the app
EXPOSE 3000

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD node -e "require('http').get('http://localhost:3000', (r) => {if (r.statusCode !== 200) throw new Error(r.statusCode)})"

# Serve the built app
CMD ["serve", "-s", "dist", "-l", "3000"]
