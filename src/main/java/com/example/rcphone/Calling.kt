package com.example.rcphone

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rcphone.ringout.DisconnectRingOutPublic
import com.example.rcphone.ringout.Disconnect_RIngOut
import kotlinx.android.synthetic.main.activity_calling.*


class Calling : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling)
        val responseid = intent.extras!!.getString("responseid")
        btnDisconnect.setOnClickListener {

            call(responseid!!)
        }


    }
    fun call(responseId:String) {
        Test(responseId,this).execute()
    }
    class Test(responseId: String,context: Context) : AsyncTask<Void, Void, Unit>() {
        val mContext=context
        val responseId:String=responseId

        override fun doInBackground(vararg p0: Void?) {

            var disconnectRingout = Disconnect_RIngOut(responseId,mContext)
            disconnectRingout.RingCentral()

        }

    }
}
