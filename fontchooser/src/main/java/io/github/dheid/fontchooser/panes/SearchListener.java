package io.github.dheid.fontchooser.panes;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;
import java.util.TreeSet;

public class SearchListener extends KeyAdapter {

    private final Collection<String> fontFamilyNames = new TreeSet<>();

    private final FamilyPane familyPane;

    public SearchListener(FamilyPane familyPane) {
        this.familyPane = familyPane;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField searchField = (JTextField) e.getSource();
        String searchString = searchField.getText().toLowerCase(Locale.ENGLISH);
        String first = getFirstFontFamilyName(searchString);
        if(first != null) {
            familyPane.setSelectedFamily(first);
        }
    }

    private String getFirstFontFamilyName(String searchString) {
        for (String fontFamilyName : fontFamilyNames)  {
            if(fontFamilyName.toLowerCase(Locale.ENGLISH).contains(searchString)) {
                return fontFamilyName;
            }
        }
        return null;
    }

    public void addFamilyName(String name) {
        fontFamilyNames.add(name);
    }
}
