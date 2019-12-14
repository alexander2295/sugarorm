package facci.pm.gomezcarlos.sugarorm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button btn_guardar, btn_modificar, btn_eliminar, btn_consultaindividual;
    EditText edit_primero, edit_segundo, edit_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        edit_primero = findViewById(R.id.edit_primero);
        edit_segundo = findViewById(R.id.edit_segundo);
        edit_id = findViewById(R.id.edit_id);

        btn_guardar = findViewById(R.id.btn_guardar);
        btn_modificar = findViewById(R.id.btn_modificar);
        btn_eliminar = findViewById(R.id.btn_eliminar);
        btn_consultaindividual = findViewById(R.id.btn_consultaindividual);

        btn_consultaindividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = Book.findById(Book.class, Long.parseLong(edit_id.getText().toString()));
                edit_primero.setText(book.getTitle());
                edit_segundo.setText(book.getEdition());
            }
        });

        btn_guardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
              Book registro = new Book(
                      edit_primero.getText().toString(),
                      edit_segundo.getText().toString());
                registro.save();
                Log.e("Guardar", "Datos Guardados!");
            }
        });

        btn_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = Book.findById(Book.class, Long.parseLong(edit_id.getText().toString()));
                book.title = edit_primero.getText().toString();
                book.edition = edit_segundo.getText().toString();
                book.save();
            }
        });

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = Book.findById(Book.class, Long.parseLong(edit_id.getText().toString()));
                book.title = edit_primero.getText().toString();
                book.edition = edit_segundo.getText().toString();
                book.delete();
            }
        });

        /*Book registro = new Book("Harry Potter", "Primera");
        registro.save();
        Log.e("Guardar", "Datos Guardados!");*/
    }
}
