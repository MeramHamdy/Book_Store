package com.example.book_store

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.book_store.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        val books = mutableListOf<Book>(
            Book("@drawable/solitude","Solitude","by Gabriel Garcia",2.5),
            Book("@drawable/nostra","Terra Nostra","by Carios Fuentes",2),
            Book("@drawable/angels","Angles & Demons","by Dan Brown",3),
            Book("@drawable/sword","The Sword Thief","by Peter Lerangis",3.5),
            Book("@drawable/blood","Bloodline","by James Rollins",2),
            Book("@drawable/spirits","The House of the Spirits","by Isabel",5),
            Book("@drawable/humming","Humming","by LuisAlberto",1),
            Book("@drawable/blood","Bloodline","by James Rollins",2),
            Book("@drawable/spirits","The House of the Spirits","by Isabel",5),
        )
        val bookAdapter =BookAdapter(books)
        binding.rc.adapter = bookAdapter


        binding.toolbar.materialToolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.reviews -> {
                    Toast.makeText(this,R.string.reviews_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.favorite -> {
                    Toast.makeText(this, R.string.favorite_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, R.string.search_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.profile -> {
                    Toast.makeText(this, R.string.profile_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this, R.string.settings_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
            }

                else -> false
            }
        }

    }
}