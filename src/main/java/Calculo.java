public class Calculo {
    private double distancia;
    Calculo(){}

    public double calcular(Balao a,Balao b){
        double lat = Math.abs(a.getLatitude()-b.getLatitude());
        double lon = Math.abs(a.getLongitude()-b.getLongitude());

       return distancia = Math.sqrt(Math.pow(lat,2)+Math.pow(lon,2));
    }

    public double calcular(Balao a, ERB b){
        double lat = Math.abs(a.getLatitude()-b.getLatitude());
        double lon = Math.abs(a.getLongitude()-b.getLongitude());

        return distancia = Math.sqrt(Math.pow(lat,2)+Math.pow(lon,2));
    }

    public double calcular(ERB a, ERB b){
        double lat = Math.abs(a.getLatitude()-b.getLatitude());
        double lon = Math.abs(a.getLongitude()-b.getLongitude());

        return distancia = Math.sqrt(Math.pow(lat,2)+Math.pow(lon,2));
    }

    public double calcular(Usuario a, ERB b){
        double lat = Math.abs(a.getLatitude()-b.getLatitude());
        double lon = Math.abs(a.getLongitude()-b.getLongitude());

        return distancia = Math.sqrt(Math.pow(lat,2)+Math.pow(lon,2));
    }

    public double calcular(Usuario a, Balao b){
        double lat = Math.abs(a.getLatitude()-b.getLatitude());
        double lon = Math.abs(a.getLongitude()-b.getLongitude());

        return distancia = Math.sqrt(Math.pow(lat,2)+Math.pow(lon,2));
    }
}
