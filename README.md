# SmartChat API

SmartChat is a Spring Boot-based API that connects to Large Language Models (LLMs) via [OpenRouter.ai](https://openrouter.ai), enabling developers to interact with models such as GPT-4, Mistral, and more using a unified format.

This project is built using Java 17, Spring Boot 3.2, and WebClient (reactive) to ensure scalability and non-blocking I/O.

---

## 🚀 Features

- Java 17 + Spring Boot 3.2+
- Reactive WebClient (WebFlux)
- Integration with OpenRouter (proxy to OpenAI, Mistral, etc.)
- Docker and Docker Compose support
- Clean architecture: DTOs, Service, Controller
- Unit test with WebTestClient and Mockito

---

## 📦 Clone and Setup

```bash
git clone https://github.com/pedrotaek-git/smartchat-api
```

---

## 🧠 Import into IntelliJ IDEA

- Open IntelliJ IDEA
- Select **Open** and choose the project directory
- IntelliJ will automatically detect the `build.gradle` file
- Wait for Gradle to finish syncing

---

## 🔐 Environment Configuration

The project requires an OpenRouter API Key. You can create a free account and generate the key at:  
👉 https://openrouter.ai/account/keys

### Option 1 — Export variable in your system:

#### Linux / macOS:
```bash
export OPENAI_API_KEY=sk-xxxxx
```

#### Windows (PowerShell):
```powershell
$env:OPENAI_API_KEY="sk-xxxxx"
```

### Option 2 — Use a `.env` file (recommended for quick validation)

You can also create a `.env` file in the **root directory of the project** with the following content:

```
OPENAI_API_KEY=sk-xxxxx
```

This allows you to test locally without modifying system environment variables.

---

## 🧪 Run Tests

To ensure everything is working, run:

```bash
./gradlew test
```

This will execute the unit test located at:

```
src/test/java/com/smartchat/controller/ChatMessageControllerTest.java
```

---

## ⚙️ Build the Project

To compile the application:

```bash
./gradlew build
```

---

## 🐳 Run with Docker Compose

The project includes a `Dockerfile` and `docker-compose.yml`.

To build and run the container:

```bash
docker-compose up --build
```

Make sure the `OPENAI_API_KEY` is set as an environment variable or in your `.env` file before running Docker.

---

## 🧪 Test the API

Once the application is running locally, test the endpoint using `curl`:

```bash
curl -X POST http://localhost:8080/api/chat   -H "Content-Type: application/json"   -d '{
    "model": "mistralai/mistral-7b-instruct",
    "messages": [
      {
        "role": "user",
        "content": "What is the capital of France?"
      }
    ],
    "temperature": 0.7
  }'
```

✅ Expected response:

```json
"The capital of France is Paris."
```

---

## 📁 Project Structure

```
src/main/java/com/smartchat/
├── SmartChatApplication.java
├── controller/
│   └── ChatMessageController.java
├── dto/
│   ├── ChatCompletionRequest.java
│   ├── ChatCompletionResponse.java
├── service/
│   ├── ChatService.java
│   └── impl/
│       └── ChatServiceImpl.java
```