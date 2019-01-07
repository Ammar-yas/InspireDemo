package com.ammaryasser.inspiredemo;

import com.google.gson.annotations.SerializedName;

public class RepositoryModel {

    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("owner")
    private Owner owner;

    public RepositoryModel(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.owner = new Owner(url);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return owner.getUrl();
    }

    class Owner {
        @SerializedName("avatar_url")
        private String url;

        public Owner(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

}
