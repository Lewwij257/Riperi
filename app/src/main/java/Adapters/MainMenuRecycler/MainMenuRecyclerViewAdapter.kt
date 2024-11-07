package Adapters.MainMenuRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.locaspes.riperi.R
import Adapters.MainMenuRecycler.MainMenuRecyclerItem // Добавьте импорт

class MainMenuRecyclerViewAdapter(private val mainMenuRecyclerItemsArrayList: ArrayList<MainMenuRecyclerItem>):
    RecyclerView.Adapter<MainMenuRecyclerViewAdapter.MainMenuRecyclerViewViewHolder>() {



    class MainMenuRecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTittle: TextView = itemView.findViewById<TextView>(R.id.tv_main_menu_recycler_item_tittle)
        val tvDescription: TextView = itemView.findViewById<TextView>(R.id.tv_main_menu_recycler_item_description)
        val ivBackground: ImageView = itemView.findViewById<ImageView>(R.id.iv_main_menu_recycler_item_background)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MainMenuRecyclerViewViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.main_menu_recycler_item, viewGroup, false)
        return MainMenuRecyclerViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mainMenuRecyclerItemsArrayList.size
    }

    override fun onBindViewHolder(holder: MainMenuRecyclerViewViewHolder, position: Int) {
        holder.tvTittle.text = (mainMenuRecyclerItemsArrayList[position]).tittle
        holder.tvDescription.text = (mainMenuRecyclerItemsArrayList[position]).description
        holder.ivBackground.setImageDrawable((mainMenuRecyclerItemsArrayList[position]).img)
    }

}