package views;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import objects.Serie;
import service.ConnectionDB;


@ManagedBean
@ViewScoped

public class ViewSeries {
private int cve;
private List<Serie> seriesList;
private Serie serie;
private ConnectionDB conDB = new ConnectionDB();;


@PostConstruct
public void init(){
	System.out.println("Post Construct");
	seriesList = conDB.cargaSeries();
}

public void buscaSeries() {
	seriesList = conDB.buscaSerie(cve);
}
public void hola(Serie s) {
	System.out.println(s);
	
}





//Getters and Setters
public int getCve() {
	return cve;
}

public void setCve(int cve) {
	this.cve = cve;
}





public List<Serie> getSeriesList() {
	return seriesList;
}





public void setSeriesList(List<Serie> seriesList) {
	this.seriesList = seriesList;
}





public Serie getSerie() {
	return serie;
}





public void setSerie(Serie serie) {
	this.serie = serie;
}
}
