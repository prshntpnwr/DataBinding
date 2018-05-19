package com.example.prashant.databinding.owner;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.prashant.databinding.Contact;
import com.example.prashant.databinding.databinding.ContactBinding;

import java.util.ArrayList;

/**
 * Created by prashant on 18/5/18.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    ArrayList<Contact> contactArrayList = new ArrayList<>();

    public ItemAdapter(ArrayList<Contact> contactArrayList) {
        this.contactArrayList = contactArrayList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ContactBinding itemBinding = ContactBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        holder.bind(contactArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ContactBinding binding;

        public ViewHolder(ContactBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Contact item) {
            Log.d("Item Adapter ", item.getName());
            binding.setContact(item);
            binding.executePendingBindings();
        }
    }
}