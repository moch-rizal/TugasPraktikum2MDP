package com.example.pertemuan2.service.api

import com.example.pertemuan2.model.request.LoginRequest
import com.example.pertemuan2.model.request.RegisterRequest
import com.example.pertemuan2.model.response.LoginResponse
import com.example.pertemuan2.model.response.NotesResponse
import com.example.pertemuan2.model.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService{
    @POST("api/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    @POST("/api/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("/api/notes")
    suspend fun getAllNotes(): NotesResponse


}