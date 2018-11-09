package com.example.selcuk.instakotlinapp.Account

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.selcuk.instakotlinapp.R
import com.example.selcuk.instakotlinapp.utils.BottomnavigationViewHelper
import com.example.selcuk.instakotlinapp.utils.UniversalImageLoader
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {

    private val ACTIVITY_NO=4
    private val TAG="AccountActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        setupNavigationView()
        setupToolbar()
        setupProfilePhoto()

    }

    private fun setupProfilePhoto() {

        val imgURL="images8.alphacoders.com/712/712496.jpg"

        UniversalImageLoader.setImage(imgURL, profile_image, progressBar, "https://")
    }

    private fun setupToolbar() {
        imgProfileSetting.setOnClickListener {

            var intent=Intent(this,ProfileSettingActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)

        }

        profileDuzenleButtonu.setOnClickListener {

            profile_root.visibility= View.GONE
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profile_container, ProfileEditFragment())
            transaction.addToBackStack("editProfileFragmentEklendi")
            transaction.commit()

        }

    }

    fun setupNavigationView() {

        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView, bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this, bottomNavigationView)
        var menu= bottomNavigationView.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)

    }

    override fun onBackPressed() {

        profile_root.visibility= View.VISIBLE
        super.onBackPressed()

    }

}
