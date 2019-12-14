package facci.pm.gomezcarlos.sugarorm;

import com.orm.SugarRecord;

public class Book extends SugarRecord<Book> {

        //Propiedades
        String title;
        String edition;

        //Constructor
        public Book(){
        }

        //Sobrecarga del constructor
        public Book(String title, String edition){
            this.title = title;
            this.edition = edition;
        }

        //Encapsulamiento de los campos
        public String getTitle(){ return title;}

        public void setTitle(String title) { this.title = title; }

        public String getEdition(){
            return edition;
        }

        public void setEdition(String edition){
            this.edition = edition;
        }
}

