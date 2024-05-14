package TP.TP3;

import TP.utils.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class CollectionTimbre implements Iterable<Timbre>, Comparator<Timbre> {

    ArrayList<Timbre> m_timbres;
    private Field m_sortingBy = Field.VALEUR;

    private CollectionTimbre(ArrayList<Timbre> timbres) {
        m_timbres = timbres;
    }

    public static CollectionTimbre newCollectionTimbre(String filename) {
        return new CollectionTimbre(CollectionTimbre.fromJson(filename));
    }

    public static void main(String[] args) {
        CollectionTimbre myCollection = newCollectionTimbre("test.json");
        myCollection.sortBy("valeur", false);
        utils.writeFile("test.json", utils.jsonStringify(utils.toJson(myCollection.m_timbres)), false);
    }

    private static @Nullable ArrayList<Timbre> fromJson(String filename) {

        ArrayNode jsonArray = utils.readJSONArrayFile(filename);
        if (jsonArray == null) return null;

        ObjectMapper mapper = new ObjectMapper();
        return new ArrayList<>(List.of(mapper.convertValue(jsonArray, Timbre[].class)));
    }

    public CollectionTimbre add(Timbre timbre) {
        this.m_timbres.add(timbre);
        return this;
    }

    public Timbre select(int index) {
        if (index < 0 || index >= m_timbres.size()) return null;
        return m_timbres.get(index);
    }

    public CollectionTimbre remove(int index) {
        if (index < 0 || index >= m_timbres.size()) return null;
        this.m_timbres.remove(index);
        return this;
    }

    public void sortBy(@NotNull String field) {
        this.sortBy(field, true);
    }

    public void sortBy(@NotNull String field, boolean isAscendingOrder) {
        switch (field.toLowerCase().trim()) {
            case "valeur":
                this.sortTimbresBy(Field.VALEUR, isAscendingOrder);
                break;
            case "devise_valeur", "devisevaleur", "devise":
                this.sortTimbresBy(Field.DEVISE_VALEUR, isAscendingOrder);
                break;
            case "filet":
                this.sortTimbresBy(Field.FILET, isAscendingOrder);
                break;
            case "dentelure":
                this.sortTimbresBy(Field.DENTELURE, isAscendingOrder);
                break;
            case "pays_orig", "pays_origine", "paysorig", "paysorigine", "pays":
                this.sortTimbresBy(Field.PAYS_ORIGINE, isAscendingOrder);
                break;
            case "oeuvre":
                this.sortTimbresBy(Field.OEUVRE, isAscendingOrder);
                break;
            case "designation":
                this.sortTimbresBy(Field.DESIGNATION, isAscendingOrder);
                break;
            case "signature_dessinateur", "signaturedessinateur", "dessinateur":
                this.sortTimbresBy(Field.SIGNATURE_DESSINATEUR, isAscendingOrder);
                break;
            case "signature_graveur", "signaturegraveur", "graveur":
                this.sortTimbresBy(Field.SIGNATURE_GRAVEUR, isAscendingOrder);
                break;
            default:
        }
    }

    private void sortTimbresBy(Field sortingBy, boolean ascendingOrder) {
        setSortingBy(sortingBy);
        if (!ascendingOrder) {
            m_timbres.sort(this.reversed());
        } else {
            m_timbres.sort(this);
        }
    }

    @Override
    public int compare(Timbre timbre1, Timbre timbre2) {
        return switch (m_sortingBy) {
            case VALEUR -> timbre1.getValeur().compareTo(timbre2.getValeur());
            case DEVISE_VALEUR -> timbre1.getDeviseValeur().compareTo(timbre2.getDeviseValeur());
            case FILET -> timbre1.getFilet().compareTo(timbre2.getFilet());
            case DENTELURE -> timbre1.getDentelure().compareTo(timbre2.getDentelure());
            case PAYS_ORIGINE -> timbre1.getPaysOrig().compareTo(timbre2.getPaysOrig());
            case OEUVRE -> timbre1.getOeuvre().compareTo(timbre2.getOeuvre());
            case DESIGNATION -> timbre1.getDesignation().compareTo(timbre2.getDesignation());
            case SIGNATURE_DESSINATEUR -> timbre1.getSignatureDessinateur().compareTo(timbre2.getSignatureDessinateur());
            case SIGNATURE_GRAVEUR -> timbre1.getSignatureGraveur().compareTo(timbre2.getSignatureGraveur());
        };
    }

    void setSortingBy(Field sortingBy) {
        this.m_sortingBy = sortingBy;
    }

    enum Field {
        VALEUR,
        DEVISE_VALEUR,
        FILET,
        DENTELURE,
        PAYS_ORIGINE,
        OEUVRE,
        DESIGNATION,
        SIGNATURE_DESSINATEUR,
        SIGNATURE_GRAVEUR
    }

    /**
     * Implementing Iterable
     */
    @Override
    public @NotNull Iterator<Timbre> iterator() {

        return new Iterator<>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < m_timbres.size() && m_timbres.get(currentIndex) != null;
            }

            @Override
            public Timbre next() {
                return m_timbres.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
