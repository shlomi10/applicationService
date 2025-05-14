# Shuffle Application Service 🌀

![Java 17](https://img.shields.io/badge/Java-17-blue?logo=openjdk\&logoColor=white)
![Spring Boot 3.4.5](https://img.shields.io/badge/Spring_Boot-3.4.5-brightgreen?logo=springboot\&logoColor=white)
![Maven 3.9.9](https://img.shields.io/badge/Maven-3.9.9-red?logo=apachemaven\&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Containerized-blue?logo=docker)
![Swagger](https://img.shields.io/badge/Swagger-Enabled-green?logo=swagger)

This microservice provides an API to return a shuffled list of numbers from 1 to a given value (max 1000). It forwards the request to a logging microservice for asynchronous logging.

---

## Features ✨

* POST endpoint `/shuffle` to generate a shuffled array.
* Asynchronous logging to external log service.
* Built with Spring Boot 3 and Java 17.
* Swagger UI for API documentation.

---

## API 📡

### POST `/shuffle`

**Body:**

```json
{ "number": 10 }
```

**Response:**

```json
[8, 3, 10, 1, 7, 2, 4, 6, 9, 5]
```

---

## Swagger UI 📖

Available at: `http://localhost:8080/swagger-ui/index.html`

---

## Requirements ⚙️

* Java 17+
* Maven 3.6+
* Docker
* Docker Compose

---

## Getting Started 🚀

### 1. Clone the repository

```bash
git clone https://github.com/shlomi10/applicationService.git applicationService
cd applicationService
```

### 2. Package the application

```bash
mvn clean package -DskipTests
```

### 3. Build and run the system (with log service)

Make sure to run docker build on the log service  directory 
Then `docker-compose.yml` containing both `applicationService/` and `logProject/`.

```bash
docker-compose up --build
```

---

## Endpoints Summary 📘

| Method | Path     | Description            |
| ------ | -------- | ---------------------- |
| POST   | /shuffle | Returns shuffled array |

---

## Tech Stack 🛠️

* Spring Boot 3.4
* Java 17
* Maven
* Docker / Docker Compose
* Springdoc OpenAPI (Swagger)

---

## Notes 📝

* The logging service must be accessible via `LOG_SERVICE_URL`.
* Swagger won't show if the app is not started or if `/v3/api-docs` is not generated.

## License 📄

MIT License

Copyright (c) 2025 shlomi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in  
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE  
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER  
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN  
THE SOFTWARE.
