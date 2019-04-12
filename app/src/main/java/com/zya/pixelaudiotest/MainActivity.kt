package com.zya.pixelaudiotest

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zya.pixelaudiotest.R

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        button_aac.setOnClickListener {
            val afd = assets.openFd("count.aac")
            mediaPlayer?.stop()
            mediaPlayer = MediaPlayer().apply {
                setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                prepare()
                start()
            }
        }

        button_mp3.setOnClickListener {
            val afd = assets.openFd("count.mp3")
            mediaPlayer?.stop()
            mediaPlayer = MediaPlayer().apply {
                setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                prepare()
                start()
            }
        }

        button_mp4.setOnClickListener {
            val afd = assets.openFd("count.mp4")
            mediaPlayer?.stop()
            mediaPlayer = MediaPlayer().apply {
                setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                prepare()
                start()
            }
        }
    }

    override fun onPause() {
        mediaPlayer?.stop()
        super.onPause()
    }
}
