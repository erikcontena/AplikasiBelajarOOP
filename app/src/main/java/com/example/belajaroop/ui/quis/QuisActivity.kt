package com.example.belajaroop.ui.quis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.belajaroop.R
import com.example.belajaroop.data.DataDummy
import com.example.belajaroop.database.Quis
import com.example.belajaroop.database.User
import com.example.belajaroop.database.UserPrefernce
import kotlinx.android.synthetic.main.activity_quis.*

class QuisActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_RESULT = "extra_result"
        const val RESULT_CODE = 101
    }
    private lateinit var userModel: User
    private lateinit var quis: ArrayList<Quis>
    var pos = 0
    var nilai = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quis)

        quis = DataDummy.generateQuis() as ArrayList<Quis>
        setSoal()
        userModel = intent.getParcelableExtra("USER") as User
        btn_next.setOnClickListener {

            pos += 1
            if (pos<10){
                setSoal()
                userAnswer()
            }else if (pos == 10){
                btn_next.text = "selesai"
                tv_nilai.visibility = View.VISIBLE
                tv_soal.visibility = View.GONE
                tv_title.visibility = View.GONE
                jwba.visibility = View.GONE
                jwbb.visibility = View.GONE
                jwbc.visibility = View.GONE
                jwbd.visibility = View.GONE
                tv_nilai.text = "Poin : $nilai"
            }else if (pos == 11){
                saveUser(userModel.nama,nilai.toString())
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_RESULT, userModel)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }

    }

    private fun userAnswer(){
        val x = pos - 1
        when {
            jwba.isChecked -> {
                nilai = cek(quis.get(x).a, quis.get(x).benar)
            }
            jwbb.isChecked -> {
                nilai = cek(quis.get(x).b, quis.get(x).benar)
            }
            jwbc.isChecked -> {
                nilai = cek(quis.get(x).c, quis.get(x).benar)
            }
            jwbd.isChecked -> {
                nilai = cek(quis.get(x).d, quis.get(x).benar)
            }
        }
    }
    private fun cek(jwb: String, bnr:String): Int{
        return if (jwb == bnr){
            nilai+10
        }else{
            nilai+0
        }
    }
    private fun setSoal() {
        if (pos < 10){
            tv_title.text = quis.get(pos).title
            tv_soal.text = quis.get(pos).soal
            jwba.text = quis.get(pos).a
            jwbb.text = quis.get(pos).b
            jwbc.text = quis.get(pos).c
            jwbd.text = quis.get(pos).d
            tv_benar.text = quis.get(pos).benar
        }
    }
    private fun saveUser(name: String?,poin: String?) {
        val userPreference = UserPrefernce(this)
        userModel.nama = name
        userModel.poin = poin

        userPreference.setUser(userModel)
    }
}
