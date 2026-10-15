# Object-Oriented Analysis and Design Laboratory

This repository contains source code, lab exercises, design-pattern implementations, case studies, and supporting notes for the laboratory work completed during the sixth semester as part of the **Object-Oriented Analysis and Design (OOAD)** course. The implementations are primarily in **Java**.

## Repository Overview

The repository collects the hands-on lab exercises, worked examples of design principles and patterns, and the accompanying case-study material for the course.

### Contents

- **Lab1 – Lab10** — Weekly laboratory exercises covering object-oriented programming fundamentals and the practical application of design principles and patterns.
- **SOLID/** — Exercises applying the five SOLID design principles.
- **CaseStudies/** — Object-oriented analysis and design case studies.
- **ClassCodes/** — In-class worked examples.
- **Design-pattern work** — Standalone implementations and demos of common Gang-of-Four patterns, including:
  - *Creational*: Factory, Abstract Factory, Builder, Prototype, Singleton
  - *Structural*: Proxy (`Proxy/`), Flyweight (`FlyWeight/`)
  - *Behavioral*: Chain of Responsibility
- Assorted top-level Java examples covering inheritance, interfaces, overloading, collections, and other OOP concepts practised through the course.

> **Note:** The group design-patterns project is maintained separately as its own repository and is not included here. Compiled Java artifacts (`*.class`) are build outputs and are excluded via `.gitignore`.

## About the Course

The Object-Oriented Analysis and Design laboratory focuses on modelling software systems with object-oriented principles — abstraction, encapsulation, inheritance, and polymorphism — and on recognising and applying the SOLID principles and classic design patterns to produce maintainable, extensible designs.

## Building and Running

The exercises are plain Java and can be compiled and run with a standard JDK:

```bash
# Compile a single source file
javac Example.java

# Run it
java Example
```

```bash
# For a folder of sources
javac *.java
java MainClass
```

## License

This repository is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
