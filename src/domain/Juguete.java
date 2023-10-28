package domain;

public interface Juguete {
    long getId();
    String getColor();
    Juguete clone();
    void setId(long id);
}

