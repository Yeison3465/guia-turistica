/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import modelo.Clima;
import modelo.Sitio;
import org.json.JSONObject;
import java.util.concurrent.ThreadLocalRandom;

@ManagedBean
@SessionScoped
public class ClimaControl {

    Clima clima = new Clima();
    private List<Sitio> sitiosRecomendados = new ArrayList<>();
    List<Sitio> guiaGenerada = new ArrayList<>();

    public List<Sitio> getGuiaGenerada() {
        return guiaGenerada;
    }

    public void setGuiaGenerada(List<Sitio> guiaGenerada) {
        this.guiaGenerada = guiaGenerada;
    }

    public Sitio getSiti() {
        return siti;
    }

    public void setSiti(Sitio siti) {
        this.siti = siti;
    }
    Sitio siti = new Sitio();
    @ManagedProperty("#{turistaControl1}")
    private TuristaControl1 control;

    public TuristaControl1 getControl() {
        return control;
    }

    public void setControl(TuristaControl1 control) {
        this.control = control;
    }

    @PostConstruct
    public void init() {
        climaEstado();
    }

    public void climaEstado() {
        String apiKey = "c905993ff7603b0a22a5e93aecaa99a8";
        String ciudad = "Cartagena";
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&appid=" + apiKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            JSONObject json = new JSONObject(response.toString());

            if (json.has("weather") && json.getJSONArray("weather").length() > 0) {
                String descripcionClima = json.getJSONArray("weather").getJSONObject(0).getString("description");
                double temperaturaCelsius = json.getJSONObject("main").getDouble("temp") - 273.15;

                System.out.println("Descripción del clima: " + descripcionClima);
                System.out.println("Temperatura Celsius: " + temperaturaCelsius);

                clima.setDescripcionClima(descripcionClima);
                clima.setTemperaturaCelsius(Math.round(temperaturaCelsius)); // Redondear la temperatura

                // Resto del código necesario para tu lógica
            } else {
                System.out.println("No se encontraron datos del clima.");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos del clima: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void guia2() {
        float randomFloat = ThreadLocalRandom.current().nextInt(300, 381) / 10.0f;
        randomFloat = (float) Math.floor(randomFloat) * 1.0f;
        float randomFloat2 = ThreadLocalRandom.current().nextInt(301, 370) / 10.0f;
        randomFloat2 = (float) Math.floor(randomFloat2) * 1.0f;
        float randomFloat3 = ThreadLocalRandom.current().nextInt(300, 380) / 10.0f;
        randomFloat3 = (float) Math.floor(randomFloat3) * 1.0f;
        float randomFloat4 = ThreadLocalRandom.current().nextInt(290, 351) / 10.0f;
        randomFloat4 = (float) Math.floor(randomFloat4) * 1.0f;

        sitiosRecomendados = new ArrayList();
        Sitio Bocagrande = new Sitio("Mall Plaza", " Dirección: Av. Pedro De Heredia #Carrera 13, Playon Del Blanco, Cartagena de Indias, Provincia de Cartagena, Bolívar", "10:00 AM ", "9:00 PM", randomFloat2, "imagenes/m2.jpg");
        Sitio psc = new Sitio("Paseo de la castellana", " Cl. 30 #30-31, El Rubí, Cartagena de Indias, Provincia de Cartagena, Bolívar", "7:00 AM ", "10:00 PM", randomFloat2, "imagenes/d.jpg");
        Sitio pb = new Sitio("Plaza Bocagrande", "Cra. 1 #12-118, Cartagena de Indias, Provincia de Cartagena, Bolívar", "7:00 AM", "10:00 PM", 20.0, "imagenes/h.jpg");
        Sitio sr = new Sitio("Serrezuela", " Cl. 25 #68c-50, San Diego, Bogotá, Cartagena de Indias, Provincia de Cartagena, Bolívar", "10:00 AM ", "9:00 PM", randomFloat2, "imagenes/i9.jpg");
        Sitio bq = new Sitio("Playa la Boquilla", " La Boquilla, Provincia de Cartagena, Bolívar", "Todo el Dia", "Todo el Dia", randomFloat, "imagenes/boquilla.jpg");
        Sitio plb = new Sitio("Playas de Bocagrandre", " Cra. 1 #1A-23, Cartagena de Indias, Provincia de Cartagena, Bolívar", "Todo el dia ", "Todo el dia", randomFloat, "imagenes/boca.jpg");
        Sitio plc = new Sitio("Playas de Castillo Grande", " Castillogrande, Cartagena de Indias, Provincia de Cartagena, Bolívar", "Todo el Dia", "Todo el Dia", randomFloat, "imagenes/j.jpg");
        Sitio mso = new Sitio("Museo Naval del caribe", " Cl. 31 #3-26, El Centro, Cartagena de Indias, Provincia de Cartagena, Bolívar", "10:00 AM ", "6:00 PM", randomFloat3, "imagenes/m5.jpg");
        Sitio Bod = new Sitio("Bovedas", " San Diego, San Diego, Cartagena de Indias, Provincia de Cartagena, Bolívar para visitar todo el dia para comprar esta", "8:50 AM", "7:00 PM", randomFloat4, "imagenes/l2.jpg");
        Sitio ptal = new Sitio("Portal de los dulce", "Cra. 7, El Centro, Cartagena de Indias, Provincia de Cartagena, Bolívar - Para visitar todo el dia - Para comprar", "10:50 AM ", "5:00 PM", randomFloat4, "imagenes/p5.jpg");
        Sitio mid = new Sitio("Monumento India Catalina", " Av. Venezuela, La Matuna, Cartagena de Indias, Provincia de Cartagena, Bolívar", "7:00 AM ", "10:00 PM", randomFloat4, "imagenes/m3.jpg");
        Sitio cp = new Sitio("Caribe Plaza", " Cl. 29d #22-108, Pie de la Popa, Cartagena de Indias, Provincia de Cartagena, Bolívar", "9:00 AM ", "10:00 PM", randomFloat4, "imagenes/cari.jpg");
        Sitio cr = new Sitio("Casa de Rafael Nuñez", " Cra. 2 #41-89, Barrio El Cabrero, Cartagena de Indias, Provincia de Cartagena, Bolívar", "martes a viernes: 9:00AM \n Sabado y Domingo: 10:00AM", "martes a viernes:5:00 p.m \n 4:00PM", randomFloat, "imagenes/n.jpg");
        Sitio mr = new Sitio("Murallas", " Cl. de la Serrezuela, San Diego, Cartagena de Indias, Provincia de Cartagena, Bolívar", "todo el dia", "todo el dia", randomFloat, "imagenes/mura.jpg");
        Sitio cf = new Sitio("Castillo De San Felipe", " Barrio Pie del Cerro, Avenida Antonio de Arévalo. Carrera 17., Cl. 32 #17-85, Cartagena de Indias, Provincia de Cartagena, Bolívar Lunes a Domingo", "7:00 AM ", "6:00 PM", randomFloat3, "imagenes/c.jpeg");
        Sitio cc = new Sitio("Centro de Convenciones", " Cl. 24 #8A-344, Getsemaní, Cartagena de Indias, Provincia de Cartagena, Bolívar Lunes a Viernes", "8:00 AM ", "6:00 PM", randomFloat3, "imagenes/p.png");
        Sitio ch = new Sitio("Centro Historico", " Cra. 7 #32-41, El Centro, Cartagena de Indias, Provincia de Cartagena, Bolívar", "todo el dia ", "todoe el dia", randomFloat3, "imagenes/y.png");
        Sitio rp = new Sitio("Relog Publico", " Boca del Puente, El Centro, Cartagena de Indias, Provincia de Cartagena, Bolívar", "Todo el dia ", "Todo el dia", randomFloat4, "imagenes/i4.jpg");
        Sitio Bg = new Sitio("Barrio Getsemaní", " Cra9No39-12, San Diego, Cartagena de Indias, Provincia de Cartagena, Bolívar", "Todo el dia ", "Todo el dia", randomFloat4, "imagenes/i.jpg");
        Sitio pB = new Sitio("Parque bolivar", " El Centro, Cartagena de Indias, Provincia de Cartagena, Bolívar", "Todo el dia ", "Todo el dia", randomFloat3, "imagenes/p2.jpg");
        Sitio plz = new Sitio("Plaza santo domingo", " Cl. 35, El Centro, Cartagena de Indias, Provincia de Cartagena, Bolívar", "Todo el dia ", "Todo el dia", randomFloat3, "imagenes/plaza2.jpg");
        Sitio ct = new Sitio("Parque Centenario", " Dirección: Media, Getsemaní, Cartagena de Indias, Provincia de Cartagena, Bolívar", "7:00 AM ", "10:00 PM", randomFloat3, "imagenes/cete.jpeg");
        sitiosRecomendados.add(Bocagrande);
        sitiosRecomendados.add(psc);
        sitiosRecomendados.add(pb);
        sitiosRecomendados.add(sr);
        sitiosRecomendados.add(plb);
        sitiosRecomendados.add(bq);
        sitiosRecomendados.add(plc);
        sitiosRecomendados.add(mso);
        sitiosRecomendados.add(Bod);
        sitiosRecomendados.add(ptal);
        sitiosRecomendados.add(mid);
        sitiosRecomendados.add(cp);
        sitiosRecomendados.add(cr);
        sitiosRecomendados.add(mr);
        sitiosRecomendados.add(cf);
        sitiosRecomendados.add(cc);
        sitiosRecomendados.add(ch);
        sitiosRecomendados.add(rp);
        sitiosRecomendados.add(Bg);
        sitiosRecomendados.add(pB);
        sitiosRecomendados.add(plz);
        sitiosRecomendados.add(ct);
        System.out.println("GOOD");
        control.guias();
        for (Sitio sitio : sitiosRecomendados) {
            // Aquí puedes realizar operaciones con cada elemento 'sitio' en la lista
            System.out.println("Nombre del sitio: " + sitio.getNombre());
            System.out.println("Descripción: " + sitio.getDescripcion());
            System.out.println("temperatura: " + sitio.getTemperatura());

        }
    }

    public void guia3() {
     
        if (clima.getTemperaturaCelsius() >= 31 && clima.getTemperaturaCelsius() <= 36) {
            for (Sitio sitio : sitiosRecomendados) {
                if (sitio.getTemperatura() >= 31 && sitio.getTemperatura() <= 36) {
                    guiaGenerada.add(sitio);

                }
            }
        } else if (clima.getTemperaturaCelsius() >= 20 && clima.getTemperaturaCelsius() <= 35) {
            for (Sitio sitio : sitiosRecomendados) {
                if (sitio.getTemperatura() > 20 && sitio.getTemperatura() <= 35) {
                    guiaGenerada.add(sitio);

                }
            }

        } else if (clima.getTemperaturaCelsius() >=26 && clima.getTemperaturaCelsius() <= 35) {
            for (Sitio sitio : sitiosRecomendados) {
                if (sitio.getTemperatura() > 26 && sitio.getTemperatura() <= 35) {
                    guiaGenerada.add(sitio);

                }
            }
        }

    }

    public void vaciar() {
        guiaGenerada.clear();
        guia2();
    }

    public List<Sitio> getSitiosRecomendados() {
        return sitiosRecomendados;
    }

    public Clima getClima() {
        return clima;
    }

    public void setClima(Clima clima) {
        this.clima = clima;
    }
}
