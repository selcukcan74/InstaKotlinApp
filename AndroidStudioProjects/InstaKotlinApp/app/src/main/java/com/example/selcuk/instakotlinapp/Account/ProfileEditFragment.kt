package com.example.selcuk.instakotlinapp.Account


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.selcuk.instakotlinapp.R
import com.example.selcuk.instakotlinapp.utils.UniversalImageLoader
import com.nostra13.universalimageloader.core.ImageLoader
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_profile_edit.*
import kotlinx.android.synthetic.main.fragment_profile_edit.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileEditFragment : Fragment() {

    lateinit var circleProfileImageFragment:CircleImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        val view=inflater!!.inflate(R.layout.fragment_profile_edit, container, false)

        circleProfileImageFragment=view.findViewById(R.id.profile_image)

        setupProfilePicture()

        view.imgClose.setOnClickListener {

            activity!!.onBackPressed()

        }

        return view
    }



    private fun setupProfilePicture() {

        //https://i.ytimg.com/vi/OWiWWnJDysk/maxresdefault.jpg
        var imgURL="cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/android-512.png"
        UniversalImageLoader.setImage(imgURL, circleProfileImageFragment, null, "https://")

    }


}
