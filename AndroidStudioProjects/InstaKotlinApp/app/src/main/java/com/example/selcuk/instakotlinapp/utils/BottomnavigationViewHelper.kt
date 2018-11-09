package com.example.selcuk.instakotlinapp.utils

import android.content.Context
import android.content.Intent
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.example.selcuk.instakotlinapp.Account.AccountActivity
import com.example.selcuk.instakotlinapp.Home.HomeActivity
import com.example.selcuk.instakotlinapp.Notification.NotificationActivity
import com.example.selcuk.instakotlinapp.R
import com.example.selcuk.instakotlinapp.Search.SearchActivity
import com.example.selcuk.instakotlinapp.Share.ShareActivity
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx

class BottomnavigationViewHelper {

    companion object {

        @Suppress("UNUSED_PARAMETER")
        fun setupBottomNavigationView(
            bottomnavigationViewEx: BottomNavigationViewEx,
            bottomNavigationView: BottomNavigationViewEx
        ) {

            bottomnavigationViewEx.enableAnimation(false)
            bottomnavigationViewEx.enableItemShiftingMode(false)
            bottomnavigationViewEx.enableShiftingMode(false)
            bottomnavigationViewEx.setTextVisibility(false)

        }

        fun setupNavigation(context: Context, bottomnavigationViewEx: BottomNavigationViewEx) {

            bottomnavigationViewEx.onNavigationItemSelectedListener=object: BottomNavigationView.OnNavigationItemSelectedListener{

                override fun onNavigationItemSelected(item: MenuItem): Boolean {

                    when(item.itemId) {

                        R.id.home -> {

                            val intent=Intent(context, HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true

                        }

                        R.id.search -> {

                            val intent=Intent(context, SearchActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true

                        }

                        R.id.share -> {

                            val intent=Intent(context, ShareActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true

                        }

                        R.id.notification -> {

                            val intent=Intent(context, NotificationActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true

                        }

                        R.id.account -> {

                            val intent=Intent(context, AccountActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true

                        }


                    }

                    return false

                }


            }

        }

        fun setupBottomNavigationView(bottomnavigationViewEx: BottomNavigationViewEx?) {

        }

    }

}