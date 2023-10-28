package domain.impl;

import domain.Juguete;

public class Carrito implements Juguete {

    private long id;
    private String color;
    private short numeroPuertas;
    private String marca;

    public Carrito(long id, String color, short numeroPuertas, String marca) {
        this.id = id;
        this.color = color;
        this.numeroPuertas = numeroPuertas;
        this.marca = marca;
    }

    public short getNumeroPuertas() {
            return this.numeroPuertas;
        }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Carrito clone() {
        return Carrito.builder()
                .color(this.color)
                .numeroPuertas(this.numeroPuertas)
                .marca(this.marca)
                .build();
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public static CarritoBuilder builder() {
        return new CarritoBuilder();
    }

    public static class CarritoBuilder {
        private long id;
        private String color;
        private short numeroPuertas;
        private String marca;

        public CarritoBuilder id(long id) {
            this.id = id;
            return this;
        }

        public CarritoBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarritoBuilder numeroPuertas(short numeroPuertas) {
            this.numeroPuertas = numeroPuertas;
            return this;
        }

        

        public CarritoBuilder marca(String marca) {
            this.marca = marca;
            return this;
        }

        public Carrito build() {
            return new Carrito(id, color, numeroPuertas, marca);
        }
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", numeroPuertas=" + numeroPuertas +
                ", marca='" + marca + '\'' +
                '}';
    }
}
