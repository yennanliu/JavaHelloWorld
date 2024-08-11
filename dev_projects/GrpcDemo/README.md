# GrpcDemo
> POC service for [grpc](https://grpc.io/)

## Dependency
- JDK 17

## Build
```bash

# V1 : install directly
mvn clean install


# V2: manually generate proto built files
mvn protobuf:compile
mvn protobuf:compile-custom
```

## Concept

- Protobuf
  - which is short for “Protocol Buffers,”
  - is an efficient, language-agnostic data serialization mechanism.
  - It enables developers to define structured data in a . proto file, which is then used to generate source code that can write and read data from different data streams.
  - https://blog.postman.com/what-is-protobuf/#:~:text=Protobuf%2C%20which%20is%20short%20for,data%20from%20different%20data%20streams.

- IDL : Interface definition language
- Protoc : protobuf compiler

## Project structure

- NOTE !!! `.proto` file needs to under `src/main/proto` path

```


├── README.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   ├── proto
│   │   │   └── greeting.proto
│   │   └── resources
│   └── test
│       └── java
└── target
    ├── GrpcDemo-1.0-SNAPSHOT.jar
    ├── classes
    │   ├── com
    │   │   └── yen
    │   └── greeting.proto
    ├── generated-sources
    │   ├── annotations
    │   └── protobuf
    │       ├── grpc-java
    │       └── java
    ├── generated-test-sources
    │   └── test-annotations
    ├── maven-archiver
    │   └── pom.properties
    ├── maven-status
    │   └── maven-compiler-plugin
    │       ├── compile
    │       └── testCompile
    ├── protoc-dependencies
    │   ├── a0a658ba104866371fe6f5b91e702603
    │   │   └── google
    │   └── e3ec81f9f7ea2b739bb831e736cbf372
    │       └── google
    ├── protoc-plugins
    │   ├── protoc-3.21.4-osx-aarch_64.exe
    │   └── protoc-gen-grpc-java-1.56.0-osx-aarch_64.exe
    └── test-classes
```