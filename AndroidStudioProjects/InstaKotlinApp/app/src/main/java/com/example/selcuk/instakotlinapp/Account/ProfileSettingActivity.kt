package com.example.selcuk.instakotlinapp.Account

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.selcuk.instakotlinapp.R
import com.example.selcuk.instakotlinapp.utils.BottomnavigationViewHelper
import kotlinx.android.synthetic.main.activity_profile_setting.*

class ProfileSettingActivity : AppCompatActivity() {

    private val ACTIVITY_NO=4
    private val TAG="AccountActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_setting)

        setupNavigationView()
        setupToolbar()
        fragmentNavigations()
    }

    private fun fragmentNavigations() {

        profiliDüzenleText.setOnClickListener {

            profileSttingsRoot.visibility=View.GONE
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profileSettingContainer,ProfileEditFragment())
            transaction.addToBackStack("editProfileFragmentEklendi")
            transaction.commit()

        }

        cikisYapText.setOnClickListener {

            profileSttingsRoot.visibility=View.GONE
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profileSettingContainer, SignOutFragment())
            transaction.addToBackStack("signOutFragmentEklendi")
            transaction.commit()
        }

    }

    private fun setupToolbar() {
        back.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {

        profileSttingsRoot.visibility=View.VISIBLE
        super.onBackPressed()

    }

    fun setupNavigationView() {

        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this, bottomNavigationView)
        var menu= bottomNavigationView.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)

    }

}
