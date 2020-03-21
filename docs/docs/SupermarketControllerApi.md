# \SupermarketControllerApi

All URIs are relative to *https://localhost:1337*

Method | HTTP request | Description
------------- | ------------- | -------------
[**LoginUsingPOST**](SupermarketControllerApi.md#LoginUsingPOST) | **Post** /supermarket/login | login
[**NearestUsingGET**](SupermarketControllerApi.md#NearestUsingGET) | **Get** /supermarket/nearest | nearest
[**RegisterUsingPOST**](SupermarketControllerApi.md#RegisterUsingPOST) | **Post** /supermarket/register | register


# **LoginUsingPOST**
> map[string]interface{} LoginUsingPOST(ctx, optional)
login

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***LoginUsingPOSTOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a LoginUsingPOSTOpts struct

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **optional.String**| email | 
 **password** | **optional.String**| password | 

### Return type

[**map[string]interface{}**](interface{}.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **NearestUsingGET**
> []ReducedSupermarket NearestUsingGET(ctx, optional)
nearest

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***NearestUsingGETOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a NearestUsingGETOpts struct

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postalCode** | **optional.Int32**| postalCode | 

### Return type

[**[]ReducedSupermarket**](ReducedSupermarket.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **RegisterUsingPOST**
> map[string]interface{} RegisterUsingPOST(ctx, optional)
register

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***RegisterUsingPOSTOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a RegisterUsingPOSTOpts struct

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **capacity** | **optional.Int32**| capacity | 
 **email** | **optional.String**| email | 
 **houseNumber** | **optional.String**| houseNumber | 
 **name** | **optional.String**| name | 
 **password** | **optional.String**| password | 
 **postalCode** | **optional.Int32**| postalCode | 
 **street** | **optional.String**| street | 

### Return type

[**map[string]interface{}**](interface{}.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

