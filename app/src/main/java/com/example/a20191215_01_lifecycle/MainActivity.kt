package com.example.a20191215_01_lifecycle

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun setupEvent() {

        callActivityBtn.setOnClickListener {
            val intent = Intent(mContext, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun setValue() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValue()
        setupEvent()

        Log.d("생명주기", "onCreate")
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        val alert = AlertDialog.Builder(mContext)
        alert.setTitle("게시글 작성 중지 확인")
        alert.setMessage("정말 글 작성을 중단 하시겠습니까 ? 작성하신 내용은 모두 삭제됩니다.")
        alert.setPositiveButton("확인",DialogInterface.OnClickListener { dialog, which -> finish() })
        alert.setNegativeButton("취소",null)
        alert.show()

    }

    override fun onResume() {
        super.onResume()

        Log.d("생명주기", "onReasum 실행")
    }

    override fun onPause() {
        super.onPause()
        Log.d("생명주기","onPause 실행")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("생명주기","onDestroy 실행")
    }
}
