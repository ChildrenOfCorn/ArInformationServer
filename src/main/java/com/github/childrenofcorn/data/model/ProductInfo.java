package com.github.childrenofcorn.data.model;

import java.util.List;

import lombok.Data;
import lombok.Setter;

/**
 * Created by grishberg on 15.04.17.
 * Данные о продукте
 */
@Data
public class ProductInfo {
    private long id;
    private String name; // название продукта
    private String briefDesc; // описание продукта
    private float rating; // рейтинг продукта, вычисляется из комментов
    private List<UserInfo> users; //  массив юзеров, которые просмотрели
    private List<Comment> comments; // комментарии
    private String url; // урл объекта

    public ProductInfo(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
