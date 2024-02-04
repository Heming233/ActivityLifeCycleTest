package com.example.activiytylifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import com.example.activiytylifecycletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"

    //onCreate在Activity第一次被创建时调用，用于初始化Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        setContentView(R.layout.activity_main)

        //恢复Activity被销毁前的输入值
        if(savedInstanceState != null){
            val tempData = savedInstanceState.getString("data_key")
            Log.d(tag, "tempData is $tempData")
        }

        //ViewBinding
        //build.gradle修改后记得同步项目
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //设置normalActivity按钮
        binding.startNormalActivity.setOnClickListener({
            Toast.makeText(this, "You clicked 'Start Normal'", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
            Log.d(tag, "NormalActivity has been started!")
        })

        //设置dialogActivity按钮
        binding.startDialogActivity.setOnClickListener({
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
            Log.d(tag, "DialogActivity has been started!")
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
    //Activity在onResume和onPause之间经历的是一个前台生存期
    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    //在Activity完全不可见时调用。如果新Activity是一个对话框，那么onStop不会执行
    //执行的是onPause
    //Activity在onStart和onStop之间经历的是一个可见生存期
    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    //Activity在onCreate和onDestroy之间经历的就是一个完整的生存期
    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }

    //在Activity由停止状态变为运行状态之前调用
    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
    }

    //重写保存实例状态函数
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        val tempData = "Something you just typed"
        outState.putString("data_key", tempData)
    }
}