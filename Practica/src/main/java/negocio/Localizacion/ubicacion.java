package negocio.Localizacion;

public class ubicacion {
	private String coordenadas;

	public boolean gps() {
		// TODO Auto-generated method stub
		GPS gps = new GPS();
		if (gps.on()==true){
			coordenadas="Ubicado";
			return true;
		}
		return false;
	}

	public String getCoordenadas() {
		// TODO Auto-generated method stub
		return coordenadas;
	}

	public String getMensaje() {
		// TODO Auto-generated method stub
		return "Active el GPS";
	}

}
