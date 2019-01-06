package com.ammaryasser.inspiredemo;

import com.google.gson.annotations.SerializedName;

public class RepoModel {

    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("owner")
    private Owner owner;

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

        public String getUrl() {
            return url;
        }
    }

}
