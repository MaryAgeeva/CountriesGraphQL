package com.hssoft.countriesgraphql.presentation.views.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hssoft.countriesgraphql.R
import com.hssoft.countriesgraphql.presentation.extensions.inflateView
import com.hssoft.countriesgraphql.presentation.views.view_models_items.LanguageViewItem
import kotlinx.android.synthetic.main.item_languages.view.*

class LanguagesAdapter(private val items: List<LanguageViewItem>) : RecyclerView.Adapter<LanguagesAdapter.LanguagesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguagesViewHolder =
        LanguagesViewHolder(parent.inflateView(R.layout.item_languages))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: LanguagesViewHolder, position: Int) {
        holder.initView(items[position])
    }

    inner class LanguagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal fun initView(language: LanguageViewItem) = with(itemView) {
            language_title.text = language.title
        }
    }
}