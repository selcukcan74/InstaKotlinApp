package com.example.selcuk.instakotlinapp.Notification

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.selcuk.instakotlinapp.R
import com.example.selcuk.instakotlinapp.utils.BottomnavigationViewHelper
import kotlinx.android.synthetic.main.activity_home.*

class NotificationActivity : AppCompatActivity() {

    private val ACTIVITY_NO=3
    private val TAG="NotificationActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupNavigationView()

    }

    fun setupNavigationView() {

        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView, bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this, bottomNavigationView)
        var menu= bottomNavigationView.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)

    }
}
