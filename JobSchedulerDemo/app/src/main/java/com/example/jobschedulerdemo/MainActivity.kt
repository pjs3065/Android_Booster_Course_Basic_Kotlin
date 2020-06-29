package com.example.jobschedulerdemo

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jobschedulerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val jobScheduler by lazy { getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler }

    companion object {
        private const val jobID = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        onStartJobScheduler()
    }

    private fun onStartJobScheduler() {
        //작업 조건 설정
        val jobInfo = JobInfo.Builder(jobID, ComponentName(this, MyJobService::class.java))
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
            .setOverrideDeadline(5000)
            .setRequiresCharging(true)
            .build()

        //작업 스케줄러 스케줄 시작
        jobScheduler.schedule(jobInfo)
    }
}