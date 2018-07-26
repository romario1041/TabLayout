package dh.example.viewpager.exemploviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class FragmentPageAdapter extends FragmentStatePagerAdapter {

    List<Fragment> lista;
    List<String> listFragmentsTitle;


    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
        //NOVO
        //Explicação abaixo, no método "add"
        lista = new ArrayList<>();
        listFragmentsTitle = new ArrayList<>();
    }


    //NOVO - BONUS
    /*
    * Método Add (abaixo), nos permite adicionar os elementos em uma lista direto pela classe Adapter
    * não sendo necessário criar uma nova lista na MainActivity e depois passa-la para uma lista do Adapter
    * Isso nos ajuda a economizar memória e objetos instanciados sem necessidade ;-)
    * */
    public void add(Fragment frag, String title){
        this.lista.add(frag);
        this.listFragmentsTitle.add(title);
    }

    @Override
    public Fragment getItem(int i) {
        return lista.get(i);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    //NOVO
    /*
    * Método getPageTitle(abaixo)
    * Veja que diferente do ViewPager, não estamos rolando apenas a fragment, mas também o TabLayout.
    * Sendo assim, é necessário criar um "getPosition" também para o título que fica no TabLayout
    * */
    @Override
    public CharSequence getPageTitle(int position){
        return listFragmentsTitle.get(position);
    }
}
