package com.example.pertemuan2.model.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan2.model.response.NoteItem
import com.example.pertemuan2.service.api.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotesViewModel: ViewModel() {

    private val _notes = MutableStateFlow<List<NoteItem>>(emptyList())

    val notes : StateFlow<List<NoteItem>> = _notes

    private fun getNotes() {
        viewModelScope.launch {
            try {
                val response = ApiClient.instance.getAllNotes()
                _notes.value = response.data.notes
            } catch(e: Exception) {
                Log.e("GetNotesError", "Gagal Mengambil Data Catatan")
            }
        }
    }

    init {
        getNotes()
    }
}