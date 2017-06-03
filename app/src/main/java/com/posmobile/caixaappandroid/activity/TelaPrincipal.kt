package com.posmobile.caixaappandroid.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.posmobile.caixaappandroid.R
import com.posmobile.caixaappandroid.adapter.ViewPagerAdapter
import com.posmobile.caixaappandroid.fragment.*

class TelaPrincipal : AppCompatActivity()
{
    private var navigation: BottomNavigationView? = null
    private var pager_principal: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_principal)

        init()
    }

    private fun init()
    {
        navigation = findViewById(R.id.navigation) as BottomNavigationView

        pager_principal = findViewById(R.id.pager_principal) as ViewPager
        pager_principal!!.offscreenPageLimit = 4
        setupViewPager()

        navigation!!.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    pager_principal!!.currentItem = 0
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_extrato -> {
                    pager_principal!!.currentItem = 1
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_transacoes -> {
                    pager_principal!!.currentItem = 2
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_servicos -> {
                    pager_principal!!.currentItem = 3
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_ajuda -> {
                    pager_principal!!.currentItem = 4
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

        pager_principal!!.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffSet: Float, positionOffSetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                navigation!!.menu.getItem(position).setChecked(true)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun setupViewPager()
    {
        var pager_adapter = ViewPagerAdapter(supportFragmentManager)

        pager_adapter.addFragment(ResumoFragment(), "Início")
        pager_adapter.addFragment(ExtratoFragment(), "Extrato")
        pager_adapter.addFragment(TransacoesFragment(), "Transações")
        pager_adapter.addFragment(ServicosFragment(), "Serviços")
        pager_adapter.addFragment(AjudaFragment(), "Ajuda")

        pager_principal!!.adapter = pager_adapter
    }
}
