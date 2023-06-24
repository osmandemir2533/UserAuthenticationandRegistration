package com.example.mykotlinfirstproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mykotlinfirstproject.databinding.ActivityMainHosgeldinizBinding
import com.example.mykotlinfirstproject.databinding.ActivityMainKyitOlBinding

class MainKyitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainKyitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKaydet.setOnClickListener{
            var kullaniciBilgisi=binding.kayitKullaniciAdi.text.toString()
            var kullaniciParola=binding.kayitParola.text.toString()

            var sharedPreferences=this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            var editor=sharedPreferences.edit()

            editor.putString("kullanici","$kullaniciBilgisi").apply()
            editor.putString("parola","$kullaniciParola").apply()

            Toast.makeText(applicationContext,"Kayıt Başarılı",Toast.LENGTH_LONG).show()
            binding.kayitKullaniciAdi.text.clear()
            binding.kayitParola.text.clear()
        }





        binding.btnGiriseDon.setOnClickListener{
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}