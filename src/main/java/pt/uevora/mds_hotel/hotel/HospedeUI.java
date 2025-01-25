package pt.uevora.mds_hotel.hotel;

import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;
import pt.uevora.mds_hotel.quartos.TipoDeVista;

import java.util.ArrayList;
import java.util.List;

public class HospedeUI {
    protected List<Quarto> listaDeQuartos;
    protected List<PedidoManutencao> listaDePedidosRequisitados;

    public HospedeUI() {
        this.listaDeQuartos = new ArrayList<>();
        this.listaDePedidosRequisitados = new ArrayList<>();
    }

    public void adicionarPedido(PedidoManutencao pedido) {
        this.listaDePedidosRequisitados.add(pedido);
    }

    public List<Quarto> filtrarPesquisaQuartos(Integer capacidadeMaxPessoas, Integer numDeCamas, TipoDeVista tipoDeVista, Boolean cozinha, Integer numCasasDeBanho, Boolean varanda) {
        List<Quarto> quartosEscolhidos = new ArrayList<>();
        Boolean filtroCapacidade = false;
        if(capacidadeMaxPessoas != null){
            filtroCapacidade = true;
        }
        
        Boolean filtroNumCamas = false;
        if(numDeCamas != null){
            filtroNumCamas = true;
        }
        
        Boolean filtroTipoDeVista = false;
        if(tipoDeVista != null){
            filtroTipoDeVista = true;
        }
        
        Boolean filtroTemCozinha = false;
        if(cozinha != null){
            filtroTemCozinha = true;
        }
        
        Boolean filtroNumCasasBanho = false;
        if(numCasasDeBanho != null){
            filtroNumCasasBanho = true;
        }
        
        Boolean filtroTemVaranda = false;
        if(varanda != null){
            filtroTemVaranda = true;
        }
        
        for(Quarto quarto : listaDeQuartos){
            if(filtroCapacidade && quarto.getCapacidadeMaxPessoas() == capacidadeMaxPessoas) continue;
            if(filtroNumCamas && quarto.getNumCasasDeBanho() == numDeCamas) continue;
            if(filtroTipoDeVista && quarto.getTipoDeVista() == tipoDeVista) continue;
            if(filtroTemCozinha && quarto.hasCozinha() == cozinha) continue;
            if(filtroNumCasasBanho && quarto.getNumCasasDeBanho() == numCasasDeBanho) continue;
            if(filtroTemVaranda && quarto.hasVaranda() == varanda) continue;

            quartosEscolhidos.add(quarto);
        }

        return quartosEscolhidos;
    }
}
