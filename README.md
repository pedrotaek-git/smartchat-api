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

🧠 Import into IntelliJ IDEA
Open IntelliJ IDEA

Select Open and choose the project directory

IntelliJ will automatically detect the build.gradle file

Wait for Gradle to finish syncing

🔐 Environment Configuration
The project requires an OpenRouter API Key. You can create a free account and generate the key at https://openrouter.ai.

Set your environment variable:

Linux / macOS


export OPENAI_API_KEY=sk-xxxxx
Windows (PowerShell)

$env:OPENAI_API_KEY="sk-xxxxx"
🧪 Run Tests
To ensure everything is working, run:


./gradlew test
This will run the unit test located in:


src/test/java/com/smartchat/controller/ChatMessageControllerTest.java
⚙️ Build the Project
To compile the application:


./gradlew build
🐳 Run with Docker Compose
The project includes a Dockerfile and docker-compose.yml.

To build and run the container:


docker-compose up --build
Make sure the OPENAI_API_KEY environment variable is set before running Docker.

🧪 Test the API
Once running locally, test with curl:


curl -X POST http://localhost:8080/api/chat \
  -H "Content-Type: application/json" \
  -d '{
    "model": "mistralai/mistral-7b-instruct",
    "messages": [
      {
        "role": "user",
        "content": "What is the capital of France?"
      }
    ],
    "temperature": 0.7
  }'
Expected response:


"The capital of France is Paris."

📁 Project Structure

src/main/java/com/smartchat/
├── SmartChatApplication.java
├── controller/ChatMessageController.java
├── dto/
│   ├── ChatCompletionRequest.java
│   ├── ChatCompletionResponse.java
├── service/
│   ├── ChatService.java
│   └── impl/ChatServiceImpl.java