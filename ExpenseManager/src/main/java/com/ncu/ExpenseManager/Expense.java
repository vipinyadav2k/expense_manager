package com.ncu.ExpenseManager;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    private int id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 255, message = "Name length must be between 2 and 255 characters")
    private String name;

    @NotNull(message = "Cost cannot be null")
    @Positive(message = "Cost must be a positive value")
    private double cost;

    @NotBlank(message = "Color cannot be blank")
    private String color;

    private String url;

    @NotNull(message = "Date cannot be null")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense [id=" + id + ", name=" + name + ", cost=" + cost + ", color=" + color + ", url=" + url
                + ", date=" + date + "]";
    }
}
