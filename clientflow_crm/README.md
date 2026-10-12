# ClientFlow CRM — Enterprise CRM Starter

A client-style CRM web application starter with a React frontend and Java Spring Boot REST API.

## Included features
- Dashboard KPIs and sales pipeline summary
- Lead listing, search, status updates, and lead creation
- Customer directory
- Follow-up task listing and task creation
- REST API with sample data
- H2 database for quick local development
- PostgreSQL configuration example
- GitHub-ready project structure

> This is a development starter with sample data, not a production-ready deployment. Before real client use, add authentication/authorization, validation, audit logs, secure secrets, backups, monitoring, and privacy/compliance review.

## Requirements
- Java 17+
- Node.js 20+
- npm

## Run the backend
Open a terminal:

```bash
cd backend
./mvnw spring-boot:run
```

If the Maven wrapper is not available on your machine, install Maven and run:

```bash
mvn spring-boot:run
```

Windows PowerShell:
```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

Backend URL: `http://localhost:8080`
H2 console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:clientflow`
- Username: `sa`
- Password: leave blank

## Run the frontend
In a second terminal:

```bash
cd frontend
npm install
npm run dev
```

Open the Vite URL shown in the terminal, usually `http://localhost:5173`.

## API endpoints
- `GET /api/dashboard`
- `GET /api/leads`
- `POST /api/leads`
- `PATCH /api/leads/{id}/status`
- `GET /api/customers`
- `POST /api/customers`
- `GET /api/tasks`
- `POST /api/tasks`

## PostgreSQL configuration
The default profile uses H2 so the project runs without installing a database. To switch to PostgreSQL, edit `backend/src/main/resources/application-postgres.properties`, set environment variables `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD`, then start with the `postgres` Spring profile.

## Suggested Git workflow
Create a repository, commit meaningful working increments, and use branches/PRs for features. Do not create empty commits just to inflate the commit count. Build a real history as features, tests, documentation, and fixes are completed.
