package com.wordpress.uniquecoder.hackathon

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.bassaer.chatmessageview.model.ChatUser
import com.github.bassaer.chatmessageview.model.Message
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager
import com.wordpress.uniquecoder.hackathon.R.id.my_chat_view
import kotlinx.android.synthetic.main.activity_help.*
import java.util.*

class help : AppCompatActivity() {
    companion object {
        private const val ACCESS_TOKEN = "f46fbe5572b442a4a6cda87d4326f21d"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        //fuel manager setting.
        FuelManager.instance.baseHeaders = mapOf(
                "Authorization" to "Bearer $ACCESS_TOKEN"
        )
        FuelManager.instance.basePath =
                "https://api.dialogflow.com/v1/"
        FuelManager.instance.baseParams = listOf(
                "v" to "20170712",                  // latest protocol
                "sessionId" to UUID.randomUUID(),   // random ID
                "lang" to "en"                      // English language
        )

        //Configuring the Chat Interface
        val human = ChatUser(
                1,
                "You",
                BitmapFactory.decodeResource(resources,
                        R.drawable.ic_account_circle)
        )
        val agent = ChatUser(
                2,
                "Agent",
                BitmapFactory.decodeResource(resources,
                        R.drawable.ic_account_circle)
        )
        //sending and receiving message!

        my_chat_view.setOnClickSendButtonListener(
                View.OnClickListener {
                    my_chat_view.send(Message.Builder()
                            .setUser(human)
                            .setText(my_chat_view.inputText)
                            .build()
                    )
                    //Http response
                    Fuel.get("/query",
                            listOf("query" to my_chat_view.inputText))
                            .responseJson { _, _, result ->
                                val reply = result.get().obj()
                                        .getJSONObject("result")
                                        .getJSONObject("fulfillment")
                                        .getString("speech")

                                my_chat_view.send(Message.Builder()
                                        .setRight(true)
                                        .setUser(agent)
                                        .setText(reply)
                                        .build()
                                )
                            }
                    my_chat_view.inputText="";
                }
        )

    }
}
