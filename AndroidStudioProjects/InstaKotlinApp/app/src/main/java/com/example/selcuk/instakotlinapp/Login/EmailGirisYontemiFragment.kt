package com.example.selcuk.instakotlinapp.Login


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.selcuk.instakotlinapp.R
import com.example.selcuk.instakotlinapp.utils.EventBusDataEvents
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class EmailGirisYontemiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_email_giris_yontemi, container, false)
    }

    @Subscribe(sticky = true)
    internal fun onTelefonNoEvent(emailAdres : EventBusDataEvents.EmailGönder) {
        var gelenEmail=emailAdres.email
        Log.e("selçuk", "Gelen Tel No : "+gelenEmail)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        EventBus.getDefault().register(this)
    }

    override fun onDetach() {
        super.onDetach()
        EventBus.getDefault().register(this)
    }



}
