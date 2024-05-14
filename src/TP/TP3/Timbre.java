package TP.TP3;

import TP.utils.utils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Timbre {
    @JsonProperty("valeur")
    private Float m_valeur;

    @JsonProperty("devise_valeur")
    private String m_deviseValeur;

    @JsonProperty("filet")
    private Boolean m_filet;

    @JsonProperty("dentelure")
    private String m_dentelure;

    @JsonProperty("pays_orig")
    private String m_paysOrig;

    @JsonProperty("oeuvre")
    private String m_oeuvre;

    @JsonProperty("designation")
    private String m_designation;

    @JsonProperty("signature_dessinateur")
    private String m_signatureDessinateur;

    @JsonProperty("signature_graveur")
    private String m_signatureGraveur;

    private Timbre(float valeur, String deviseValeur, boolean filet, String dentelure, String paysOrig, String oeuvre, String designation, String signatureDessinateur, String signatureGraveur) {
        m_valeur = valeur;
        m_deviseValeur = deviseValeur;
        m_filet = filet;
        m_dentelure = dentelure;
        m_paysOrig = paysOrig;
        m_oeuvre = oeuvre;
        m_designation = designation;
        m_signatureDessinateur = signatureDessinateur;
        m_signatureGraveur = signatureGraveur;
    }

    private Timbre() {}

    public static Timbre newTimbre() {
        return new Timbre(5.0f, "Fr", true, "Crénelé", "France", "img/gravure-mont-saint-michel.png", "Mont Saint Michel", "F. Bivel", "A. Mignon");
    }

    public static void main(String[] args){

        Timbre timbreTest = newTimbre();
        utils.writeFile("test.json", utils.jsonStringify(timbreTest.toJson()), false);

        ObjectNode obj = utils.readJSONFile("test.json");
        String jsonStringify = utils.jsonStringify(obj);

        if (!jsonStringify.isEmpty()) {
            System.out.println("jsonStringify:\n");
            System.out.println(jsonStringify);
        }

        Timbre timbre = Timbre.fromJson(obj);
        if (timbre != null) {
            System.out.println(timbre);
        } else {
            System.out.println("Timbre null");
        }

        ArrayList<Timbre> timbres = new ArrayList<>(List.of(new Timbre[]{timbre, timbre, timbre, timbre, timbre, timbre, timbre}));

        ArrayList<ObjectNode> ObjNodeArr = new ArrayList<>();
        for (Timbre t : timbres) {
            if (t != null) ObjNodeArr.add(t.toJson());
        }

        ArrayNode objArray = utils.toJsonArray(ObjNodeArr);
        if (objArray == null) return;

        System.out.println("objArray:\n");
        System.out.println(utils.jsonStringify(objArray));

        utils.writeFile("test.json", utils.jsonStringify(objArray), false);

        ArrayNode jsonArray = utils.readJSONArrayFile("test.json");
        if (jsonArray == null) return;

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Timbre> timbresFromJson = new ArrayList<>(List.of(mapper.convertValue(jsonArray, Timbre[].class)));

        timbresFromJson.add(timbreTest);

        objArray = utils.toJson(timbresFromJson);

        utils.writeFile("test.json", utils.jsonStringify(objArray), false);
    }

    public Boolean getFilet() {
        return m_filet;
    }

    public Float getValeur() {
        return m_valeur;
    }

    public String getDentelure() {
        return m_dentelure;
    }

    public String getDesignation() {
        return m_designation;
    }

    public String getDeviseValeur() {
        return m_deviseValeur;
    }

    public String getOeuvre() {
        return m_oeuvre;
    }

    public String getPaysOrig() {
        return m_paysOrig;
    }

    public String getSignatureDessinateur() {
        return m_signatureDessinateur;
    }

    public String getSignatureGraveur() {
        return m_signatureGraveur;
    }

    public ObjectNode toJson() {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode obj = mapper.createObjectNode();
        obj.put("valeur", m_valeur);
        obj.put("devise_valeur", m_deviseValeur);
        obj.put("filet", m_filet);
        obj.put("dentelure", m_dentelure);
        obj.put("pays_orig", m_paysOrig);
        obj.put("oeuvre", m_oeuvre);
        obj.put("designation", m_designation);
        obj.put("signature_dessinateur", m_signatureDessinateur);
        obj.put("signature_graveur", m_signatureGraveur);

        return obj;
    }

    public static @Nullable Timbre fromJson(ObjectNode json) {
        ObjectMapper mapper = new ObjectMapper();
        Timbre timbre;
        try {
            timbre = mapper.convertValue(json, Timbre.class);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
        return timbre;
    }

    public static Timbre @Nullable [] fromJsonArray(ObjectNode json) {
        ObjectMapper mapper = new ObjectMapper();
        Timbre[] timbres;
        try {
            timbres = mapper.convertValue(json, Timbre[].class);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
        return timbres;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("*****************************************************************\n");
        sb.append("valeur :\t\t\t\t\t").append(m_valeur).append('\n');
        sb.append("devise :\t\t\t\t\t").append(m_deviseValeur).append('\n');
        sb.append("filet :\t\t\t\t\t\t").append(m_filet).append('\n');
        sb.append("dentelure :\t\t\t\t\t").append(m_dentelure).append('\n');
        sb.append("pays d'origine :\t\t\t").append(m_paysOrig).append('\n');
        sb.append("oeuvre :\t\t\t\t\t").append(m_oeuvre).append('\n');
        sb.append("designation :\t\t\t\t").append(m_designation).append('\n');
        sb.append("signature du dessinateur :\t").append(m_signatureDessinateur).append('\n');
        sb.append("signature du graveur :\t\t").append(m_signatureGraveur).append('\n');
        sb.append("*****************************************************************\n");
        return sb.toString();
    }
}
