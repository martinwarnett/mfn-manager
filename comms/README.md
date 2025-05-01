# COMMUNICATIONS

## Overview

This module implements functionality enabling the overall project to communicate with a source via the web; in this 
instance, the [MyFootballNow](https://www.myfootballnow.com) website.

## Table of Contents

- [Description](#description)
- [Flow](#flow)
- [Exceptions](#exceptions)


### Description

To perform retrieval of data from a webpage using the functionality provided in this module, the developer
needs to extend the CommsOperation genericised abstract class and implement the methods documented below.

*CommsOperation<T>*

| method          |parameters|description|
|-----------------|----------|------------|
| generateRequest |none|Creates the web page call|
|  convert        |none|Converts the returned content text from the web page into the required generic type|

A WebpageResponseHandler needs to be instantiated and passed into the concrete CommsOperation entity.  This class takes 
the webpage response and converts it into a String to be processed. 

### Flow

Client code invokes performOperation, passing in a CloseableHttpConnection
Within performOperation, generateRequest creates the call to the required webpage.
PerformOperation then executes the generated request upon the provided connection.
Connection processing invokes the WebpageResponseHandler to convert the web page response into a text String.
The overridden convert method is then invoked to convert the String content into the required object.
PerformOperation returns the converted object.

### Exceptions

Any exceptions thrown are wrapped and returned as a project CommunicationsException.

