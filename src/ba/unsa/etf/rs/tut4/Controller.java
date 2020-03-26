package ba.unsa.etf.rs.tut4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

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
    public void Dodaj(javafx.event.ActionEvent actionEvent) {
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
        System.out.println(rez);
        artikli= rez;
        izlaz.setText(dodaniArt.toString());
    }

}
