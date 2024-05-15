package TP.TP3.stamps;

import TP.utils.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;


/**
 * The type CollectionTimbre (stamp collection).
 */
public class CollectionTimbre implements Iterable<Timbre>, Comparator<Timbre>, Cloneable {

    private final ArrayList<Timbre> m_timbres;
    private Sort m_sorting = Sort.newSort("valeur", false);

    CollectionTimbre(ArrayList<Timbre> timbres) {
        m_timbres = timbres;
    }

    /**
     * A simple stamp collection factory using a JSON file as source.
     *
     * @param filename the filename
     * @return the stamp collection (collectionTimbre)
     */
    public static CollectionTimbre newCollectionTimbre(String filename) {
        return new CollectionTimbre(CollectionTimbre.fromJson(filename));
    }

    /**
     * The class' entry point (to run an example of the stamp collection class).
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        CollectionTimbre myCollection = newCollectionTimbre("test_stamp_collection.json");
        myCollection.sortBy(Sort.newSort("pays"), Sort.newSort("valeur", false));
        System.out.println(myCollection);
        utils.writeFile("collection_timbres.json", utils.jsonStringify(myCollection.toJson()), false);
    }

    /**
     * Retrieves a list of stamps from a JSON file.
     *
     * @param filename the file from which retrieve the stamps
     * @return a list of stamps
     */
    private static @Nullable ArrayList<Timbre> fromJson(String filename) {

        ArrayNode jsonArray = utils.readJSONArrayFile(filename);
        if (jsonArray == null) return null;

        ObjectMapper mapper = new ObjectMapper();
        return new ArrayList<>(List.of(mapper.convertValue(jsonArray, Timbre[].class)));
    }

