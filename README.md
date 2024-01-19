
# Spring Boot Property Management

Welcome to the Spring Boot Property Management repository! This project showcases the creation of a Spring Boot application with RESTful APIs, designed for seamless integration with Apigee API Gateway. Follow the steps below to build, test, and deploy the application.

![Alt Text](https://miro.medium.com/v2/resize:fit:828/format:webp/1*Jyc154Bp8kAwzEgQJTW_fQ.jpeg)

## Project Overview
This project encompasses the development of a Spring Boot application using Hibernate for REST-based APIs, emphasizing user registration, login, and property management functionalities. The application is structured according to the OpenAPI Specification (OAS) standards and supports testing in both local and production environments.

### Steps to Build and Deploy
**Step 1: Build the App**
Before proceeding, ensure you have Maven installed. Run the following command in the project root directory to create the app.jar:

```bash
mvn install
```

**Step 2: Dockerize the Application**
The Dockerfile in the project root directory simplifies the containerization process. Assuming Docker is installed, use the following command to build the Docker image:

```bash
docker build -t <YOUR_USERNAME_ON_DOCKER_HUB>/<IMAGE_NAME> .
```

**Step 3: Test the Dockerized App**
Once the Docker image is created, test it locally using the following command:

```bash
docker run -d -p 8080:8080 <YOUR_USERNAME_ON_DOCKER_HUB>/<IMAGE_NAME>
```

**Step 4: Test the Spring Boot App**
After running the Docker container, verify the functionality of the Spring Boot application by navigating to http://localhost:8080 in your web browser.

**Step 5: Push the Image to Docker Hub**
When satisfied with the local testing, push the Docker image to your Docker Hub repository using the following command:
```bash
docker push <YOUR_USERNAME_ON_DOCKER_HUB>/<IMAGE_NAME>
```

### Apigee Integration
This project is designed with future Apigee integration in mind. Stay tuned for updates on integrating an API Proxy on Apigee in front of a virtual instance running this Spring Boot application.

## Links
[Medium Article](https://medium.com/@karanbhogle/my-experiment-of-creating-a-containerized-spring-boot-application-ready-for-apigee-integration-f89de037329c)

[Docker Hub Repository](https://hub.docker.com/repository/docker/karanbhogle/spring-user-property-app)
