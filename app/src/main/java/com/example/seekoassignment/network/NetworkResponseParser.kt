package com.example.seekoassignment.network


import org.json.JSONObject
import retrofit2.Response

//Do not remove suspend from here.
suspend fun <T : Any> networkCall(response: Response<T>): ApiResult<T> {
    return if (response.isSuccessful) {
        response.body()?.let {
            try {
                ApiResult.Success(response.body())
            } catch (e: Exception) {
                ApiResult.Error(e.localizedMessage ?: "No data")
            }
        }
            ?: ApiResult.Error("Empty response body")
    } else {
        val errorBody = response.errorBody()?.string()
        val messageCode = try {
            if (errorBody != null) {
                if (!JSONObject(errorBody).optString("message").isNullOrEmpty()) {
                    JSONObject(errorBody).optString("message", "Unknown Error")
                } else {
                    JSONObject(errorBody).optString("messageCode", "Unknown Error")
                }
            } else {
                "Unknown Error"
            }
        } catch (e: Exception) {
            "Unknown Error"
        }
        ApiResult.Error(messageCode as String)
    }
}

