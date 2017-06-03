package com.posmobile.caixaappandroid.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by Tamirys on 03/06/2017.
 */
class ViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager)
{
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment
    {
        return mFragmentList[position]
    }

    override fun getCount(): Int
    {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    fun getFragments() : List<Fragment>
    {
        return mFragmentList
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitleList[position]
    }
}