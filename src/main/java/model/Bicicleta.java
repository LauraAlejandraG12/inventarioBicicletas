package model;

public class Bicicleta {
    private Integer id;
    private String marca;
    private String modelo;
    private String color;
    private double precio;
    private Integer cantidad;

   
    public Bicicleta(String marca, String modelo, String color, double precio, Integer cantidad){
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.cantidad = cantidad;
    }


    public Bicicleta(Integer id, String marca, String modelo, String color, double precio, Integer cantidad){
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /*Getters */

    public Integer getId(){
        return id;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public String getColor(){
        return color;
    }

    public double getPrecio(){
        return precio;
    }

    public Integer getCantidad(){
        return cantidad;
    }


    /* setters */

    public void setId(Integer id){
        this.id = id;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public void setCantidad ( Integer cantidad){
        this.cantidad = cantidad;
    }
}






