package com.example.work8.di

import com.example.work8.MainActivity
import dagger.Component

@Component
interface Component {
    fun inject(activity:MainActivity)
}