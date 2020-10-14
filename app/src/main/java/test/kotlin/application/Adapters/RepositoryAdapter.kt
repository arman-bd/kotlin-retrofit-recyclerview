package test.kotlin.application.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.kotlin.application.Retrofit.Models.Repositories
import test.kotlin.application.databinding.ItemRepoBinding

class RepositoryAdapter(private val data: List<Repositories>) : RecyclerView.Adapter<RepositoryAdapter.MyViewHolder>() {

    class MyViewHolder(val itemRepoBinding: ItemRepoBinding) : RecyclerView.ViewHolder(itemRepoBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemRepoBinding = ItemRepoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return MyViewHolder(itemRepoBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemRepoBinding.textRepoName.text = data.get(position).name;
        holder.itemRepoBinding.textStarts.text = "Stars: " + data.get(position).stargazers_count.toString();
        holder.itemRepoBinding.textWatchers.text = "Watchers: " + data.get(position).watchers_count.toString();
    }

    override fun getItemCount(): Int = data.size
}