package com.example.user.lastapplevel2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_second.*

class SecondAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button2.setOnClickListener {

            var url:String="http://pioneersacademyproject.com/add_user.php"
            var rq=Volley.newRequestQueue(this)
            var sr=object: StringRequest(Request.Method.POST,url,
                    Response.Listener {response ->
                        Toast.makeText(this,response,
                                Toast.LENGTH_LONG).show()
                    },
                    Response.ErrorListener { error ->
                        Toast.makeText(this,error.message,
                                Toast.LENGTH_LONG).show()
                    })
            {
                override fun getParams(): MutableMap<String, String> {

                    var map=HashMap<String,String>()
                    map.put("mobile",editText.text.toString())
                    map.put("password",editText2.text.toString())
                    map.put("name",editText3.text.toString())
                    map.put("address",editText4.text.toString())

                    return map
                }
            }

            rq.add(sr)

        }
    }
}
