package com.example.selcuk.instakotlinapp.Login


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.selcuk.instakotlinapp.R
import com.example.selcuk.instakotlinapp.utils.EventBusDataEvents
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_telefon_kodu_gir.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import java.util.concurrent.TimeUnit
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import kotlinx.android.synthetic.main.fragment_telefon_kodu_gir.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TelefonKoduGirFragment : Fragment() {

    var gelenTelNo = ""
    lateinit var mCallbacks:PhoneAuthProvider.OnVerificationStateChangedCallbacks
    var verificationID = ""
    var gelenKod= ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_telefon_kodu_gir, container, false)

        view.tvKullaniciTelNo.setText(gelenTelNo)

        setupCallBack()

        view.btnTelKod.setOnClickListener {

            if (gelenKod.equals(view.onayKodu.text.toString())) {
                Toast.makeText(activity, "İlerleyebilirsin", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "Kod hatalı", Toast.LENGTH_LONG).show()
            }

        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            gelenTelNo,        // Phone number to verify
            60,                 // Timeout duration
            TimeUnit.SECONDS,   // Unit of timeout
            this!!.activity!!,               // Activity (for callback binding)
            mCallbacks);        // OnVerificationStateChangedCallbacks

        return view

    }

    private fun setupCallBack() {

        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                gelenKod = credential.smsCode!!

            }

            override fun onVerificationFailed(e: FirebaseException) {

            }

            override fun onCodeSent(
                verificationId: String?,
                token: PhoneAuthProvider.ForceResendingToken?) {

                verificationID = verificationId!!

            }
        }


    }

    @Subscribe (sticky = true)
    internal fun onTelefonNoEvent(telefonNumarasi : EventBusDataEvents.TelefonNoGönder) {

        gelenTelNo=telefonNumarasi.telNo
        Log.e("selçuk", "Gelen Tel No : "+gelenTelNo)

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
