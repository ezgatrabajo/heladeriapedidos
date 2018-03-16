package adaptivex.pedidoscloud.Model;

import java.util.ArrayList;

/**
 * Created by egalvan on 9/3/2018.
 */

public class Pote {
    private Pedido pedido;
    private Integer nroPote;
    private Integer kilos;
    private double heladomonto;
    private ArrayList <PoteItem> itemsPote; // es el helado que va a estar en el pote

    public Pote(){
        nroPote = 0;
        kilos = 0;
        heladomonto = 0.0;
        itemsPote = new ArrayList <PoteItem>();

    }

    public void addItemPote(PoteItem it){
        this.itemsPote.add(it);
    }
    public String getMontoString(){
        return "$ " + String.valueOf(this.getHeladomonto());
    }

    public Integer getNroPote() {
        return nroPote;
    }

    public void setNroPote(Integer nroPote) {
        this.nroPote = nroPote;
    }

    public Integer getKilos() {
        return kilos;
    }

    public void setKilos(Integer kilos) {
        this.kilos = kilos;
    }

    public double getHeladomonto() {
        return heladomonto;
    }

    public void setHeladomonto(double heladomonto) {
        this.heladomonto = heladomonto;
    }

    public ArrayList<PoteItem> getItemsPote() {
        return itemsPote;
    }

    public void setItemsPote(ArrayList<PoteItem> itemsPote) {
        this.itemsPote = itemsPote;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
