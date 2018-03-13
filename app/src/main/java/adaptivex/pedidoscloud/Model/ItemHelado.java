package adaptivex.pedidoscloud.Model;

/**
 * Created by egalvan on 13/3/2018.
 */

public class ItemHelado {
    private boolean checked;
    private Producto helado;
    private Integer proporcion;

    public ItemHelado(Producto h, boolean c, Integer p){
        setHelado(h);
        setChecked(c);
        setProporcion(p);
    }

    public boolean isChecked(){
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Producto getHelado() {
        return helado;
    }

    public void setHelado(Producto helado) {
        this.helado = helado;
    }

    public Integer getProporcion() {
        return proporcion;
    }

    public void setProporcion(Integer proporcion) {
        this.proporcion = proporcion;
    }
}
