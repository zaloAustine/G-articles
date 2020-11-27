package com.example.kotlinstarter.utils

import android.text.TextWatcher
import android.widget.Toast
import com.example.kotlinstarter.ui.MainActivity
import dagger.hilt.android.qualifiers.ApplicationContext

/*object ContextExtensions {

}*/
fun Any.showToast(context:MainActivity,message:String) {
    Toast.makeText(context,message,Toast.LENGTH_LONG).show()
}