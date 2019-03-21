package com.hssoft.countriesgraphql.presentation.views.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hssoft.countriesgraphql.R
import com.hssoft.countriesgraphql.presentation.extensions.inflateView
import com.hssoft.countriesgraphql.presentation.views.view_models_items.ContinentViewItem
import kotlinx.android.synthetic.main.item_continent.view.*
import kotlin.properties.Delegates

class ContinentsAdapter(val clickListener: (String) -> Unit)
                                                    : RecyclerView.Adapter<ContinentsAdapter.ContinentsViewHolder>() {

    internal var items: List<ContinentViewItem> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContinentsViewHolder =
        ContinentsViewHolder(parent.inflateView(R.layout.item_continent))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ContinentsViewHolder, position: Int) {
        holder.initView(items[position])
    }

    inner class ContinentsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { clickListener(items[adapterPosition].code) }
        }

        internal fun initView(continent: ContinentViewItem) = with(itemView) {
            item_continent_title.text = continent.name
        }
    }
}