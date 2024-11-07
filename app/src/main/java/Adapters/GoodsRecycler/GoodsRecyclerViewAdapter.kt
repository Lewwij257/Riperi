package Adapters.GoodsRecycler


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.locaspes.riperi.R

class GoodsRecyclerViewAdapter(private val goodsRecyclerItemsArrayList: ArrayList<GoodsRecyclerItem>):
    RecyclerView.Adapter<GoodsRecyclerViewAdapter.GoodsRecyclerViewViewHolder>() {

    class GoodsRecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName = itemView.findViewById<TextView>(R.id.tv_goods_item_name)
        val tvDescription = itemView.findViewById<TextView>(R.id.tv_goods_item_description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsRecyclerViewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.goods_recycler_item, parent, false)
        return GoodsRecyclerViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return goodsRecyclerItemsArrayList.size
    }

    override fun onBindViewHolder(holder: GoodsRecyclerViewViewHolder, position: Int) {
        holder.tvName.text = (goodsRecyclerItemsArrayList[position]).name
        holder.tvDescription.text = (goodsRecyclerItemsArrayList[position]).description
    }

}