package model;

import java.util.Map;

public class Conversor {
    private String nomeMoedaPrincipal;
    private Map<String, Double> tabelaConversao;
    private String nomeMoedaConvertida;
    private Double valor;

    public Conversor(MoedaAPI moeda, Double valor, String nomeMoedaConvertida) {
        this.nomeMoedaPrincipal = moeda.base_code();
        this.tabelaConversao = moeda.conversion_rates();
        this.nomeMoedaConvertida = nomeMoedaConvertida;
        this.valor = valor;
    }

    public Double converter(){
        Double taxa = tabelaConversao.get(nomeMoedaConvertida);
        return valor * taxa;
    }


    public String getNome() {
        return nomeMoedaPrincipal;
    }

    public Map<String, Double> getTabelaConversao() {
        return tabelaConversao;
    }

    public String getNomeMoedaConvertida() {
        return nomeMoedaConvertida;
    }
}
