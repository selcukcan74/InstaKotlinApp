package com.example.selcuk.instakotlinapp.Login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.selcuk.instakotlinapp.R
import com.example.selcuk.instakotlinapp.utils.EventBusDataEvents
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_register.*
import org.greenrobot.eventbus.EventBus

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
    }

    private fun init() {
        epostaText.setOnClickListener {
            vtelefon.visibility=View.INVISIBLE
            vposta.visibility=View.VISIBLE
            edit_text_giris_yontemi.setText("")
            edit_text_giris_yontemi.inputType=InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            edit_text_giris_yontemi.setHint("E-Posta")

            ileri_button.isEnabled=false
            ileri_button.setTextColor(ContextCompat.getColor(this@RegisterActivity, R.color.solukmavi))
            ileri_button.setBackgroundResource(R.drawable.register_bottom)
        }

        telefonText.setOnClickListener {
            vtelefon.visibility=View.VISIBLE
            vposta.visibility=View.INVISIBLE
            edit_text_giris_yontemi.setText("")
            edit_text_giris_yontemi.inputType=InputType.TYPE_CLASS_NUMBER
            edit_text_giris_yontemi.setHint("Telefon")

            ileri_button.isEnabled=false
            ileri_button.setTextColor(ContextCompat.getColor(this@RegisterActivity, R.color.solukmavi))
            ileri_button.setBackgroundResource(R.drawable.register_bottom)
        }

        edit_text_giris_yontemi.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {



            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {



            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (start+before+count >= 10) {
                    ileri_button.isEnabled=true
                    ileri_button.setTextColor(ContextCompat.getColor(this@RegisterActivity, R.color.beyaz))
                    ileri_button.setBackgroundResource(R.drawable.register_bottom_aktif)
                }
                else {
                    ileri_button.isEnabled=false
                    ileri_button.setTextColor(ContextCompat.getColor(this@RegisterActivity, R.color.solukmavi))
                    ileri_button.setBackgroundResource(R.drawable.register_bottom)
                }

            }

        })

        ileri_button.setOnClickListener {


            if (edit_text_giris_yontemi.hint.toString().equals("Telefon")) {
                Toast.makeText(this, "Doğrulama Kodunu Girin!", Toast.LENGTH_LONG).show()

                loginRoot.visibility=View.GONE
                loginContainer.visibility=View.VISIBLE
                var transaction=supportFragmentManager.beginTransaction()
                transaction.replace(R.id.loginContainer, TelefonKoduGirFragment())
                transaction.addToBackStack("telefonkodugirfragmenteklendi")
                transaction.commit()

                EventBus.getDefault().postSticky(EventBusDataEvents.TelefonNoGönder(edit_text_giris_yontemi.text.toString()))

            }else {
                Toast.makeText(this, "E-Posta", Toast.LENGTH_LONG).show()

                loginRoot.visibility=View.GONE
                loginContainer.visibility=View.VISIBLE
                var transaction=supportFragmentManager.beginTransaction()
                transaction.replace(R.id.loginContainer, EmailGirisYontemiFragment())
                transaction.addToBackStack("emaililegirişfragmenteklendi")
                transaction.commit()

                EventBus.getDefault().postSticky(EventBusDataEvents.EmailGönder(edit_text_giris_yontemi.text.toString()))
            }

        }

    }

    override fun onBackPressed() {

        loginRoot.visibility= View.VISIBLE
        super.onBackPressed()

    }
}
