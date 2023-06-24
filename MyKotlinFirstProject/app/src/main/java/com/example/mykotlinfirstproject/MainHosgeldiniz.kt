package com.example.mykotlinfirstproject

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlinfirstproject.databinding.ActivityMainHosgeldinizBinding

class MainHosgeldiniz : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainHosgeldinizBinding.inflate(layoutInflater)

        setContentView(binding.root)



            preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)
            var kayitliKullanici=preferences.getString("kullanici","")
            var kayitliParola=preferences.getString("parola","")

            binding.kullaniciBilgisi.text="Kullanıcı Adı "+kayitliKullanici.toString()
            binding.kullaniciParola.text="Kullanıcı Adı "+kayitliParola.toString()


        binding.btnCikisYap.setOnClickListener{
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
            }


    }
}