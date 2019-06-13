package com.geekbrains.gramophone.rest.DTO;

import lombok.Data;

@Data
public class Like {
    private boolean liked;

    public Like(boolean liked) {
        this.liked = liked;
    }
}
