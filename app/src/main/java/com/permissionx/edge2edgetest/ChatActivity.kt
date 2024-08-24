package com.permissionx.edge2edgetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class ChatActivity : AppCompatActivity(), View.OnClickListener {

    private val msgList = ArrayList<Msg>()

    private lateinit var recyclerView: RecyclerView

    private lateinit var inputTextLayout: LinearLayout

    private lateinit var send: Button

    private lateinit var inputText: EditText

    private lateinit var adapter: MsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        recyclerView = findViewById(R.id.recycler_view)
        inputTextLayout = findViewById(R.id.input_text_layout)
        send = findViewById(R.id.send)
        inputText = findViewById(R.id.input_text)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }
        recyclerView.adapter = adapter
        send.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(recyclerView) { v, insets ->
            val statusBars = insets.getInsets(WindowInsetsCompat.Type.statusBars())
            Log.d("TAG", "onCreate: left = ${statusBars.left} , right = ${statusBars.right} , top = ${statusBars.top} , bottom = ${statusBars.bottom}")
            v.setPadding(statusBars.left, statusBars.top, statusBars.right, statusBars.bottom)
            insets
        }
        ViewCompat.setOnApplyWindowInsetsListener(inputTextLayout) { v, insets ->
            val navigationBars = insets.getInsets(WindowInsetsCompat.Type.navigationBars())
            v.setPadding(navigationBars.left, navigationBars.top, navigationBars.right, navigationBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            send -> {
                val content = inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size - 1)
                    recyclerView.scrollToPosition(msgList.size - 1)
                    inputText.setText("")
                }
            }
        }
    }

    private fun initMsg() {
        val msg1 = Msg("Hello", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
        val msg4 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_SENT)
        msgList.add(msg4)
        val msg5 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_RECEIVED)
        msgList.add(msg5)
        val msg6 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_SENT)
        msgList.add(msg6)
        val msg7 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_RECEIVED)
        msgList.add(msg7)
        val msg8 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_SENT)
        msgList.add(msg8)
        val msg9 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_RECEIVED)
        msgList.add(msg9)
        val msg10 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_SENT)
        msgList.add(msg10)
        val msg11 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_RECEIVED)
        msgList.add(msg11)
        val msg12 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_SENT)
        msgList.add(msg12)
        val msg13 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_RECEIVED)
        msgList.add(msg13)
        val msg14 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_SENT)
        msgList.add(msg14)
        val msg15 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_RECEIVED)
        msgList.add(msg15)
        val msg16 = Msg("Random message ".repeat(Random.nextInt(1, 5)), Msg.TYPE_SENT)
        msgList.add(msg16)
    }

}
