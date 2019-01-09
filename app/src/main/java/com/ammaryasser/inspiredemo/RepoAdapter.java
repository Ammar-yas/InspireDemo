package com.ammaryasser.inspiredemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ammaryasser.inspiredemo.databinding.ItemRepositoryBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepositoryViewHolder> {

    private List<RepositoryModel> repositories;
    private Context context;
    private Picasso picasso;

    @Inject
    public RepoAdapter(Context context, Picasso picasso) {
        this.context = context;
        this.picasso = picasso;
        repositories = new ArrayList<>();
    }

    public void setRepositories(List<RepositoryModel> repositories) {
        this.repositories = repositories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRepositoryBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_repository, parent, false);
        return new RepositoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
        holder.bind(repositories.get(position));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    class RepositoryViewHolder extends RecyclerView.ViewHolder {

        private ItemRepositoryBinding binding;

        RepositoryViewHolder(ItemRepositoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(RepositoryModel repoModel) {
            binding.setRepository(repoModel);
            binding.setPicasso(picasso);
        }
    }
}
