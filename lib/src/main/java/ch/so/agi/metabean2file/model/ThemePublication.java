package ch.so.agi.metabean2file.model;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *  Eine Themenpubliaktion entspricht einer Zeile in der Datensuche 
 */
@JacksonXmlRootElement(localName = "themePublication")
@JsonInclude(Include.NON_NULL)
public class ThemePublication {
    /**
     *  Eindeutiger Identifier, z.B. ch.so.arp.waldreservate
     */
    @NotNull
    private String identifier; 
    /** 
     * INTERLIS-Datenmodell
     */
    @NotNull
    private String model;
    /**
     * Zeitpunkt der letzten Publikation der Daten.
     * Den eigentlichen Nachführungsstand kennen wir nicht.
     * Aggregiert aus den den Nachführungsdaten der Items.
     */
    @NotNull
    private LocalDate lastPublishingDate;
    /**
     * Zeitpunkt der vorletzten Publikation. Damit man 
     * das "Gültigkeitsintervall" einer publizierten
     * Themenpublikation angeben kann.
     * Aggregiert aus den den Nachführungsdaten der Items.
     */
    @NotNull
    private LocalDate secondToLastPublishingDate = LocalDate.of(1848, 9, 12);
    /**
     * Sprechender Titel
     */
    @NotNull
    private String title;
    /**
     * Kurze Beschreibung. In SIMI auf 1000 Zeichen limitiert. Vorgabe
     * circa 500 Zeichen.
     */
    @JacksonXmlCData
    @NotNull
    private String shortDescription;
    /**
     * Schlüsselwörter
     */
    private String keywords;
    /**
     * Synonyme
     */
    private String synonyms;
    /**
     * Datenherr / zuständige Stelle
     */
    @NotNull
    private Office owner;
    /**
     * Verantwortliche technische Stelle
     */
    @NotNull
    private Office servicer; 
    /**
     * Link zu weiteren Informationen
     */
    private URI furtherInformation;
    /**
     * Lizenzbestimmungen und/oder Nutzungsbestimmungen
     */
    @NotNull
    private URI licence;
    /**
     * Basis-Url der Datenablage, z.B. https://data.geo.so.ch/
     * Die komplette Url der Themenpublikation ergibt sich
     * automatisch aus dem Identifier.
     */
    @NotNull
    private URI baseUrl;
    /**
     * Angebotene Datenformate
     */
    @JacksonXmlElementWrapper(localName = "fileFormats")
    @JacksonXmlProperty(localName = "fileFormat")
    @NotNull
    private List<FileFormat> fileFormats; 
    /**
     * Liste der vorhandenen Daten-Einheiten in 
     * der Themenpublikation. Jede Orthofoto-Kachel
     * entspricht einem Item. Für viele Datenthemen
     * gibt es nur ein Item (=Kanton).
     */
    @NotNull
    @JacksonXmlElementWrapper(localName = "items")
    @JacksonXmlProperty(localName = "item")
    private List<Item> items;
    /**
     * Informationen zu den Tabellen, inkl. die Beschreibung
     * der Attribute.
     */
    @JacksonXmlElementWrapper(localName = "tablesInfo")
    @JacksonXmlProperty(localName = "tableInfo")
    private List<TableInfo> tablesInfo; 
    /**
     * Informationen zu den Diensten, in welchen dieses
     * Thema in irgendeiner Form vorkommt.
     */
    @JacksonXmlElementWrapper(localName = "services")
    @JacksonXmlProperty(localName = "service")
    private List<Service> services;
    /** 
     * Boundingbox der Themenpublikation
     */
    private BoundingBox bbox;
    
    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public LocalDate getLastPublishingDate() {
        return lastPublishingDate;
    }
    public void setLastPublishingDate(LocalDate lastPublishingDate) {
        this.lastPublishingDate = lastPublishingDate;
    }
    public LocalDate getSecondToLastPublishingDate() {
        return secondToLastPublishingDate;
    }
    public void setSecondToLastPublishingDate(LocalDate secondToLastPublishingDate) {
        this.secondToLastPublishingDate = secondToLastPublishingDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getSynonyms() {
        return synonyms;
    }
    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }
    public Office getOwner() {
        return owner;
    }
    public void setOwner(Office owner) {
        this.owner = owner;
    }
    public Office getServicer() {
        return servicer;
    }
    public void setServicer(Office servicer) {
        this.servicer = servicer;
    }
    public URI getFurtherInformation() {
        return furtherInformation;
    }
    public void setFurtherInformation(URI furtherInformation) {
        this.furtherInformation = furtherInformation;
    }
    public URI getLicence() {
        return licence;
    }
    public void setLicence(URI licence) {
        this.licence = licence;
    }
    public URI getBaseUrl() {
        return baseUrl;
    }
    public void setBaseUrl(URI baseUrl) {
        this.baseUrl = baseUrl;
    }
    public List<FileFormat> getFileFormats() {
        return fileFormats;
    }
    public void setFileFormats(List<FileFormat> fileFormats) {
        this.fileFormats = fileFormats;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public List<TableInfo> getTablesInfo() {
        return tablesInfo;
    }
    public void setTablesInfo(List<TableInfo> tablesInfo) {
        this.tablesInfo = tablesInfo;
    }
    public List<Service> getServices() {
        return services;
    }
    public void setServices(List<Service> services) {
        this.services = services;
    }
    public BoundingBox getBbox() {
        return bbox;
    }
    public void setBbox(BoundingBox bbox) {
        this.bbox = bbox;
    }
}
