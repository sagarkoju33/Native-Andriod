package com.example.practise.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This  is hahahhahahahhahahahhahahah"
    }
    val text: LiveData<String> = _text
}