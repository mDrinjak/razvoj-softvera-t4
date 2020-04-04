package ba.unsa.etf.rs.tut4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.service.query.NodeQuery;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(ApplicationExtension.class)
class ControllerTest {
    @Start
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        stage.setTitle("Racun");
        stage.setScene(new Scene(root, 522, 474));
        stage.show();
        stage.setResizable(false);
        stage.toFront();
    }
    @Test
    //Test posoje li tabovi
    void Tabovi(FxRobot robot){
        NodeQuery tab1 = robot.lookup("#TabArtikli");
        assertNotNull(tab1);
        NodeQuery tab2 = robot.lookup("#TabRacun");
        assertNotNull(tab2);

    }
    @Test
    //Test postoje li svi elementi na tabu "Artikli"
    void elementiTaba1(FxRobot robot){
        Button btnDodajArt = robot.lookup("#btnDodaj1").queryAs(Button.class);
        assertNotNull(btnDodajArt);
        TextArea fldUlaz= robot.lookup("#ulaz").queryAs(TextArea.class);
        assertNotNull(fldUlaz);
        TextArea fldIzlaz= robot.lookup("#izlaz").queryAs(TextArea.class);
        assertNotNull(fldIzlaz);

    }
    @Test
    //Postoje li svi elementi na tabu "Racun"
    void elementiTaba2(FxRobot robot){
        Button btnDodaj2 = robot.lookup("#btnDodaj2").queryAs(Button.class);
        assertNotNull(btnDodaj2);
        Label labelaArtikl = robot.lookup("#labela1").queryAs(Label.class);
        assertNotNull(labelaArtikl);
        Label labelaKlicina = robot.lookup("#labela2").queryAs(Label.class);
        assertNotNull(labelaKlicina);
        Label labelaAktuelniRacun = robot.lookup("#labela3").queryAs(Label.class);
        assertNotNull(labelaAktuelniRacun);
        NodeQuery CBox = robot.lookup("artikalChoiceBox");
        assertNotNull(CBox);
        NodeQuery SpinnerKol = robot.lookup("spinner");
        assertNotNull(SpinnerKol);
        TextArea fldRacun= robot.lookup("#racun").queryAs(TextArea.class);
        assertNotNull(fldRacun);
    }
    @Test
    //Piritisnuto dugme
    void DodajArtikle1(FxRobot robot){
        robot.clickOn("#ulaz");
        robot.write("HLB002,Hljeb,1.3\nMLK010,Mlijeko,2.5");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        robot.clickOn("#btnDodaj1");
        TextArea Dodani = robot.lookup("#izlaz").queryAs(TextArea.class);
        assertEquals("HLB002, Hljeb, 1.3\nMLK010, Mlijeko, 2.5\n",Dodani.getText());
        ObservableList<Artikal> listaArtikala= FXCollections.observableArrayList();
        listaArtikala.add(0, new Artikal("HLB002", "Hljeb", 1.3));
        listaArtikala.add(1, new Artikal("MLK010", "Mlijeko", 2.5));
        ChoiceBox CBox=robot.lookup("#artikalChoiceBox").queryAs(ChoiceBox.class);
        if(CBox.getItems().get(0)==listaArtikala.get(0)) assert true;
        if(CBox.getItems().get(1)==listaArtikala.get(1)) assert true;

    }
    @Test
    //Ponavljanje artikala
    void DodajArtikle2(FxRobot robot){
        robot.clickOn("#ulaz");
        robot.write("HLB002,Hljeb,1.3\nMLK010,Mlijeko,2.5\nMLK010,Mlijeko,2.5");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        robot.clickOn("#btnDodaj1");
        TextArea Dodani = robot.lookup("#izlaz").queryAs(TextArea.class);
        assertEquals("HLB002, Hljeb, 1.3\nMLK010, Mlijeko, 2.5\n",Dodani.getText());
        ObservableList<Artikal> listaArtikala= FXCollections.observableArrayList();
        listaArtikala.add(0, new Artikal("HLB002", "Hljeb", 1.3));
        listaArtikala.add(1, new Artikal("MLK010", "Mlijeko", 2.5));
        ChoiceBox CBox=robot.lookup("#artikalChoiceBox").queryAs(ChoiceBox.class);
        if(CBox.getItems().get(0)==listaArtikala.get(0)) assert true;
        if(CBox.getItems().get(1)==listaArtikala.get(1)) assert true;

    }
    @Test
    //Vise puta pritisnuto dugme
    void DodajArtikle3(FxRobot robot){
        robot.clickOn("#ulaz");
        robot.write("HLB002,Hljeb,1.3\nMLK010,Mlijeko,2.5\nMLK010,Mlijeko,2.5");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        robot.clickOn("#btnDodaj1");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        robot.clickOn("#btnDodaj1");

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        robot.clickOn("#btnDodaj1");
        TextArea Dodani = robot.lookup("#izlaz").queryAs(TextArea.class);
        assertEquals("HLB002, Hljeb, 1.3\nMLK010, Mlijeko, 2.5\n",Dodani.getText());
        ObservableList<Artikal> listaArtikala= FXCollections.observableArrayList();
        listaArtikala.add(0, new Artikal("HLB002", "Hljeb", 1.3));
        listaArtikala.add(1, new Artikal("MLK010", "Mlijeko", 2.5));
        ChoiceBox CBox=robot.lookup("#artikalChoiceBox").queryAs(ChoiceBox.class);
        if(CBox.getItems().get(0)==listaArtikala.get(0)) assert true;
        if(CBox.getItems().get(1)==listaArtikala.get(1)) assert true;

    }
}