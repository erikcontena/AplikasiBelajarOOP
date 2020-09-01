package com.example.belajaroop.ui.setting

import kotlinx.android.synthetic.main.activity_setting.*
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.belajaroop.R
import com.example.belajaroop.database.User
import com.example.belajaroop.database.UserPrefernce
import android.content.Intent

class SettingActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TYPE_FORM = "extra_type_form"
        const val EXTRA_RESULT = "extra_result"
        const val RESULT_CODE = 101
        const val TYPE_ADD = 1
        const val TYPE_EDIT = 2

        private const val FIELD_REQUIRED = "Field tidak boleh kosong"
    }

    private lateinit var userModel: User



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        userModel = intent.getParcelableExtra("USER") as User
        val formType = intent.getIntExtra(EXTRA_TYPE_FORM, 0)
        when (formType) {
            TYPE_ADD -> {

            }
            TYPE_EDIT -> {
                showPrefencesForm()

            }
        }

        back.setOnClickListener {
            finish()
        }

        btn_submit.setOnClickListener {
            val nama = edt_nama.text.toString().trim()

            if (nama.isEmpty()) {
                edt_nama.error = FIELD_REQUIRED
            } else{
                saveUser(nama,userModel.poin)
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_RESULT, userModel)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }

    private fun showPrefencesForm() {
        edt_nama.setText(userModel.nama)
    }
    private fun saveUser(name: String,poin: String?) {
        val userPreference = UserPrefernce(this)
        userModel.nama = name
        userModel.poin = poin

        userPreference.setUser(userModel)
        Toast.makeText(this, "Data tersimpan $poin", Toast.LENGTH_SHORT).show()
    }




}

