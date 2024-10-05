package com.syedsaifhossain.restfulapidemo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var textId : TextView
    private lateinit var name : TextView
    private lateinit var userName : TextView
    private lateinit var email : TextView
    private lateinit var phone : TextView
    private lateinit var address : TextView
    private lateinit var company : TextView
    private lateinit var website : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        textId = findViewById(R.id.textId)
        name = findViewById(R.id.name)
        userName = findViewById(R.id.userName)
        email = findViewById(R.id.email)
        phone = findViewById(R.id.phone)
        address = findViewById(R.id.address)
        company = findViewById(R.id.company)
        website = findViewById(R.id.website)

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

                    textId.text = stringBuilder.toString()
                    name.text = stringBuilder.toString()
                    userName.text = stringBuilder.toString()
                    email.text = stringBuilder.toString()
                    phone.text = stringBuilder.toString()
                    address.text = stringBuilder.toString()
                    company.text = stringBuilder.toString()
                    website.text = stringBuilder.toString()
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