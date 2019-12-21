package com.tjeit.a20191221_01_sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tjeit.a20191221_01_sharedpreference.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

//        Q1. 아이디 저장 로직 구현
//        loginBtn이 눌리면
//        idCheckBox가 체크되어있는지 검사 (구글링)
//        되어 있다면 idEdt에 적혀있는 값을 userId 라는 val로 저장

        loginBtn.setOnClickListener {
            if (idCheckBox.isChecked) {
                val userId = idEdt.text.toString()

                ContextUtil.setUserId(mContext, userId)
            }
        }
//        Q2. 아이디 저장 체크박스 체크여부 (Boolean)저장
//        IdCheckBox가 체크되면(구글링)
//        체크된 값(체크/해제)을 contextUtil - SharePreference활용해서 저장
//        앱이 켜질때 set

        idCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            Log.d("isChecked값", "${isChecked}")
            ContextUtil.setUserIdSave(mContext, isChecked)

        }




    }

    override fun setValues() {
        idEdt.setText(ContextUtil.getUserId(mContext))

        idCheckBox.isChecked = ContextUtil.getUserIdSave(mContext)

    }

}
