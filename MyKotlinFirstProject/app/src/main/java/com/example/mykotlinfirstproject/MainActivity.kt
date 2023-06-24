package com.example.mykotlinfirstproject

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.mykotlinfirstproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)




        binding.btnGirisYap.setOnClickListener{

            var kayitliKullanıcı=preferences.getString("kullanici","")
            var kayitliparola=preferences.getString("parola","")

            var girisKullanici=binding.girisKullaniciAdi.text.toString()
            var girisParola=binding.girisParola.text.toString()
            binding.textView.text="Merhabalar $kayitliKullanıcı"


            if((kayitliKullanıcı==girisKullanici) && kayitliparola==girisParola)
            {
                intent = Intent(applicationContext,MainHosgeldiniz::class.java)
                startActivity(intent)
                binding.textView.text="Merhabalar $kayitliKullanıcı"

            }
            else
            {
                Toast.makeText(applicationContext,"Hatalı Giriş Tekrar Deneyiniz",Toast.LENGTH_LONG).show()
                binding.girisKullaniciAdi.text.clear()
                binding.girisParola.text.clear()
            }

        }

        binding.btnKayitOl.setOnClickListener{

            intent = Intent(applicationContext,MainKyitOl::class.java)
            startActivity(intent)
        }










    }






}