package com.example.meditationapp.ViewModel

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.w3c.dom.Text

class PhotoViewModel: ViewModel() {
    val uri = MutableLiveData<Uri>()
}