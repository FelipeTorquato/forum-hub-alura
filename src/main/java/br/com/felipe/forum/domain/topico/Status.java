package br.com.felipe.forum.domain.topico;

public enum Status {
    ABERTO(0), FECHADO(1), SOLUCIONADO(2);

    public int value;

    Status(int value) {
        this.value = value;
    }
}