    /**
     * Converts a stamp collection to a JSON ArrayNode.
     *
     * @return a JSON ArrayNode
     */
    public ArrayNode toJson() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = mapper.createArrayNode();
        for (Timbre timbre : this) {
            jsonArray.add(timbre.toJson());
        }
        return jsonArray;
    }

    /**
     * Gets the list of stamps.
     *
     * @return the timbres (stamps)
     */
    public ArrayList<Timbre> getTimbres() {
        return m_timbres;
    }

    /**
     * Gets the size of the stamp collection (collectionTimbre).
     *
     * @return the stamp collection's size
     */
    public int size() {
        return m_timbres.size();
    }

    /**
     * Gets a stamp from the stamp collection (collectionTimbre).
     *
     * @param index the index
     * @return the timbre
     */
    public Timbre get(int index) {
        if (index < 0 || index >= m_timbres.size()) return null;
        return m_timbres.get(index);
    }

    /**
     * Add a stamp to the stamp collection (collectionTimbre).
     *
     * @param timbre the stamp (timbre)
     * @return the stamp collection (collectionTimbre)
     */
    public CollectionTimbre add(Timbre timbre) {
        this.m_timbres.add(timbre);
        return this;
    }

    /**
     * Remove a stamp from the stamp collection (collectionTimbre).
     *
     * @param index the index
     * @return the stamp collection (collectionTimbre)
     */
    public CollectionTimbre remove(int index) {
        if (index < 0 || index >= m_timbres.size()) return null;
        this.m_timbres.remove(index);
        return this;
    }

    /**
     * Sort by a list of Sort (field and order).
     *
     * @param sorts the sorts
     */
    public void sortBy( Sort @NotNull ... sorts) {
        for (int i = sorts.length; i > 0 ; --i) {
            Sort current = sorts[i-1];
            this.sortBy(current.getFieldStr(), current.getIsAscendentOrder());
        }
    }

    /**
     * Sort by a field (in ascending order by default).
     *
     * @param fieldStr the field in String type
     */
    public void sortBy(@NotNull String fieldStr) {
        this.sortBy(fieldStr, true);
    }

    /**
     * Sort by.
     *
     * @param fieldStr         the field in String type
     * @param isAscendingOrder the order (true: ascending / false: descending)
     */
    public void sortBy(@NotNull String fieldStr, boolean isAscendingOrder) {
        Sort sort = Sort.newSort(fieldStr, isAscendingOrder);
        if (sort == null) return;
        this.sortTimbresBy(sort);
    }

    private void sortTimbresBy(@NotNull Sort sortingBy) {
        setSorting(sortingBy);
        if (!this.getSorting().getIsAscendentOrder()) {
            m_timbres.sort(this.reversed());
        } else {
            m_timbres.sort(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Timbre timbre : this) {
            sb.append(timbre.toString());
        }
        return sb.toString();
    }

    /**
     * Implementing Clonable
     */
    @Override
    public CollectionTimbre clone() {
        try {
            return (CollectionTimbre) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * Implementing Comparator
     *
     * @param timbre1 the first object to be compared.
     * @param timbre2 the second object to be compared.
     * @return integer positive, negative or null according to the required order.
     */
    @Override
    public int compare(Timbre timbre1, Timbre timbre2) {
        return switch (m_sorting.m_field) {
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

    /**
     * Gets sorting.
     *
     * @return the sorting
     */
    public Sort getSorting() {
        return m_sorting;
    }

    private void setSorting(Sort sortingBy) {
        this.m_sorting = sortingBy;
    }

    private enum Field {
        /**
         * Valeur field.
         */
        VALEUR,
        /**
         * Devise valeur field.
         */
        DEVISE_VALEUR,
        /**
         * Filet field.
         */
        FILET,
        /**
         * Dentelure field.
         */
        DENTELURE,
        /**
         * Pays origine field.
         */
        PAYS_ORIGINE,
        /**
         * Œuvre field.
         */
        OEUVRE,
        /**
         * Designation field.
         */
        DESIGNATION,
        /**
         * Signature dessinateur field.
         */
        SIGNATURE_DESSINATEUR,
        /**
         * Signature graveur field.
         */
        SIGNATURE_GRAVEUR;

        private static Field strToField(@NotNull String fieldStr) throws IllegalArgumentException {
            return switch (fieldStr.toLowerCase().trim()) {
                case "valeur" -> Field.VALEUR;
                case "devise_valeur", "devisevaleur", "devise" -> Field.DEVISE_VALEUR;
                case "filet" -> Field.FILET;
                case "dentelure" -> Field.DENTELURE;
                case "pays_orig", "pays_origine", "paysorig", "paysorigine", "pays" -> Field.PAYS_ORIGINE;
                case "oeuvre" -> Field.OEUVRE;
                case "designation" -> Field.DESIGNATION;
                case "signature_dessinateur", "signaturedessinateur", "dessinateur" -> Field.SIGNATURE_DESSINATEUR;
                case "signature_graveur", "signaturegraveur", "graveur" -> Field.SIGNATURE_GRAVEUR;
                default -> throw new IllegalArgumentException("Unexpected value: " + fieldStr.toLowerCase().trim());
            };
        }
    }

    /**
     * Implementing Iterable
     */
    @Override
    public @NotNull Iterator<Timbre> iterator() {

        return new Iterator<>() {

            private int m_currentIndex = 0;

            @Override
            public boolean hasNext() {
                return m_currentIndex < m_timbres.size() && m_timbres.get(m_currentIndex) != null;
            }

            @Override
            public Timbre next() {
                return m_timbres.get(m_currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    /**
     * The type Sort.
     */
    public static class Sort {
        /**
         * The sorting field.
         */
        Field m_field;
        /**
         * The sorting order (true: ascending order / false: descending order).
         */
        boolean m_isAscendentOrder;

        private Sort(Field field, boolean isAscendentOrder) {
            this.m_field = field;
            this.m_isAscendentOrder = isAscendentOrder;
        }

        private static Sort newSort(Field field, boolean isAscendentOrder) {
            return new Sort(field, isAscendentOrder);
        }

        /**
         * Simple Sort factory.
         *
         * @param fieldStr the field in String type.
         * @return the sort
         */
        public static Sort newSort(String fieldStr) {
            return newSort(fieldStr, true);
        }

        /**
         * Simple Sort factory.
         *
         * @param fieldStr         the field in String type.
         * @param isAscendentOrder the sorting order (true: ascending order / false: descending order).
         * @return the sort
         */
        public static Sort newSort(String fieldStr, boolean isAscendentOrder) {
            Field field;
            try {
                field = Field.strToField(fieldStr);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return null;
            }
            return new Sort(field, isAscendentOrder);
        }

        /**
         * Gets the sorting order (true: ascending order / false: descending order).
         *
         * @return the sorting order
         */
        public boolean getIsAscendentOrder() {
            return m_isAscendentOrder;
        }

        /**
         * Gets field.
         *
         * @return the field
         */
        public Field getField() {
            return m_field;
        }

        /**
         * Gets field in String type.
         *
         * @return the field in String type
         */
        public String getFieldStr() {
            return m_field.toString();
        }
    }
}
