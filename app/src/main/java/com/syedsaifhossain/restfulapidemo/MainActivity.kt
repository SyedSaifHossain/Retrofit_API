package com.syedsaifhossain.restfulapidemo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.syedsaifhossain.restfulapidemo.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)



        ProductService.retrofit.getProduct().enqueue(object : Callback<List<UsersItem>> {
            override fun onResponse(call: Call<List<UsersItem>>, response: Response<List<UsersItem>>) {
                if (response.isSuccessful){

                    var users = response.body()
                    var stringBuilder = StringBuilder()
                    users?.forEach(){

                        stringBuilder.append("User Id: ${it.id}"+ "\n")
                        stringBuilder.append("Name: ${it.name}"+ "\n")
                        stringBuilder.append("User Name: ${it.username}"+ "\n")
                        stringBuilder.append("Email: ${it.email}"+ "\n")
                        stringBuilder.append("Phone: ${it.phone}"+ "\n")
                        stringBuilder.append("Address: ${it.address}"+ "\n")
                        stringBuilder.append("Company: ${it.company}"+ "\n")
                        stringBuilder.append("Website: ${it.website}"+ "\n"+ "\n"+ "\n")
                    }

                    binding.textId.text = stringBuilder.toString()
                    binding.name.text = stringBuilder.toString()
                    binding.userName.text = stringBuilder.toString()
                    binding.email.text = stringBuilder.toString()
                    binding.phone.text = stringBuilder.toString()
                    binding.address.text = stringBuilder.toString()
                    binding.company.text = stringBuilder.toString()
                    binding.website.text = stringBuilder.toString()
                }
                else {
                    println("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {

                println("Failed to fetch posts: ${t.message}")
            }
        })

    }

}