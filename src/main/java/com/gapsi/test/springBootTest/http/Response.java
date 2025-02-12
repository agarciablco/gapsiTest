package com.gapsi.test.springBootTest.http;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@ToString
public class Response<T> {

    private int statusCode;
    private String message;
    private boolean success = false;
    /**
     * Can be a hashmap or list Spring will render a nice Json response :-)
     *
     */
    private T data;

    public Response(int statCode, String statusDesc) {
        statusCode = statCode;
        message = statusDesc;

        if (statusCode == HttpStatus.OK.value()) {
            success = true;
        }
        
    }

    public Response(int statCode, String statusDesc, boolean result, T responseData) {
        statusCode = statCode;
        message = statusDesc;
        success = result;
        data = responseData;
        
    }

    public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Response() {
    }

    public static <T> Response<T> failedResponse(String message) {
        return failedResponse(HttpStatus.BAD_REQUEST.value(), message, null);
    }

    public static <T> Response<T> failedResponse(T data) {
        return failedResponse(HttpStatus.BAD_REQUEST.value(), "Bad request", data);
    }

    public static <T> Response<T> failedResponse(int statusCode, String message) {
        return failedResponse(statusCode, message, null);
    }

    public static <T> Response<T> failedResponse(int statusCode, String message, T data) {
        Response<T> response = new Response<>(statusCode, message);
        response.setSuccess(false);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> successfulResponse(String message, T data) {
        return successfulResponse(HttpStatus.OK.value(), message, data);
    }

    public static <T> Response<T> successfulResponse(String message) {
        return successfulResponse(HttpStatus.OK.value(), message, null);
    }

    public static <T> Response<T> successfulResponse(int statusCode, String message, T data) {
        Response<T> response = new Response<>(statusCode, message);
	    response.setSuccess(true);
	    response.setData(data);
	    return response;
    }
}