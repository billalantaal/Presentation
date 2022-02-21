package com.example.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.R
import com.example.presentation.ui.network.NetworkResult


class CustomAdapter() :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    var dataSet: List<NetworkResult> = arrayListOf()

    var onItemClick: (NetworkResult) -> Unit = {}
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView
        val descriptionTextView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            titleTextView = view.findViewById(R.id.txtTitle)
            descriptionTextView = view.findViewById(R.id.txtTitleBody)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_text, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.titleTextView.text = dataSet[position].title
        viewHolder.descriptionTextView.text = dataSet[position].abstactt

        viewHolder.itemView.setOnClickListener {
            onItemClick.invoke(dataSet[position])
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<NetworkResult>) {
        dataSet = list
        notifyDataSetChanged()
    }
}
