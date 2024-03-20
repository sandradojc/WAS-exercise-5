# Exercise 5: BDI Agents

This repository contains:
  - a partial implementation of a [JaCaMo](https://github.com/jacamo-lang/jacamo) application for completing simple exercises in the AgentSpeak programming language
  - a partial implementation of a [JaCaMo](https://github.com/jacamo-lang/jacamo) application where a BDI agent assists its user through their daily activities.

## Table of Contents
- [Project structure](#project-structure)
- [Task 1](#task-1)
  - [Task 1.1](#task-11)
  - [Task 1.2](#task-12)
- [Task 2](#task-2)
- [Documentation](#documentation)
- [How to run the project](#how-to-run-the-project)


## Project structure
```
├── src
│   ├── agt
│   │   ├── task1
│   │   │   ├── illuminance_controller.asl // agent program of the illuminance controller agent used in Task 1.1
│   │   │   └── simple_agent.asl // agent program of the simple agent used in Task 1.2
│   │   └── task2
│   │       └── personal_assistant.asl // agent program of the personal assistant agent used in Task 2
│   └── env
│       ├── task1
│       │   ├── IlluminanceSensor.java // artifact that can be used for monitoring the illuminance conditions in a room
│       │   ├── LightBulb.java // artifact that can be used for controlling and monitoring the lights in a room
│       │   ├── Blinds.java // artifact that can be used for controlling and monitoring the blinds in a room
│       │   └── WeatherStation.java // artifact that can be used for monitoring the weather conditions 
│       └── task2
│           ├── CalendarService.java // artifact that can be used for managing and monitoring a user's upcoming events
│           ├── Wristband.java // artifact that can be used for monitoring whether a user is asleep or awake
│           ├── LightBulb.java // artifact that can be used for controlling and monitoring the lights in a room
│           ├── Blinds.java // artifact that can be used for controlling and monitoring the blinds in a room
│           └── Mattress.java // artifact that can be used for controlling and monitoring the mattress in a room
├── task1_1.jcm // the configuration file of the JaCaMo application for Task 1.1
├── task1_2.jcm // the configuration file of the JaCaMo application for Task 1.2
└── task2.jcm // the configuration file of the JaCaMo application for Task 2
```

## Task 1 
### Task 1.1 
Complete the implementation of the illuminance controller agent in [`illuminance_controller.asl`](src/agt/task1/illuminance_controller.asl).

### Task 1.2
Complete the implementation of the simple agent in [`simple_agent.asl`](src/agt/task1/simple_agent.asl).

# Task 2
Complete the implementation of the personal assistant agent in [`personal_assistant.asl`](src/agt/task2/personal_assistant.asl).

## Documentation 
- [Bordini, R. H., Hübner, J. F., & Wooldridge, M. (2007). Programming multi-agent systems in AgentSpeak using Jason. John Wiley & Sons.](https://www.wiley.com/en-gb/Programming+Multi+Agent+Systems+in+AgentSpeak+using+Jason-p-9780470029008)
- [Boissier, O., Bordini, R. H., Hubner, J., & Ricci, A. (2020). Multi-agent oriented programming: programming multi-agent systems using JaCaMo. Mit Press](https://mitpress.mit.edu/9780262044578/)
- [Default internal actions of Jason](https://www.emse.fr/~boissier/enseignement/maop12/doc/jason-api/jason/stdlib/package-summary.html)

## How to run the project
You can run the project directly in Visual Studio Code or from the command line with Gradle 7.4. The available Gradle tasks are:
- For Task 1.1 : `task1_1`
- For Task 1.2: `task1_2`
- For Task 2: `task2`

- In VSCode:  Click on the Gradle Side Bar elephant icon, and navigate to one of the Gradle tasks, e.g.: `GRADLE PROJECTS` > `exercise-5` > `Tasks` > `jacamo` > `task1_1`.
- MacOS and Linux: Use the command `./gradlew` to run one of the Gradle tasks, e.g.:
```shell
./gradlew task1_1
```
- Windows: Use the command `gradlew.bat` to run one of the Gradle tasks, e.g.:
```shell
gradle.bat task1_1
```

