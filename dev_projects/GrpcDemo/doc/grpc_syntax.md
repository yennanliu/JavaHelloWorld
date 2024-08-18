
# gRPC Protobuf Syntax Guide (gpt)

gRPC uses Protocol Buffers (protobuf) as the Interface Definition Language (IDL) to define service methods and message types. Below is an overview of the syntax used in protobuf files for gRPC:

## Basic Structure of a `.proto` File

```proto
syntax = "proto3";

// Package name to prevent name clashes
package your.package.name;

// Option to specify the outer class name in Java (if used)
option java_outer_classname = "YourClassName";

// Option to specify the Java package (if used)
option java_package = "com.yourcompany.grpc";

// Define the gRPC service
service YourService {
  // Unary RPC: client sends a single request, receives a single response
  rpc YourUnaryMethod (YourRequest) returns (YourResponse);

  // Server streaming RPC: client sends a single request, receives a stream of responses
  rpc YourServerStreamingMethod (YourRequest) returns (stream YourResponse);

  // Client streaming RPC: client sends a stream of requests, receives a single response
  rpc YourClientStreamingMethod (stream YourRequest) returns (YourResponse);

  // Bidirectional streaming RPC: both sides send a stream of requests/responses
  rpc YourBidirectionalStreamingMethod (stream YourRequest) returns (stream YourResponse);
}

// Define the message types
message YourRequest {
  // Field types, field names, and field numbers
  string name = 1;
  int32 id = 2;
}

message YourResponse {
  string message = 1;
  int32 result = 2;
}
```

## Key Components

1. **Syntax Declaration**:
   - `syntax = "proto3";` specifies that you are using Protocol Buffers version 3.

2. **Package Declaration**:
   - `package your.package.name;` defines the package to prevent name clashes.

3. **Options**:
   - `option java_package = "com.yourcompany.grpc";` defines the Java package if the protobuf is being used in Java.
   - `option java_outer_classname = "YourClassName";` defines the outer class name in Java.

4. **Service Definition**:
   - `service YourService { ... }` defines the gRPC service.
   - The service contains one or more RPC methods that describe the request and response types.

5. **RPC Methods**:
   - **Unary RPC**: `rpc YourUnaryMethod (YourRequest) returns (YourResponse);`
   - **Server Streaming RPC**: `rpc YourServerStreamingMethod (YourRequest) returns (stream YourResponse);`
   - **Client Streaming RPC**: `rpc YourClientStreamingMethod (stream YourRequest) returns (YourResponse);`
   - **Bidirectional Streaming RPC**: `rpc YourBidirectionalStreamingMethod (stream YourRequest) returns (stream YourResponse);`

6. **Message Definitions**:
   - `message YourRequest { ... }` defines the structure of the request message.
   - `message YourResponse { ... }` defines the structure of the response message.
   - Fields within messages are defined with types (`string`, `int32`, etc.), names, and unique field numbers.

## Common Data Types in Protobuf

- **Scalar Types**: `double`, `float`, `int32`, `int64`, `uint32`, `uint64`, `sint32`, `sint64`, `fixed32`, `fixed64`, `sfixed32`, `sfixed64`, `bool`, `string`, `bytes`
- **Composite Types**:
  - **Messages**: Custom message types (`YourRequest`, `YourResponse`).
  - **Enumerations**: `enum Status { OK = 0; ERROR = 1; }`

## Example Protobuf Definition

```proto
syntax = "proto3";

package com.yourcompany.grpc;

option java_package = "com.yourcompany.grpc";
option java_outer_classname = "CarRentalServiceProto";

service CarRentalService {
  rpc RentCar (RentCarRequest) returns (RentCarResponse);
  rpc ReturnCar (ReturnCarRequest) returns (ReturnCarResponse);
  rpc ListAvailableCars (Empty) returns (CarListResponse);
}

message RentCarRequest {
  string car_id = 1;
  string renter_name = 2;
}

message RentCarResponse {
  string message = 1;
}

message ReturnCarRequest {
  string car_id = 1;
}

message ReturnCarResponse {
  string message = 1;
}

message Car {
  string id = 1;
  string make = 2;
  string model = 3;
  int32 year = 4;
  bool is_rented = 5;
}

message CarListResponse {
  repeated Car cars = 1;
}

message Empty {}
```

This example defines a simple car rental service with methods for renting a car, returning a car, and listing available cars.
