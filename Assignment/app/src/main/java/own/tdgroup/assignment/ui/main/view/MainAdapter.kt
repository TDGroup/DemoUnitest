package own.tdgroup.assignment.ui.main.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_city.view.*
import own.tdgroup.assignment.R
import own.tdgroup.assignment.data.entity.City

import java.util.ArrayList


class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    private val list = ArrayList<City>()



    fun setData(list: List<City>) {
        for (item in list) {
            this.list.add(item)
        }
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.country.text = data.country
        holder.city.text = data.city
        holder.population.text = data.population.toString()

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var country = itemView.country
        var city: TextView = itemView.city
        var population = itemView.population

    }


}
