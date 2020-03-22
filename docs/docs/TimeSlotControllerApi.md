# \TimeSlotControllerApi

All URIs are relative to *https://localhost:1337*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AddUsingPOST**](TimeSlotControllerApi.md#AddUsingPOST) | **Post** /timeslot | add
[**AllUsingGET**](TimeSlotControllerApi.md#AllUsingGET) | **Get** /timeslot | all
[**DeleteUsingDELETE**](TimeSlotControllerApi.md#DeleteUsingDELETE) | **Delete** /timeslot | delete
[**RequestUsingPOST**](TimeSlotControllerApi.md#RequestUsingPOST) | **Post** /timeslot/request | request


# **AddUsingPOST**
> interface{} AddUsingPOST(ctx, optional)
add

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***AddUsingPOSTOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a AddUsingPOSTOpts struct

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hour** | **optional.Int32**|  | 
 **hour2** | **optional.Int32**|  | 
 **market** | **optional.Int64**| market | 
 **minute** | **optional.Int32**|  | 
 **minute2** | **optional.Int32**|  | 
 **nano** | **optional.Int32**|  | 
 **nano2** | **optional.Int32**|  | 
 **second** | **optional.Int32**|  | 
 **second2** | **optional.Int32**|  | 

### Return type

[**interface{}**](interface{}.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **AllUsingGET**
> []ReducedTimeslot AllUsingGET(ctx, optional)
all

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***AllUsingGETOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a AllUsingGETOpts struct

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **market** | **optional.Int64**| market | 

### Return type

[**[]ReducedTimeslot**](ReducedTimeslot.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DeleteUsingDELETE**
> interface{} DeleteUsingDELETE(ctx, optional)
delete

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***DeleteUsingDELETEOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a DeleteUsingDELETEOpts struct

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **optional.Int64**| id | 

### Return type

[**interface{}**](interface{}.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **RequestUsingPOST**
> interface{} RequestUsingPOST(ctx, optional)
request

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***RequestUsingPOSTOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a RequestUsingPOSTOpts struct

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slot** | **optional.Int64**| slot | 

### Return type

[**interface{}**](interface{}.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

