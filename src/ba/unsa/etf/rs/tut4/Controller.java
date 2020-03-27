package ba.unsa.etf.rs.tut4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static ba.unsa.etf.rs.tut4.Artikal.izbaciDuplikate;

public class Controller implements Initializable {


    public ChoiceBox<Artikal> artikalChoiceBox;
    private ObservableList<Artikal> artikli = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        artikalChoiceBox.setItems(artikli);
    }

    public TextArea ulaz;
    public TextArea izlaz;

    public void DodajArtikle(javafx.event.ActionEvent actionEvent) {
        String[] art = ulaz.getText().split("\n");
        StringBuilder dodaniArt= new StringBuilder();
        ArrayList<Artikal> lista = new ArrayList<Artikal>();
        for(String a: art){
            Artikal artikal=new Artikal(a);
            artikli.add(artikal);
            dodaniArt.append("\n").append(a);
        }
        lista.addAll(artikli);
        ObservableList<Artikal> rez=izbaciDuplikate(lista);

        artikli= rez;
        izlaz.setText(dodaniArt.toString());
    }
/*
NEKI POKUSAJ DA IZVEDEM 4. ZADATAK

    public TextArea racun;
    public Spinner<Integer> spinner;

    public void Dodaj(javafx.event.ActionEvent actionEvent){
       Artikal trenutniArtikal= artikalChoiceBox.getValue();
       Integer kolicina=spinner.getValue();


    }
*/
}
