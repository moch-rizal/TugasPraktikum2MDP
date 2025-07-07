package com.example.pertemuan2.model.response

data class NotesResponse(
    val code: Int,
    val message: String,
    val data: NotesData
)

data class NotesData(
    val notes: List<NoteItem>
)

data class NoteItem(
    val nm_lengkap: String,
    val id_notes: String,
    val id_user: String,
    val title: String,
    val content: String,
    val created_at: String,
    val updated_at: String
)