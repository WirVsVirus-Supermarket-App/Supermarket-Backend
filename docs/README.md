# Go API client for swagger

Api Documentation

## Overview
This API client was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  By using the [swagger-spec](https://github.com/swagger-api/swagger-spec) from a remote server, you can easily generate an API client.

- API version: 1.0
- Package version: 1.0.0
- Build package: io.swagger.codegen.languages.GoClientCodegen

## Installation
Put the package under your project folder and add the following in import:
```golang
import "./swagger"
```

## Documentation for API Endpoints

All URIs are relative to *https://localhost:1337*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*SupermarketControllerApi* | [**LoginUsingPOST**](docs/SupermarketControllerApi.md#loginusingpost) | **Post** /supermarket/login | login
*SupermarketControllerApi* | [**NearestUsingGET**](docs/SupermarketControllerApi.md#nearestusingget) | **Get** /supermarket/nearest | nearest
*SupermarketControllerApi* | [**RegisterUsingPOST**](docs/SupermarketControllerApi.md#registerusingpost) | **Post** /supermarket/register | register
*TimeSlotControllerApi* | [**AddUsingPOST**](docs/TimeSlotControllerApi.md#addusingpost) | **Post** /timeslot | add
*TimeSlotControllerApi* | [**AllUsingGET**](docs/TimeSlotControllerApi.md#allusingget) | **Get** /timeslot | all
*TimeSlotControllerApi* | [**DeleteUsingDELETE**](docs/TimeSlotControllerApi.md#deleteusingdelete) | **Delete** /timeslot | delete
*TimeSlotControllerApi* | [**RequestUsingPOST**](docs/TimeSlotControllerApi.md#requestusingpost) | **Post** /timeslot/request | request
*UserControllerApi* | [**LoginUsingPOST1**](docs/UserControllerApi.md#loginusingpost1) | **Post** /user/login | login
*UserControllerApi* | [**RegisterUsingPOST1**](docs/UserControllerApi.md#registerusingpost1) | **Post** /user/register | register


## Documentation For Models

 - [LocalTime](docs/LocalTime.md)
 - [ReducedSupermarket](docs/ReducedSupermarket.md)
 - [ReducedTimeslot](docs/ReducedTimeslot.md)


## Documentation For Authorization
 Endpoints do not require authorization.


## Author



