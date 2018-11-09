package com.example.selcuk.instakotlinapp.Home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.selcuk.instakotlinapp.R
import com.example.selcuk.instakotlinapp.utils.BottomnavigationViewHelper
import com.example.selcuk.instakotlinapp.utils.HomePagerAdapter
import com.example.selcuk.instakotlinapp.utils.UniversalImageLoader
import com.nostra13.universalimageloader.core.ImageLoader
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val ACTIVITY_NO=0
    private val TAG="HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupNavigationView()
        setupHomeViewPager()
        initImageLoader()

    }

    fun setupNavigationView() {

         BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView, bottomNavigationView)
         BottomnavigationViewHelper.setupNavigation(this, bottomNavigationView)
         var menu= bottomNavigationView.menu
         var menuItem=menu.getItem(ACTIVITY_NO)
         menuItem.setChecked(true)

    }

    private fun setupHomeViewPager() {
        var homePagerAdapter=HomePagerAdapter(supportFragmentManager)
        homePagerAdapter.addFragment(CameraFragment()) //id:0
        homePagerAdapter.addFragment(HomeFragment()) //id:1
        homePagerAdapter.addFragment(MessagesFragment()) //id:2

        //activity mainde bulunan viewpagera adaptör atandı
        homeViewPager.adapter=homePagerAdapter

        //viewpagerın homefragment ile bağlantısı sağlandı
        homeViewPager.setCurrentItem(1)

    }

    private fun initImageLoader() {

        var UniversalImageLoader= UniversalImageLoader(this)
        ImageLoader.getInstance().init(UniversalImageLoader.config)

    }

}
