package pt.uevora.mds_hotel.manutencao;

import pt.uevora.mds_hotel.quartos.Quarto;

public class ManutencaoRealizada {
    private static int AuxParaId = 0;

    private final int manutencaoRealizadoID;
    private final int quartoID;
    private final String manutencaoRequisitada;

    private String manutencaoFeita;

    public ManutencaoRealizada(String manutencaoFeita, Quarto quarto, PedidoManutencao pedido) {
        manutencaoRealizadoID = ++AuxParaId;
        this.manutencaoRequisitada = pedido.getManutencaoReq();
        this.quartoID = quarto.getNumeroDoQuarto();
        this.manutencaoFeita = manutencaoFeita;

        this.setManutencaoRealizada(manutencaoFeita);
    }

    private void validarManutencaoRealizada(String manutencaoFeita) {
        if(manutencaoFeita.length() == 0) throw new IllegalArgumentException("Erro: Uma manutencao realizada deve ter pelo menos 1 caracter para fazer o pedido."); 
    }

    public String getPedidoDeManutencao(){
        return manutencaoRequisitada;
    }

    public int getNumQuarto() {
        return quartoID;
    }

    public String getManutencaoRelizada(){
        return manutencaoFeita;
    }

    public int getIDManutencaoRealizada() {
        return manutencaoRealizadoID;
    }

    public void setManutencaoRealizada(String manutencaoFeita) {
        this.validarManutencaoRealizada(manutencaoFeita);
        this.manutencaoFeita = manutencaoFeita;
    }


}
