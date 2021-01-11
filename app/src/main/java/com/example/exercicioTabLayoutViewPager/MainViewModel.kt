package com.example.exercicioTabLayoutViewPager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exercicioTabLayoutViewPager.model.Socio

class MainViewModel : ViewModel(){

    val socioAtualizado: MutableLiveData<Socio> = MutableLiveData()

    fun setNovoSocio (socio: Socio) {
        socioAtualizado.postValue(socio)
    }
}