package Model;

import java.time.LocalDate;

public class NovoRegistro {
    private int id;
    private LocalDate dataCadastro;

    public NovoRegistro(int id) {
        this.id = id;
        this.dataCadastro = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "NovoRegistro [id=" + id + ", dataCadastro=" + dataCadastro + "]";
    }

}
