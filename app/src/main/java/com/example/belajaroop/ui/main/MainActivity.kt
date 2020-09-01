package com.example.belajaroop.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.blogspot.atifsoftwares.animatoolib.Animatoo

import com.example.belajaroop.R
import com.example.belajaroop.database.User
import com.example.belajaroop.database.UserPrefernce
import com.example.belajaroop.ui.detail.DetailActivity
import com.example.belajaroop.ui.quis.QuisActivity
import com.example.belajaroop.ui.setting.SettingActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mUserPreference: UserPrefernce
    private var isPreferenceEmpty = false
    private lateinit var userModel: User

    companion object {
        private const val REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        setSingleEvent(mainGrid);
        mUserPreference = UserPrefernce(this)
        showExistingPreference()

        setting.setOnClickListener {
            val intent = Intent(this@MainActivity, SettingActivity::class.java)
            when {
                isPreferenceEmpty -> {
                    intent.putExtra(SettingActivity.EXTRA_TYPE_FORM, SettingActivity.TYPE_ADD)
                    intent.putExtra("USER", userModel)
                }
                else -> {
                    intent.putExtra(SettingActivity.EXTRA_TYPE_FORM, SettingActivity.TYPE_EDIT)
                    intent.putExtra("USER", userModel)
                }
            }
            startActivityForResult(intent, REQUEST_CODE)
            Animatoo.animateZoom(this)

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == SettingActivity.RESULT_CODE) {
                userModel = data?.getParcelableExtra(SettingActivity.EXTRA_RESULT) as User
                populateView(userModel)
            }
            if (resultCode == QuisActivity.RESULT_CODE) {
                userModel = data?.getParcelableExtra(QuisActivity.EXTRA_RESULT) as User
                populateView(userModel)
            }

        }
    }

    private fun showExistingPreference() {
        userModel = mUserPreference.getUser()
        populateView(userModel)
    }
    private fun populateView(userModel: User) {
        tv_name.text = userModel.nama
        val poin = userModel.poin
        tv_poin.text = "Poin : $poin "
    }


    private fun setSingleEvent(mainGrid: GridLayout) {
        //Loop all child item of Main Grid
        for (i in 0 until mainGrid.childCount) {
            //You can see , all child item is CardView , so we just cast object to CardView
            val cardView = mainGrid.getChildAt(i) as CardView
            cardView.setOnClickListener {
                print(i)
                if (i == 7){
                    val intent1 = Intent(this@MainActivity, QuisActivity::class.java)
                    intent1.putExtra("USER", userModel)
                    startActivityForResult(intent1, REQUEST_CODE)
                    Animatoo.animateZoom(this)
                }else{

                    val a = i+1
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra("modul", "Modul$a.pdf")
                    startActivity(intent)
                    Animatoo.animateZoom(this)
                }
            }
        }
    }

}
