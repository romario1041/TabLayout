package dh.example.viewpager.exemploviewpager;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //PRIMEIRA ETAPA:
        //Criamos uma instancia do Adapter "FragmentPageAdapter"
        FragmentPageAdapter adapter = new FragmentPageAdapter(getSupportFragmentManager());

        //SEGUNDA ETAPA:
        // Criamos um objeto Resources, para ter acesso a recursos externos, como a pasta String
        Resources resources = getResources();

        //TERCEIRA ETAPA:
        //3 - Fragment blue criado
        Fragment_blue fb = new Fragment_blue();

        //3.1 - String "titulo1" se responsabilizará de obter a String "frag_one" no arquivo Strings
        String titulo1 = resources.getString(R.string.frag_one);

        /*IMPORTANTE:
         3. 2 - veja que o método que usamos pra inserir o Fragment e titulo no Adapter, é o método "add" que criamos no Adapter
         */
        adapter.add(fb,titulo1);

        //A terceira etapa é repetida para todos os fragments que você deseja exibir:
        Fragment_green fg = new Fragment_green();
        String titulo2 = resources.getString(R.string.frag_two);
        adapter.add(fg, titulo2);

        Fragment_red fr = new Fragment_red();
        String titulo3 = resources.getString(R.string.frag_three);
        adapter.add(fr,titulo3);

        Fragment_darkBlue db = new Fragment_darkBlue();
        String titulo4 = resources.getString(R.string.frag_four);
        adapter.add(db,titulo4);



        //QUARTA ETAPA: FINAL

        //Após criar os Fragments e inseri-los no adapter, crie o ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        //Insira o adapter no ViewPager
        viewPager.setAdapter(adapter);

        //BONUS: viewPager.setClipToPadding(false); >> Esse código fornece aquele tóque estético para o ViewPager
        viewPager.setClipToPadding(false);

        //Após criar o ViewPager e inserir seu Adapter, crie o TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        //Insira o ViewPager que já contém o Adapter no TabLayout ;-)
        tabLayout.setupWithViewPager(viewPager);


    }
}
