package com.example.exercicioTabLayoutViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initComponents()

    }

    private fun initComponents() {
        //fragment que será chamado por padrão
        callFragment(NaoSocioFragment())

        tabLayout = findViewById(R.id.tabLayout)

        tabLayout.addOnTabSelectedListener(this)

    }

    //chamar o fragment
    private fun callFragment(fragment: Fragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.commit()
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when(tab?.position){
            0 -> {
                //chamar fragment não sócio
                callFragment(NaoSocioFragment())
            }
            1 -> {
                //chamar fragment sócio
                callFragment(SocioFragment())
            }
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }
}