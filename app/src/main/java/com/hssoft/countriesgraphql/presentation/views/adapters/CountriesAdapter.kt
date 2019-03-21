package com.hssoft.countriesgraphql.presentation.views.adapters

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hssoft.countriesgraphql.R
import com.hssoft.countriesgraphql.presentation.extensions.inflateView
import com.hssoft.countriesgraphql.presentation.views.view_models_items.CountryViewItem
import kotlinx.android.synthetic.main.item_country.view.*
import kotlin.properties.Delegates

class CountriesAdapter : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    internal var items: List<CountryViewItem> by Delegates.observable(emptyList()) {
            _, _, _ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder =
        CountriesViewHolder(parent.inflateView(R.layout.item_country))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.initView(items[position])
    }

    inner class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal fun initView(country: CountryViewItem) = with(itemView) {
            val phoneText = "${resources.getString(R.string.countries_phone)} ${country.phone}"
            val phoneTextSpan = SpannableString(phoneText).apply {
                setSpan(ForegroundColorSpan(resources.getColor(R.color.text_black)), 0,
                    phoneText.indexOf(':') + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                setSpan(StyleSpan(Typeface.BOLD), 0,
                    phoneText.indexOf(':') + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            }
            country_item_title_tv.text = country.title
            country_item_code_tv.text = country.code
            country_item_phone_tv.text = phoneTextSpan
            country_item_emoji_tv.text = country.emoji
            country_item_languages_rv.apply {
                adapter = LanguagesAdapter(country.languages)
                layoutManager = LinearLayoutManager(itemView.context)
            }
        }
    }
}