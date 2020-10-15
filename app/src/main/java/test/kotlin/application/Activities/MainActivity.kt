package test.kotlin.application.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.kotlin.application.Adapters.RepositoryAdapter
import test.kotlin.application.Retrofit.GitHub
import test.kotlin.application.Retrofit.Models.Repositories
import test.kotlin.application.Retrofit.ServiceBuilder
import test.kotlin.application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindings = ActivityMainBinding.inflate(layoutInflater);
        setContentView(bindings.root)

        viewManager = LinearLayoutManager(this)

        val request = ServiceBuilder.buildService(GitHub::class.java)
        val call = request.listRepos("arman-bd")

        call.enqueue(object : Callback<List<Repositories>>{
            override fun onFailure(call: Call<List<Repositories>>, t: Throwable) {
                Log.d("Response", "Error")
            }

            override fun onResponse(call: Call<List<Repositories>>, response: Response<List<Repositories>>) {
                if(response.body() != null){
                    viewAdapter = RepositoryAdapter(response.body()!!)
                    recyclerView = bindings.myRecycler.apply {
                        setHasFixedSize(true)
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }
            }
        })

    }
}