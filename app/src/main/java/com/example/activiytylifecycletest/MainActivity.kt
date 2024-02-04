package com.example.activiytylifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activiytylifecycletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"

    //onCreate在Activity第一次被创建时调用，用于初始化Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        setContentView(R.layout.activity_main)

        //ViewBinding
        //build.gradle修改后记得同步项目
        val binding = ActivityMainBinding.inflate(layoutInflater)

        //设置normalActivity按钮
        binding.startNormalActivity.setOnClickListener({
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        })

        //设置dialogActivity按钮
        binding.startDialogActivity.setOnClickListener({
            val intent = Intent(this, DialogActivity::class.java)
        })
    }

    //在Activity由不可见变为可见时调用
    override fun onStart(){
        super.onStart()
        Log.d(tag, "onStart")
    }

    //在Activity准备好与用户交互时调用，此时该Activity一定位于返回栈顶端
    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    //在系统准备启动或恢复另一个Activity时调用，释放一些消耗CPU的资源、保存一些关键数据
    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    //在Activity完全不可见时调用。如果新Activity是一个对话框，那么onStop不会执行
    //执行的是onPause
    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }

    //在Activity由停止状态变为运行状态之前调用
    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
    }
}