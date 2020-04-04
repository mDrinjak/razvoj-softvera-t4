package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Artikal {

    private String sifra;
    private String naziv;
    private double cijena;

    public Artikal(String artikal) {
        String[] a = artikal.split(",");
        this.sifra=a[0];
        this.naziv=a[1];
        this.cijena=Double.parseDouble(a[2]);
    }

    public static void izbaciDuplikate(ArrayList<Artikal> artikli) {
       ArrayList<Artikal> pomLista = new ArrayList<>();
       pomLista.add(artikli.get(0));
       for(int i=1; i<artikli.size(); i++){
           boolean ponavljaSe=false;
           for(int j=0; j<pomLista.size(); j++){
               if(artikli.get(i).toString().equals(pomLista.get(j).toString()))
                   ponavljaSe=true;
           }
           if(!ponavljaSe)
               pomLista.add(artikli.get(i));
       }
        artikli.clear();
        artikli.addAll(pomLista);

    }


    public Artikal(String sifra, String artikal, double cijena) {

        this.sifra =sifra;
        this.naziv = artikal;
        this.cijena = cijena;
        if(sifra.isEmpty()) throw new IllegalArgumentException("Naziv je prazan");
        if(artikal.isEmpty()) throw new IllegalArgumentException("naziv je prazan");
        if(cijena<0) throw new IllegalArgumentException("Cijena je negativna");
    }


    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if(sifra.isEmpty()){
            throw new IllegalArgumentException("Šifra je prazna");
        }
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv.isEmpty()){
            throw new IllegalArgumentException("Naziv je prazan");
        }
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if (cijena < 0) {
            throw new IllegalArgumentException("Cijena je negativna");
        }
        this.cijena = cijena;
    }
    @Override
    public String toString() {
        return sifra+", "+naziv+", "+cijena;
    }
     public boolean equals(Artikal o){
         return this.getCijena() == o.getCijena() && this.getSifra() == o.getSifra() && this.getNaziv() == o.getNaziv();
     }
}
