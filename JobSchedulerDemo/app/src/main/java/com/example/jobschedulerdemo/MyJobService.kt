package com.example.jobschedulerdemo

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.AsyncTask
import android.os.SystemClock
import android.widget.Toast

class MyJobService: JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        Toast.makeText(this, "작업 스케줄러", Toast.LENGTH_SHORT).show()
        JobServiceTask(this).execute(params)
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        return false
    }

    companion object {
        private class JobServiceTask(val myJobService: MyJobService): AsyncTask<JobParameters, Void, JobParameters>() {
            override fun doInBackground(vararg params: JobParameters?): JobParameters? {
                SystemClock.sleep(5000)
                return params[0]
            }

            override fun onPostExecute(jobParameters: JobParameters?) {
                myJobService.jobFinished(jobParameters, false)
            }
        }
    }
}