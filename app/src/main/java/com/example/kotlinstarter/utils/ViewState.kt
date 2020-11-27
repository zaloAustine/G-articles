package com.example.kotlinstarter.utils

sealed class ViewState()
class Loading : ViewState()
class Done : ViewState()
class Error : ViewState()




