package mx.com.yh.huntinghome.modelos;

public class EntidadListaPropiasResidencias {

    private int imgRes;
    private String munRes,estRes,colRes,tipoRes,precioRes;
    private boolean residenciaActiva;

    public EntidadListaPropiasResidencias() {
    }

    public EntidadListaPropiasResidencias(int imgRes, String munRes, String estRes, String colRes, String tipoRes, String precioRes, boolean residenciaActiva) {
        this.imgRes = imgRes;
        this.munRes = munRes;
        this.estRes = estRes;
        this.colRes = colRes;
        this.tipoRes = tipoRes;
        this.precioRes = precioRes;
        this.residenciaActiva = residenciaActiva;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getMunRes() {
        return munRes;
    }

    public void setMunRes(String munRes) {
        this.munRes = munRes;
    }

    public String getEstRes() {
        return estRes;
    }

    public void setEstRes(String estRes) {
        this.estRes = estRes;
    }

    public String getColRes() {
        return colRes;
    }

    public void setColRes(String colRes) {
        this.colRes = colRes;
    }

    public String getTipoRes() {
        return tipoRes;
    }

    public void setTipoRes(String tipoRes) {
        this.tipoRes = tipoRes;
    }

    public String getPrecioRes() {
        return precioRes;
    }

    public void setPrecioRes(String precioRes) {
        this.precioRes = precioRes;
    }

    public boolean isResidenciaActiva() {
        return residenciaActiva;
    }

    public void setResidenciaActiva(boolean residenciaActiva) {
        this.residenciaActiva = residenciaActiva;
    }
}
