# SeleniumFwk_PageDriverFactory

A Page–Driver Factory based Selenium framework for automated UI testing.

---

## Table of Contents

- [Overview](#overview)  
- [Features](#features)  
- [Prerequisites](#prerequisites)  
- [Project Structure](#project-structure)  
- [Getting Started](#getting-started)  
- [Usage](#usage)  
- [Configurations](#configurations)  
- [Reporting](#reporting)  
- [Contributing](#contributing)  
- [License](#license)  

---

## Overview

This framework is built with Selenium WebDriver and follows the Page Driver Factory design pattern. It helps in separating page objects from driver instantiation, improving code maintainability and reusability for UI test automation.

---

## Features

- Centralized **DriverFactory** for creating and managing WebDriver instances.  
- Page Object Model structure for organizing page-related logic.  
- Support for multiple browsers (e.g., Chrome, Firefox) and environments.  
- Easy configuration via external files.  
- TestNG or JUnit integration (depending on your setup).  
- Clear reporting and logs for debugging.  

---

## Prerequisites

- Java JDK 8+  
- Maven or Gradle (depending on build setup)  
- Browser drivers (e.g., ChromeDriver, GeckoDriver) installed or managed  
- Internet connection (if tests require remote resources)  

---

## Project Structure

```
SeleniumFwk_PageDriverFactory/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── driver/           ← DriverFactory, WebDriver setup
│   │   │   ├── pages/            ← Page Objects
│   │   │   └── utils/            ← Helpers, utilities, common functions
│   │   └── resources/
│   │       └── config/           ← Configuration files (properties, JSON, etc.)
│   └── test/
│       └── java/                 ← Test classes
│
├── reports/                     ← Test reports, logs
├── drivers/                     ← Browser driver binaries (optional)
├── pom.xml or build.gradle      ← Build and dependency configuration
└── README.md                    
```

---

## Getting Started

1. **Clone the repository**

   ```bash
   git clone https://github.com/sharatsathyanarayan/SeleniumFwk_PageDriverFactory.git
   cd SeleniumFwk_PageDriverFactory
   ```

2. **Install dependencies** (if using Maven)

   ```bash
   mvn clean install
   ```

3. **Configure environment**  
   Update configuration files under `src/main/resources/config/` (e.g. `config.properties`, `env.properties`) to set browser, base URL, timeouts, etc.

4. **Set up WebDriver**  
   If browser drivers are not managed automatically, place the driver binaries in the `drivers/` folder or ensure your system path includes them.

---

## Usage

- To run all tests:

  ```bash
  mvn test
  ```

- To run a specific test suite or class:

  ```bash
  mvn -Dtest=ClassName test
  ```

- To generate reports/logs, check the `reports/` folder after test execution.

---

## Configurations

- **Browser selection** — via configuration file (e.g. `chrome`, `firefox`).  
- **Base URL** — set in config; tests run against this.  
- **Timeouts & Waits** — default implicit/explicit waits configurable.  
- **Parallel execution** — if supported, configurable via TestNG / build file.  
- **Environment-specific settings** — e.g. dev, staging, production.

---

## Reporting

- Test results are generated in `reports/` directory.  
- Screenshots on failure are captured (if implemented) and stored under `reports/screenshots/`.  
- Logs provide detailed steps including driver start-up, navigation, assertion failures, etc.

---
