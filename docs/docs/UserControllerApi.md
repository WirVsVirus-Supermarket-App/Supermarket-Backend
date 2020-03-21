# \UserControllerApi

All URIs are relative to *https://localhost:1337*

Method | HTTP request | Description
------------- | ------------- | -------------
[**LoginUsingPOST1**](UserControllerApi.md#LoginUsingPOST1) | **Post** /user/login | login
[**RegisterUsingPOST1**](UserControllerApi.md#RegisterUsingPOST1) | **Post** /user/register | register


# **LoginUsingPOST1**
> map[string]interface{} LoginUsingPOST1(ctx, optional)
login

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***LoginUsingPOST1Opts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a LoginUsingPOST1Opts struct

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

# **RegisterUsingPOST1**
> map[string]interface{} RegisterUsingPOST1(ctx, optional)
register

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***RegisterUsingPOST1Opts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a RegisterUsingPOST1Opts struct

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

