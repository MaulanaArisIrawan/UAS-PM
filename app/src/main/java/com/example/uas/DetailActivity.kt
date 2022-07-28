package com.example.uas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uas.data.ApiClient
import com.example.uas.data.ResponseApi
import com.example.uas.databinding.ActivityDetail2Binding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetail2Binding
    private var myData: ResponseApi.ResponseApiItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        myData = intent.getParcelableExtra("data")
        myData?.apply {
            binding.title.text = title
            binding.des.text = body
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            R.id.btnDelete -> {
                ApiClient.service.deletePost(myData?.id ?: 0)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Toast.makeText(
                            this@DetailActivity,
                            "berhasil delete post",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    }, {
                        Log.e("main", it.message.toString())
                    })
            }
            R.id.btnEdit -> {
                Intent(this@DetailActivity, EditActivity::class.java).apply {
                    putExtra("data", myData)
                    startActivity(this)
                    finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}