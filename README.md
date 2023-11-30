# Micronaut-Selenide-Owner-Java

This Java project serves as a test automation framework using Micronaut, Selenide, JUnit 5, Allure Selenide, and Owner libraries. The aim is to showcase how to set up and run Selenium tests with Micronaut as the application framework, incorporating Selenide for browser automation, JUnit 5 for test execution, and Selenoid for browser orchestration.

## Technologies Used:
- Java 17
- Micronaut
- Selenide
- JUnit 5
- Allure Selenide
- Owner
- Maven

## Configuration:
The project utilizes a property file `test.properties` with the following parameters:
- `base.url=https://www.jetbrains.com/`
- `selenoid.url=http://localhost:4444/wd/hub`
- `browser.name=chrome`
- `browser.headless=true`
- `remote.run=false`

These properties can be overridden through the Owner library.

## Micronaut Integration:
Micronaut dependency injection is leveraged in the project. The `MainPage` class is annotated with `@Singleton`, and injection is performed using the `@Inject` annotation in the `MainPageTest` class.

### Example of Micronaut Injection:
```java
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainPage {

    // Micronaut injects this dependency
    @Inject
    private SomeService someService;

    // ... rest of the class
}

@Singleton
public class SomeService {
    // Service implementation
}
```

## How to Run:

### 1. Start Selenoid with Docker Compose:
Ensure Docker is installed on your machine.

Navigate to the project directory and run the following command to start Selenoid using Docker Compose:
```bash
docker-compose -f src/test/resources/selenoid_docker_compose/docker-compose.yml up -d
```

This command will spin up Selenoid and its associated containers.

### 2. Run Tests with Maven:
Execute the following Maven command to run the tests:
```bash
mvn clean test
```

This command will execute the tests defined in the `MainPageTest` class annotated with `@MicronautTest`. The tests will use the specified Selenoid configuration for browser automation.

### 3. View Allure Reports:
After the test run, Allure Selenide generates detailed test reports that can be found in the `target/allure-results` directory. To view the generated reports, run:
```bash
mvn allure:serve
```

This will open the Allure report in your default web browser, allowing you to inspect the results of the test run.

Feel free to explore and modify the project according to your testing needs. Happy testing!