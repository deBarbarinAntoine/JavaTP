package TP.TP3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Timbre {
    float m_valeur;
    String m_deviseValeur;
    boolean m_filet;
    String m_dentelure;
    String m_paysOrig;
    String m_oeuvre;
    String m_designation;
    String m_signatureDessinateur;
    String m_signatureGraveur;

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

    public static Timbre newTimbre() {
        return new Timbre(5.0f, "Fr", true, "Crénelé", "France", "img/gravure-mont-saint-michel.png", "Mont Saint Michel", "F. Bivel", "A. Mignon");
    }

    public static void main(String[] args) throws JsonProcessingException {
        Timbre timbreTest = newTimbre();
        System.out.println(timbreTest.toJson());
    }

    public String toJson() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode obj = mapper.createObjectNode();
        obj.put("valeur", m_valeur);
        obj.put("deviseValeur", m_deviseValeur);
        obj.put("filet", m_filet);
        obj.put("dentelure", m_dentelure);
        obj.put("paysOrig", m_paysOrig);
        obj.put("oeuvre", m_oeuvre);
        obj.put("designation", m_designation);
        obj.put("signatureDessinateur", m_signatureDessinateur);
        obj.put("signatureGraveur", m_signatureGraveur);

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }
}
