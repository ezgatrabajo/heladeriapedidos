package adaptivex.pedidoscloud.Servicios;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import adaptivex.pedidoscloud.Config.Configurador;
import adaptivex.pedidoscloud.Config.GlobalValues;
import adaptivex.pedidoscloud.Controller.MarcaController;
import adaptivex.pedidoscloud.Core.parserJSONtoModel.MarcaParser;
import adaptivex.pedidoscloud.Model.Marca;

import java.util.HashMap;

/**
 * Created by Ezequiel on 02/04/2017.
 */

public class HelperMarcas extends AsyncTask<Void, Void, Void> {
    private Context ctx;
    private HashMap<String,String> registro;
    private Marca marcas;
    private MarcaController marcasCtr;
    private int respuesta; //1=ok, 200=error
    private int opcion; //1 enviar Post Marca

    public HelperMarcas(Context pCtx){
        this.setCtx(pCtx);
        this.marcasCtr = new MarcaController(this.getCtx());
    }


    @Override
    protected Void doInBackground(Void... voids) {
        try{
            WebRequest webreq = new WebRequest();
            registro = new HashMap<String, String>();
            registro.put("empresa_id", String.valueOf(GlobalValues.getINSTANCIA().getUserlogued().getEntidad_id()));
            String jsonStr = webreq.makeWebServiceCall(Configurador.urlMarcas, WebRequest.POST,registro);
            MarcaParser cp = new MarcaParser(jsonStr);
            cp.parseJsonToObject();
            marcasCtr.abrir().limpiar();
            //Recorrer Lista
            for (int i = 0; i < cp.getListadoMarcas().size(); i++) {
                marcasCtr.abrir().agregar(cp.getListadoMarcas().get(i));
            }
            setRespuesta(GlobalValues.getINSTANCIA().RETURN_OK);
        }catch (Exception e){
                setRespuesta(GlobalValues.getINSTANCIA().RETURN_ERROR);
                Log.println(Log.ERROR,"ErrorHelper:",e.getMessage());

        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Showing progress dialog


    }


    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        if (getRespuesta()== GlobalValues.getINSTANCIA().RETURN_OK){

        }
    }
    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
}
