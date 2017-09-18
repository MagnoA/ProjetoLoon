public class Calculo {


    Calculo(){}

    /**
     * Calculo simples entre a distância de dois balões usando pitágoras
     * @param a balão a
     * @param b balão b
     * @return distância
     */
    public double calcular(Balao a,Balao b){
        double lat = Math.abs(a.getLatitude()-b.getLatitude());
        double lon = Math.abs(a.getLongitude()-b.getLongitude());

       return Math.sqrt(Math.pow(lat,2)+Math.pow(lon,2));
    }

    /**
     * Distância entre um balão e uma estação de rádio base
     * @param a Balão
     * @param b ERB
     * @return distância
     */
    public double calcular(Balao a, ERB b){
        double lat = Math.abs(a.getLatitude()-b.getLatitude());
        double lon = Math.abs(a.getLongitude()-b.getLongitude());

        return Math.sqrt(Math.pow(lat,2)+Math.pow(lon,2));
    }

    /**
     * Distância entre duas ERBs
     * @param a ERB a
     * @param b ERB b
     * @return
     */
    public double calcular(ERB a, ERB b){
        double lat = Math.abs(a.getLatitude()-b.getLatitude());
        double lon = Math.abs(a.getLongitude()-b.getLongitude());

        return Math.sqrt(Math.pow(lat,2)+Math.pow(lon,2));
    }

    /**
     * Distância entre um usuário e um balão
     * @param a usuário
     * @param b balão
     * @return distância
     */
    public double calcular(Usuario a, Balao b){
        double lat = Math.abs(a.getLatitude()-b.getLatitude());
        double lon = Math.abs(a.getLongitude()-b.getLongitude());

        return Math.sqrt(Math.pow(lat,2)+Math.pow(lon,2));
    }
}
