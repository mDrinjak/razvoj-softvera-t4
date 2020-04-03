package ba.unsa.etf.rs.tut4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public ChoiceBox<Artikal> artikalChoiceBox;
    private ObservableList<Artikal> artikli = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        artikalChoiceBox.setItems(artikli);
    }

    public TextArea ulaz;
    public TextArea izlaz;

    public void DodajArtikle(ActionEvent actionEvent) {
        String[] art = ulaz.getText().split("\n");
        StringBuilder dodaniArt= new StringBuilder();
        ArrayList<Artikal> lista = new ArrayList<Artikal>();
        for(String a: art){
            Artikal artikal=new Artikal(a);
            artikli.add(artikal);

        }
        lista.addAll(artikli);
        artikli.clear();
        Artikal.izbaciDuplikate(lista);
        artikli.addAll(lista);
        for(Artikal x: artikli){
            dodaniArt.append(x.toString());
        }
        izlaz.setText(dodaniArt.toString());
    }


}
