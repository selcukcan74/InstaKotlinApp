package com.example.selcuk.instakotlinapp.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.text.FieldPosition

class HomePagerAdapter(fm:FragmentManager): FragmentPagerAdapter(fm) {

    private var mFragmentList:ArrayList<Fragment> = ArrayList()


    //FragmentPager Adp. Zorunlu Kılınan Fonksiyon
    override fun getItem(position: Int): Fragment {

        return mFragmentList.get(position)

    }

    override fun getCount(): Int {

        return mFragmentList.size

    }

    //Kişisel Fonksiyon
    fun addFragment(fragment: Fragment) {
        mFragmentList.add(fragment)
    }

}